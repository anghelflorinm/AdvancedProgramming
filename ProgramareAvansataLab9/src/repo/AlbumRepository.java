package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;


import javax.persistence.*;
import java.util.Objects;
import java.util.List;


public class AlbumRepository {
    private EntityManager entityManager;

    public AlbumRepository() {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        entityManager = persistenceUtil.getEntityManager();
    }

    public void create(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
    }

    public Album findById(long Id) {
        Album album = entityManager.find(Album.class, Id);
        if (album == null) {
            throw new EntityNotFoundException("Can't find Album for ID "
                    + Id);
        }
        return album;
    }

    public Album findByName(String name) {
        Album album = (Album) entityManager.createNamedQuery("Album.findByName").setParameter("name", name).getSingleResult();
        if (album == null) {
            throw new EntityNotFoundException("Can't find Album for name "
                    + name);
        }
        return album;
    }

    public List<Album> findByArtist(Artist artist) {
        List<Album> albumsList = entityManager.createNamedQuery("Album.findByArtist").setParameter("id", artist.getId()).getResultList();
        return albumsList;
    }

}
