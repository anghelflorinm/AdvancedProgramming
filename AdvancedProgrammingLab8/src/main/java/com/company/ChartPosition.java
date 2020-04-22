package com.company;

public class ChartPosition {
    private int chartId;
    private int albumId;
    private int position;

    public ChartPosition(int chartId, int albumId, int position) {
        this.chartId = chartId;
        this.albumId = albumId;
        this.position = position;
    }

    public int getChartId() {
        return chartId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getPosition() {
        return position;
    }
}
