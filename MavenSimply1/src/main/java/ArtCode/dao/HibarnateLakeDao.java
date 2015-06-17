package ArtCode.dao;

import ArtCode.lakeANDfish.Lake;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class HibarnateLakeDao implements LakeDao{

    private static final Logger LOG = Logger.getLogger(HibarnateLakeDao.class);
    private EntityManagerFactory factory;
    private EntityManager manager;

    public HibarnateLakeDao(EntityManagerFactory factory, EntityManager manager) {
        this.factory = factory;
        this.manager = manager;
    }


    public Lake findLakeByName(String nameLake) {
        return null;
    }


    public Lake findLakeByFish(String nameFish) {
        manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT l FROM Lake l WHERE l.fishList like : nameFish");

        return (Lake) query.setParameter("nameFish", nameFish).getSingleResult();
    }

    public Lake createHimLake(Lake lakeName) {
        manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(lakeName);
            transaction.commit();
        }
        catch (Exception e){
            LOG.error(e);
            transaction.rollback();
        }
        manager.close();
        return null;
    }

    public List<Lake> showAllLakes(String name) {
        manager = factory.createEntityManager();
        return manager
                .createQuery("SELECT p From Lake p WHERE p.name like : name", Lake.class)
                .setParameter("name", name)
                .setFirstResult(0)
                .setMaxResults(5)
                .getResultList();
    }
}

