package repo;

public class JPAFactory extends AbstractFactory{
    @Override
    public AlbumHandler produceAlbumHandler() {
        return new AlbumRepository();
    }
}
