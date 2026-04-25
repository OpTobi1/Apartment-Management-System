// Assignment: 3
// Author: Liav Lugasi, ID: 213007271

package ex2apartments;

/**
 * Represents a garden apartment.
 * * @author Liav Lugasi, ID: 213007271
 */
public class GardenApartment extends Apartment {
    private int gardenArea;
    private  boolean pool;

    /**
     * Constructs a new GardenApartment.
     * * @param num     The apartment number.
     * @param area       The interior area of the apartment.
     * @param sold     The sale status.
     * @param gardenArea The area of the garden in square meters.
     * @param pool    Indicates whether the garden has a pool.
     */
    public GardenApartment(int num, int area, boolean sold, int gardenArea, boolean pool){
        super(num, area, sold);
        this.gardenArea = gardenArea;
        this.pool = pool;
    }

    /**
     * Copy constructor for GardenApartment.
     * * @param other The GardenApartment object to copy.
     */
    public GardenApartment(GardenApartment other) {
        super(other);
        this.gardenArea = other.gardenArea;
        this.pool = other.pool;
    }

    /**
     * Calculates the price of the garden apartment.
     * Formula: Base price + 80,000 + (1000 per garden sq.m) + 100,000 if there is a pool.
     * * @return The calculated price.
     */
    @Override
    public int getPrice() {
        int total = price + 80000 + (gardenArea * 1000);
        if(pool){
            total += 100000;
        }
        return total;
    }

    /**
     * Adds a pool to the garden apartment.
     */
    public void addPool() {
        this.pool = true;
    }

    /**
     * Checks if the garden has a pool.
     * * @return true if there is a pool, false otherwise.
     */
    public boolean hasPool() {
        return pool;
    }

    /**
     * Returns a string representation of the garden apartment.
     * * @return A string detailing the garden area and pool status.
     */
    @Override
    public String toString() {
        return super.toString() + ", Type: Garden, Garden Area: " + gardenArea + ", Pool: " + pool;
    }

}
