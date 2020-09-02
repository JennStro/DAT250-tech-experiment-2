import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.List;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany
    @JoinTable(name = "bank_credit_card")
    private List<CreditCard> creditcards;

    public Bank() {}

    public Bank(String name, CreditCard ... creditCards) {
        this.name = name;
        this.creditcards = Arrays.asList(creditCards);
    }

    public String getName() {
        return name;
    }

    public void setCreditcards(CreditCard ... creditcards) {
        this.creditcards = Arrays.asList(creditcards);
    }

    public List<CreditCard> getCreditcards() {
        return creditcards;
    }

    public void setName(String name) {
        this.name = name;
    }
}