// Assignment: 3
// Author: Liav Lugasi, ID: 213007271

package ex2apartments;
import java.util.Arrays;

/**
 * Represents a standard apartment in a building.
 * A standard apartment can have up to 2 balconies.
 * * @author [Your Name] [Your ID]
 */
public class StandardApartment extends Apartment {
    private int[] balconies;
    private int numBalconies;

    /**
     * Constructs a new StandardApartment.
     * * @param number       The apartment number.
     * @param area         The area of the apartment in square meters.
     * @param sold       The sale status of the apartment.
     * @param numBalconies The number of balconies (maximum 2).
     * @param balconies    An array containing the areas of the balconies.
     */
    public StandardApartment(int number, int area, boolean sold, int numBalconies, int[] balconies) {
        super(number, area, sold);
        this.numBalconies = Math.min(numBalconies, 2); // Enforce max 2 balconies
        this.balconies = new int[this.numBalconies];
        for (int i = 0; i < this.numBalconies; i++) {
            this.balconies[i] = balconies[i];
        }
    }

    /**
     * Copy constructor for StandardApartment.
     * * @param other The StandardApartment object to copy.
     */
    public StandardApartment(StandardApartment other) {
        super(other);
        this.numBalconies = other.numBalconies;
        this.balconies = Arrays.copyOf(other.balconies, other.balconies.length);
    }

    /**
     * Calculates the price of the standard apartment.
     * Formula: Base price + 12,000 NIS for each balcony.
     * * @return The calculated price.
     */
    @Override
    public int getPrice() {
        return price + (12000 * numBalconies);
    }

    /**
     * Gets the number of balconies in the apartment.
     * * @return The number of balconies.
     */
    public int getNumBalconies() {
        return numBalconies;
    }

    /**
     * Returns a string representation of the standard apartment.
     * * @return A string detailing the apartment's specific properties.
     */
    @Override
    public String toString() {
        return super.toString() + ", Type: Standard, Balconies: " + numBalconies + " " + Arrays.toString(balconies);
    }
}
