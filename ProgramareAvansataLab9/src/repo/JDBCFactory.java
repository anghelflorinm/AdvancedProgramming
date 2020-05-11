package repo;

public class JDBCFactory extends AbstractFactory{

    @Override
    public AlbumHandler produceAlbumHandler() {
        return new AlbumController();
    }
}
