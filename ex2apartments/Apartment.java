// Assignment: 3
// Author: Liav Lugasi, ID: 213007271

package ex2apartments;

/**
 * An abstract class representing a general apartment in the system.
 * Serves as a base class for specific types of apartments.
 * * @author Liav Lugasi, ID: 213007271
 */
public abstract class Apartment {
    protected int num;
    protected int area;
    protected boolean sold;
    protected int price = 700000;

    /**
     * Constructs a new Apartment.
     * * @param number The apartment number.
     * @param area   The area of the apartment in square meters.
     * @param sold The initial sale status of the apartment (true if sold, false otherwise).
     */
    public Apartment(int num, int area, boolean sold) {
        this.num = num;
        this.area = area;
        this.sold = sold;
    }

    /**
     * Copy constructor. Creates a new Apartment based on an existing one.
     * * @param other The Apartment object to copy.
     */
    public Apartment(Apartment other){
        this.num = other.num;
        this.area = other.area;
        this.sold = other.sold;
        this.price = other.price;
    }

    /**
     * Calculates and returns the final price of the apartment.
     * This is an abstract method that must be implemented by subclasses.
     * * @return The final price of the apartment in NIS.
     */
    public abstract int getPrice();

    /**
     * Checks if the apartment is sold.
     * * @return true if the apartment is sold, false otherwise.
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * Marks the apartment as sold.
     */
    public void markAsSold(){
        this.sold = true;
    }

    /**
     * Gets the apartment number.
     * * @return The apartment number.
     */
    public int getNum() {
        return num;
    }

    /**
     * Returns a string representation of the apartment.
     * * @return A string containing the apartment's details.
     */
    @Override
    public String toString(){
        return "Apartment Number: " + num + ", Area: " + area + " sq.m, Price: " + getPrice() + ", Sold: " + sold;
    }
}
