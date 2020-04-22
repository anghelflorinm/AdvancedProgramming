package util;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

public class PersistenceUtil {
    private static PersistenceUtil single_instance = null;
    private EntityManager entityManager = null;

    public static PersistenceUtil getInstance() {
        if (single_instance == null)
            single_instance = new PersistenceUtil();

        return single_instance;
    }

    public PersistenceUtil() {
        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.configure();
        configuration.buildSessionFactory();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
