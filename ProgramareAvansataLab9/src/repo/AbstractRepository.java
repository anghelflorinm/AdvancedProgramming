package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;

public class AbstractRepository<T> {
    private EntityManager entityManager;
    private Class<T> callClass;

    public AbstractRepository(Class<T> cls) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        entityManager = persistenceUtil.getEntityManager();
        callClass = cls;
    }

    public void create(T t){
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }
    public T findById(long Id) {
        T t = entityManager.find(callClass, Id);
        if (t == null) {
            throw new EntityNotFoundException("Can't find Album for ID "
                    + Id);
        }
        return t;
    }

    public T findByName(String name) {
        String queryName = callClass.getSimpleName() + ".findByName";
        T t = (T) entityManager.createNamedQuery(queryName).setParameter("name", name).getSingleResult();
        if (t == null) {
            throw new EntityNotFoundException("Can't find Artist for name "
                    + name);
        }
        return t;
    }

}
