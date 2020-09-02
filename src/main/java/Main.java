
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "bankdb";
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Person person = new Person();
        person.setFirstName("Espen");
        person.setLastName("Strommen");
        Bank bank = new Bank();
        bank.setName("SpV");

        entityManager.persist(person);
        entityManager.persist(bank);
        entityManager.getTransaction().commit();

        Query query = entityManager.createQuery("select p from Person p");
        List<Person> persons = query.getResultList();
        Query bankQuery = entityManager.createQuery("select b from Bank b");
        List<Bank> banks =  bankQuery.getResultList();

        for (Person personQuery : persons) {
            System.out.println(personQuery);
        }

        for (Bank bankResult : banks) {
            System.out.println(bankResult);
        }

        entityManager.close();
    }
}
