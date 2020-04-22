package com.company;

public class ChartName {
    private int chartId;
    private String name;

    public ChartName(int chartId, String name) {
        this.chartId = chartId;
        this.name = name;
    }

    public int getChartId() {
        return chartId;
    }

    public String getName() {
        return name;
    }
}
