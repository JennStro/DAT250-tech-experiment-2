
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

        /*
        Person person = new Person();
        person.setFirstName("Jenny");
        person.setLastName("Strommen");

        Bank bank = new Bank();
        bank.setName("SpV");

        Pincode pincode = new Pincode();
        pincode.setPincode("1234");
        pincode.setCount(1);

        CreditCard creditCard = new CreditCard();
        creditCard.setBank(bank);
        creditCard.setPincode(pincode);
        creditCard.setNumber(12341234);
        creditCard.setBalance(1000);
        creditCard.setLimit(15000);

        bank.setCreditcards(creditCard);

        person.setCreditCards(creditCard);

        Address address = new Address();
        address.setNumber(12);
        address.setStreet("Holbergs gate");

        person.setAddresses(address);

         */

        Factory factory = new Factory();

        for (Person randomPerson : factory.createPersons(5)) {
            entityManager.persist(randomPerson);
        }

        for (int i = 0; i < 5; i++) {
            entityManager.persist(factory.createBank());
        }

        //entityManager.persist(person);
        //entityManager.persist(bank);
        entityManager.getTransaction().commit();

        Query personQuery = entityManager.createQuery("select p from Person p");
        List<Person> persons = personQuery.getResultList();
        Query bankQuery = entityManager.createQuery("select b from Bank b");
        List<Bank> banks =  bankQuery.getResultList();
        Query creditCardQuery = entityManager.createQuery("select c from CreditCard c");
        List<CreditCard> creditCards = creditCardQuery.getResultList();

        for (Person personResult : persons) {
            System.out.println(personResult);
        }

        for (Bank bankResult : banks) {
            System.out.println(bankResult);
        }

        for (CreditCard creditCardResult : creditCards) {
            System.out.println(creditCardResult);
        }

        entityManager.close();
    }
}
