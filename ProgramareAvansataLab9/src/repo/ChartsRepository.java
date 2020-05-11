package repo;

import entity.Album;
import entity.ChartNames;
import entity.ChartPosition;
import util.PersistenceUtil;

import javax.persistence.EntityManager;

public class ChartsRepository {
    private EntityManager entityManager;

    public ChartsRepository() {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        entityManager = persistenceUtil.getEntityManager();
    }

    public ChartNames findByPosition(long position){
        ChartPosition chartPosition = (ChartPosition)entityManager.createNamedQuery("Album.findByArtist").setParameter("id", position).getSingleResult();
        return entityManager.find(ChartNames.class, chartPosition.getChartId());
    }
}
