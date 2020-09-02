
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Manager {

    private final String PERSISTENCE_UNIT_NAME = "bankdb";
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public Manager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void addPerson(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void addCreditCard(CreditCard card) {
        entityManager.getTransaction().begin();
        entityManager.persist(card);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void addBank(Bank bank) {
        entityManager.getTransaction().begin();
        entityManager.persist(bank);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
