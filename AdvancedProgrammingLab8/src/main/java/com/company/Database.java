package com.company;

import java.sql.*;

public class Database {
    private static Database single_instance = null;
    private Connection connection;
    public static Database getInstance() {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }

    private Database() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","STUDENT","STUDENT");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void execute(String query){
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet executeQuery(String query){
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

