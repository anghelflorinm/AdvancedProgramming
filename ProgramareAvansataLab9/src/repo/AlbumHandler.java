package repo;

import entity.Album;
import entity.Artist;

import java.util.List;

public interface AlbumHandler {
    public void create(Album album);
    public Album findById(long Id);
    public Album findByName(String name);
    public List<Album> findByArtist(Artist artist);
}
