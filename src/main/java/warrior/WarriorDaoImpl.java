package warrior;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WarriorDaoImpl implements WarriorDao {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public WarriorDaoImpl() {
        emFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = emFactory.createEntityManager();
    }

    @Override
    public void save(Warrior warrior) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(warrior);
        tx.commit();
    }

    @Override
    public Warrior get(Long id) {
        Warrior warrior = entityManager.find(Warrior.class, id);
        return warrior;
    }

    public List<Warrior> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Warrior> cq = cb.createQuery(Warrior.class);
        Root<Warrior> rootEntry = cq.from(Warrior.class);
        CriteriaQuery<Warrior> all = cq.select(rootEntry);

        TypedQuery<Warrior> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
