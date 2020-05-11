package AlbumManager;

import entity.Album;
import entity.Artist;
import repo.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class AlbumManager {
    public static void main(String[] args) {
       /* AlbumRepository albumRepository = new AlbumRepository();
        ArtistRepository artistRepository = new ArtistRepository();
        Artist artist = artistRepository.findById(204);
        List<Album> albums = albumRepository.findByArtist(artist);
        Artist klimt = artistRepository.findByName("Klimt");*/
       /* AbstractRepository<Artist> artistRepository= new AbstractRepository<>(Artist.class);
        Artist klimt = artistRepository.findByName("Klimt");*/
       String config = null;
        try {
            Scanner scanner = new Scanner(new File("src\\AlbumManager\\config.txt"));
            while (scanner.hasNextLine()) {
               config =  scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AlbumHandler albumHandler;
        AbstractFactory abstractFactory;
        if(config.equals("JPA")){
            abstractFactory = new JPAFactory();
        }
        else{
            abstractFactory = new JDBCFactory();
        }

        albumHandler = abstractFactory.produceAlbumHandler();
        Album album = albumHandler.findByName("CAT");
        return;
    }
}
