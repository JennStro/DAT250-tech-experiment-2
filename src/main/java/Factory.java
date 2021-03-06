import java.util.ArrayList;
import java.util.Random;

public class Factory {

    private Random random = new Random();
    private String[] firstNames = {"Ola", "Hege", "Vilde", "Espen", "Helge"};
    private String[] lastNames = {"Hermansen", "Navnesen", "Bjørnestad", "Olafsen"};
    private String[] streets = {"Holbergsgaten", "Allegaten", "Nygårdsgaten"};
    private String[] banks = {"Sparebanken Vest", "Den Norske Bank", "Danske Bank", "Sparebanken Sør"};

    public Person[] createPersons(int numberOfPersons) {
        Person[] persons = new Person[numberOfPersons];
        for (int i = 0; i < numberOfPersons; i++) {
            Person person = new Person();
            person.setFirstName(firstNames[random.nextInt(firstNames.length)]);
            person.setLastName(lastNames[random.nextInt(lastNames.length)]);
            person.setAddresses(createAddresses(random.nextInt(5)));
            person.setCreditCards(createCreditCards(random.nextInt(5), createBank()));
            persons[i] = person;
        }
        return persons;
    }

    public Address[] createAddresses(int numberOfAddresses) {
        Address[] addresses = new Address[numberOfAddresses];
        for (int i = 0; i < numberOfAddresses; i++) {
            Address address = new Address();
            address.setStreet(streets[random.nextInt(streets.length)]);
            address.setNumber(i + random.nextInt(5));
            addresses[i] = address;
        }
        return addresses;
    }

    public CreditCard[] createCreditCards(int numberOfCards, Bank bank) {
        CreditCard[] creditCards = new CreditCard[numberOfCards];
        for (int i = 0; i < numberOfCards; i++) {
            CreditCard creditCard = new CreditCard();
            creditCard.setLimit(random.nextInt(200));
            creditCard.setBalance(random.nextInt(200));
            creditCard.setNumber(random.nextInt(14));
            creditCard.setPincode(createPincode());
            creditCard.setBank(bank);
            creditCards[i] = creditCard;
        }
        return creditCards;
    }

    public Bank createBank() {
        Bank bank = new Bank();
        bank.setName(banks[random.nextInt(banks.length)]);
        bank.setCreditcards(createCreditCards(5, bank));
        return bank;
    }

    public Pincode createPincode() {
        Pincode pincode = new Pincode();
        pincode.setCount(random.nextInt(100));
        pincode.setPincode("1234");
        return pincode;
    }

}
