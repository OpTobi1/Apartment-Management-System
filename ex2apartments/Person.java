// Assignment: 3
// Author: Liav Lugasi, ID: 213007271

package ex2apartments;
import java.util.Arrays;

/**
 * Represents a person who can own multiple apartments.
 * * @author [Your Name] [Your ID]
 */
public class Person {
    private String firstName;
    private String lastName;
    private Apartment[] ownedApartments;

    /**
     * Constructs a new Person with an empty portfolio of apartments.
     * * @param firstName The person's first name.
     * @param lastName  The person's last name.
     */
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownedApartments = new Apartment[0];
    }

    /**
     * Copy constructor for Person.
     * * @param other The Person object to copy.
     */
    public Person(Person other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.ownedApartments = Arrays.copyOf(other.ownedApartments, other.ownedApartments.length);
    }

    /**
     * Adds an apartment to the person's ownership portfolio.
     * Dynamically resizes the array to accommodate the new apartment.
     * * @param apt The apartment to add.
     */
    public void addApartment(Apartment apt) {
        Apartment[] newArray = Arrays.copyOf(ownedApartments, ownedApartments.length + 1);
        newArray[newArray.length - 1] = apt;
        ownedApartments = newArray;
    }

    /**
     * Calculates the total financial value of all apartments owned by the person.
     * * @return The total property value in NIS.
     */
    public long getTotalPropertyValue() {
        long total = 0;
        for (Apartment apt : ownedApartments) {
            if (apt != null) {
                total += apt.getPrice();
            }
        }
        return total;
    }

    /**
     * Gets the first name of the person.
     * * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the person.
     * * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the array of apartments owned by the person.
     * * @return The array of owned apartments.
     */
    public Apartment[] getOwnedApartments() {
        return ownedApartments;
    }

    /**
     * Prints the details of the owner and all their owned properties,
     * including the total calculated value of their portfolio.
     */
    public void printOwnershipDetails() {
        System.out.println("Owner: " + firstName + " " + lastName);
        for (Apartment apt : ownedApartments) {
            if (apt != null) {
                System.out.println(apt);
            }
        }
        System.out.println("Total Property Value: " + getTotalPropertyValue());
    }
}
