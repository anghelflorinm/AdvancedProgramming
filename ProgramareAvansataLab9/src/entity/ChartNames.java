package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity

@Table(name = "CHART_NAMES", schema = "STUDENT", catalog = "")
public class ChartNames {
    private long chartId;
    private String name;

    @Id
    @Column(name = "CHART_ID")
    public long getChartId() {
        return chartId;
    }

    public void setChartId(long chartId) {
        this.chartId = chartId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartNames that = (ChartNames) o;
        return chartId == that.chartId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chartId, name);
    }
}
