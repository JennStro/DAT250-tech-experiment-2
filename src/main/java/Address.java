import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private int number;

    @ManyToMany(mappedBy = "addresses")
    private List<Person> persons;

    public Address() {}

    public Address(String street, int number, Person ... persons) {
        this.street = street;
        this.number = number;
        this.persons = Arrays.asList(persons);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(Person ... persons) {
        this.persons = Arrays.asList(persons);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}