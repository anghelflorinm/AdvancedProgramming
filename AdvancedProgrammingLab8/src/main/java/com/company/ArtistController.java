package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistController {
    Database database;

    public ArtistController() {
        this.database = Database.getInstance();
    }

    public void create(String name, String country) {
        String query = "INSERT INTO artists (name, country) VALUES ('" + name + "', '" + country + "')";
        database.execute(query);
    }

    public void findByName(String name) {
        String query = "SELECT name, country FROM artists where name='" + name + "'";
        ResultSet resultSet = database.executeQuery(query);
        if (resultSet == null) {
            return;
        }
        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("country"));
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public float computeScore(int artistId){
        String query = "SELECT AVG((10000 - 5*c.position)) from artists ar join albums al on ar.id = al.artist_id join chart_position c on al.id = c.album_id where ar.id=" + artistId;
        float score = 0;
        ResultSet resultSet = database.executeQuery(query);
        try {
            while (resultSet.next()) {
                score = resultSet.getFloat(1);
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return score;
    }

    public List<Artist> getArtists(){
        List<Artist> artists = new ArrayList<>();
        String query = "SELECT *from artists";
        ResultSet resultSet = database.executeQuery(query);
        try {
            while (resultSet.next()) {
                artists.add(new Artist(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("country")));
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artists;
    }
}
