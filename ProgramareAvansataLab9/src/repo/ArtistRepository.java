package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;


import javax.persistence.*;
import java.util.Objects;
import java.util.List;


public class ArtistRepository {
    private EntityManager entityManager;

    public ArtistRepository() {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        entityManager = persistenceUtil.getEntityManager();
    }

    public void create(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
    }

    public Artist findById(long Id) {
        Artist artist = entityManager.find(Artist.class, Id);
        if (artist == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + Id);
        }
        return artist;
    }

    public Artist findByName(String name) {
        Artist artist = (Artist) entityManager.createNamedQuery("Artist.findByName").setParameter("name", name).getSingleResult();
        if (artist == null) {
            throw new EntityNotFoundException("Can't find Artist for name "
                    + name);
        }
        return artist;
    }


}
