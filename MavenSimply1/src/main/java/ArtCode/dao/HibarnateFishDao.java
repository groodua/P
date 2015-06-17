package ArtCode.dao;

import ArtCode.lakeANDfish.Fish;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class HibarnateFishDao implements FishDao {

    private static final Logger LOG = Logger.getLogger(HibarnateFishDao.class);
    private EntityManagerFactory factory;
    private EntityManager manager;

    public Fish createNewFish(String name) {
        manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try{
            transaction.begin();
            manager.persist(name);
            transaction.commit();
        }catch (Exception e){
            LOG.error(e);
            transaction.rollback();
        }
        manager.close();
        return null;
    }

    public Fish deleteFish(String name) {
        manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.remove(name);
            transaction.commit();
        } catch (Exception e) {
            LOG.error(e);
            transaction.rollback();
        }
        manager.close();
        return null;
    }

    public List<Fish> showAll() {
        manager = factory.createEntityManager();
        TypedQuery <Fish> query = manager.createQuery("SELECT p FROM Fish p", Fish.class);
        List<Fish> all = query.getResultList();
        return all;
    }
}
