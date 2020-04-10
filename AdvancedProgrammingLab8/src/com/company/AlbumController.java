package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
