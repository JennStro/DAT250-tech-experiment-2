import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.List;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "bank", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<CreditCard> creditcards;

    public String getName() {
        return name;
    }

    public void setCreditcards(CreditCard ... creditcards) {
        this.creditcards = Arrays.asList(creditcards);
    }

    public List<CreditCard> getCreditcards() {
        return creditcards;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
