package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ALBUMS", schema = "STUDENT", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Album.findByName",
                query = "SELECT p FROM Album p WHERE p.name=:name"),
        @NamedQuery(name = "Album.findByArtist",
                query = "SELECT p FROM Album p WHERE p.artistID=:id")
})
public class Album implements Serializable {
    private long id;
    private String name;
    private Long releaseYear;
    private long artistID;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ARTIST_ID")
    public long getArtistID() {
        return artistID;
    }

    public void setArtistID(long artistID) {
        this.artistID = artistID;
    }


    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "RELEASE_YEAR")
    public Long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id == album.id &&
                Objects.equals(name, album.name) &&
                Objects.equals(releaseYear, album.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseYear);
    }
}
