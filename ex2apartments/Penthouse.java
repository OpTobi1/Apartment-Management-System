// Assignment: 3
// Author: Liav Lugasi, ID: 213007271

package ex2apartments;

/**
 * Represents a penthouse apartment.
 * * @author Liav Lugasi, ID: 213007271
 */
public class Penthouse extends Apartment {
    private int balconyArea;

    /**
     * Constructs a new Penthouse.
     * * @param num      The apartment number.
     * @param area        The interior area of the penthouse.
     * @param sold      The sale status.
     * @param balconyArea The total area of the balconies.
     */
    public Penthouse(int num, int area, boolean sold, int balconyArea){
        super(num, area, sold);
        this.balconyArea = balconyArea;
    }

    /**
     * Copy constructor for Penthouse.
     * * @param other The Penthouse object to copy.
     */
    public Penthouse(Penthouse other){
        super(other);
        this.balconyArea = other.balconyArea;
    }

    /**
     * Calculates the price of the penthouse.
     * Formula: Base price + (interior area * 3000) + (balcony area * 2000).
     * * @return The calculated price.
     */
    @Override
    public int getPrice(){
        return price + (area * 3000) + (balconyArea * 2000);
    }

    /**
     * Checks if the penthouse qualifies as a luxury penthouse.
     * A luxury penthouse must have an interior area > 200 and a balcony area > 50.
     * * @return true if it is luxury, false otherwise.
     */
    public boolean isLuxury() {
        return area > 200 && balconyArea > 50;
    }

    /**
     * Returns a string representation of the penthouse.
     * * @return A string detailing the penthouse's properties.
     */
    @Override
    public String toString() {
        return super.toString() + ", Type: Penthouse, Balcony Area: " + balconyArea;
    }
}
