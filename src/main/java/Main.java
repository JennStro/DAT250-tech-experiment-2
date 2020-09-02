
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "persons";
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Person person = new Person();
        person.setFirstName("Jenny");
        person.setLastName("Strommen");

        entityManager.persist(person);
        entityManager.getTransaction().commit();

        Query query = entityManager.createQuery("select p from Person p");
        List<Person> persons = query.getResultList();

        for (Person personQuery : persons) {
            System.out.println(personQuery);
        }



        entityManager.close();
    }
}
