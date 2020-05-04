package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ChartPositionPK implements Serializable {
    private long chartId;
    private long albumId;
    private long position;

    @Column(name = "CHART_ID")
    @Id
    public long getChartId() {
        return chartId;
    }

    public void setChartId(long chartId) {
        this.chartId = chartId;
    }

    @Column(name = "ALBUM_ID")
    @Id
    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    @Column(name = "POSITION")
    @Id
    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartPositionPK that = (ChartPositionPK) o;
        return chartId == that.chartId &&
                albumId == that.albumId &&
                position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chartId, albumId, position);
    }
}
