package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChartsController {
    Database database;

    public ChartsController() {
        database = Database.getInstance();
    }

    public void createChart(String name){
        String query  = "INSERT INTO CHART_NAMES (name) VALUES ('" + name + "')";
        database.execute(query);
    }

    public List<ChartName> getCharts(){
        List<ChartName> chartNames = new ArrayList<>();
        String query = "SELECT *from chart_names";
        ResultSet resultSet = database.executeQuery(query);
        try {
            while (resultSet.next()) {
                chartNames.add(new ChartName(resultSet.getInt("chart_id"), resultSet.getString("name")));
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chartNames;
    }
    public void insertChartPosition(int chartId, int albumId){
        int maxPosition = getMaxPosition(chartId) + 1;
        String query  = "INSERT INTO CHART_POSITION VALUES (" + chartId + "," + albumId + "," + maxPosition + ")";
        database.execute(query);
    }
    private int getMaxPosition(int chartId){
        String query = "SELECT MAX(position) from chart_position where chart_id=" + chartId;
        int maxPosition = 0;
        ResultSet resultSet = database.executeQuery(query);
        try {
            while (resultSet.next()) {
                maxPosition = resultSet.getInt(1);
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxPosition;
    }
    public List<ChartPosition> getChartPositions(){
        List<ChartPosition> chartPositions = new ArrayList<>();
        String query = "SELECT * from chart_positions";
        ResultSet resultSet = database.executeQuery(query);
        try {
            while (resultSet.next()) {
                chartPositions.add(new ChartPosition(resultSet.getInt("chart_id"), resultSet.getInt("album_id"), resultSet.getInt("position")));
            }
            resultSet.close();
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chartPositions;
    }
}
