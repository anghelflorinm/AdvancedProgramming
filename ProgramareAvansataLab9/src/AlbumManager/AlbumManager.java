package AlbumManager;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

import java.util.List;

public class AlbumManager {
    public static void main(String[] args) {
        AlbumRepository albumRepository = new AlbumRepository();
        ArtistRepository artistRepository = new ArtistRepository();
        Artist artist = artistRepository.findById(204);
        List<Album> albums = albumRepository.findByArtist(artist);
        Artist klimt = artistRepository.findByName("Klimt");
        return;
    }
}
