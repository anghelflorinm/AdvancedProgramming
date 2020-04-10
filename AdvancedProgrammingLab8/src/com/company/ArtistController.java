package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
