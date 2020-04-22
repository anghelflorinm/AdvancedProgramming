package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumController {
    Database database;

    public AlbumController() {
        database = Database.getInstance();
    }

    public void create(String name, int artistId, int releaseYear){
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
                albums.add(new Album(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("artist_id"), resultSet.getInt("release_year")));
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }
}
