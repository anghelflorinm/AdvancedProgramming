package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Charts.findByPosiiton",
                query = "SELECT p FROM ChartPosition p WHERE p.position=:position"),
        @NamedQuery(name = "Album.findByArtist",
                query = "SELECT p FROM Album p WHERE p.artistID=:id")
})
@Table(name = "CHART_POSITION", schema = "STUDENT", catalog = "")
@IdClass(ChartPositionPK.class)
public class ChartPosition {
    private long chartId;
    private long albumId;
    private long position;

    @Id
    @Column(name = "CHART_ID")
    public long getChartId() {
        return chartId;
    }

    public void setChartId(long chartId) {
        this.chartId = chartId;
    }

    @Id
    @Column(name = "ALBUM_ID")
    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    @Id
    @Column(name = "POSITION")
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
        ChartPosition that = (ChartPosition) o;
        return chartId == that.chartId &&
                albumId == that.albumId &&
                position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chartId, albumId, position);
    }
}
