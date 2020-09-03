import java.util.ArrayList;
import java.util.Random;

public class Factory {

    private Random random = new Random();
    private String[] firstNames = {"Ola", "Hege", "Vilde", "Espen", "Helge"};
    private String[] lastNames = {"Hermansen", "Navnesen", "Bjørnestad", "Olafsen"};
    private String[] streets = {"Holbergsgaten", "Allegaten", "Nygårdsgaten"};

    public Person[] createPersons(int numberOfPersons) {
        Person[] persons = new Person[numberOfPersons];
        for (int i = 0; i < numberOfPersons; i++) {
            Person person = new Person();
            person.setFirstName(firstNames[random.nextInt(firstNames.length)]);
            person.setLastName(lastNames[random.nextInt(lastNames.length)]);
            person.setAddresses(createAddresses(random.nextInt(5)));
            person.setCreditCards();
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

    public CreditCard[] createCreditCards(int numberOfCards) {
        CreditCard[] creditCards = new CreditCard[numberOfCards];
        for (int i = 0; i < numberOfCards; i++) {
            CreditCard creditCard = new CreditCard();
            creditCard.setLimit(random.nextInt(20000));
            creditCard.setBalance(random.nextInt(20000));
            creditCard.setNumber(random.nextInt(1234));
            creditCard.setPincode();
            creditCard.setBank();
        }
    }

    public Pincode[] createPincode(int numberOfPins) {
        Pincode[] pincodes = new Pincode[numberOfPins];
        for (int i = 0; i < numberOfPins; i++) {
            Pincode pincode = new Pincode();
            pincode.setCount(random.nextInt(100));
            pincode.setPincode(generatePin());
            pincodes[i] = pincode;
        }
        return pincodes;
    }

    private String generatePin() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(String.valueOf(random.nextInt(9)));
        }
        return builder.toString();
    }

}
