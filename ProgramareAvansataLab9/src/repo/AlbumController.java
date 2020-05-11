package repo;

import com.company.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Album;
import entity.Artist;

public class AlbumController implements AlbumHandler{
    Database database;

    public AlbumController() {
        database = Database.getInstance();
    }

    public void create(String name, long artistId, long releaseYear){
        String query = "INSERT INTO albums (name, artist_id, release_year) VALUES ('" + name + "', " + artistId + ", " + releaseYear + ")";
        database.execute(query);
    }

    public void findByArtist(int artistId){
        String query = "SELECT name, release_year FROM albums where artist_id=" + artistId;
        ResultSet resultSet = database.executeQuery(query);
        if (resultSet == null) {
            return;
        }
        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("release_year"));
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getArtistId(int albumId){
        String query = "select artist_id from albums where id="+albumId;
        int artistId = 0;
        ResultSet resultSet = database.executeQuery(query);
        try {
            while (resultSet.next()) {
                artistId = resultSet.getInt(1);
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artistId;
    }

    public List<Album> getAlbums(){
        List<Album> albums = new ArrayList<>();
        String query = "SELECT * from albums";
        ResultSet resultSet = database.executeQuery(query);
        try {
            while (resultSet.next()) {
                albums.add(new Album(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("artist_id"), (long)resultSet.getInt("release_year")));
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    @Override
    public void create(Album album) {
        create(album.getName(), album.getArtistID(), album.getReleaseYear());
    }

    @Override
    public Album findById(long Id) {
        String query = "SELECT * FROM albums where id=" + Id;
        ResultSet resultSet = database.executeQuery(query);
        if (resultSet == null) {
            return null;
        }
        Album album = null;
        try {
            while (resultSet.next()) {
               album = new Album(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("artist_id"), (long)resultSet.getInt("release_year"));
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    @Override
    public Album findByName(String name) {
        String query = "SELECT * FROM albums where name=" +"'" + name + "'";
        ResultSet resultSet = database.executeQuery(query);
        if (resultSet == null) {
            return null;
        }
        Album album = null;
        try {
            while (resultSet.next()) {
                album = new Album(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("artist_id"), (long)resultSet.getInt("release_year"));
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    @Override
    public List<Album> findByArtist(Artist artist) {
        String query = "SELECT * FROM albums where artist_id=" + artist.getId();
        ResultSet resultSet = database.executeQuery(query);
        List<Album> albums = new ArrayList<>();
        if (resultSet == null) {
            return null;
        }
        try {
            while (resultSet.next()) {
                albums.add(new Album(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("artist_id"), (long)resultSet.getInt("release_year")));
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }
}
