// Assignment: 3
// Author: Liav Lugasi, ID: 213007271

package ex2apartments;

/**
 * Represents a residential building containing various apartments.
 * * @author Liav Lugasi, ID: 213007271
 */
public class Building{
    private String address;
    private  int floors;
    private  Apartment[] apartments;

    /**
     * Constructs a new Building.
     * * @param address    The address of the building.
     * @param apartments An array of apartments located in the building.
     */
    public Building(String address, Apartment[] apartments){
        this.address = address;
        this.apartments = new Apartment[apartments.length];
        for(int i = 0; i < apartments.length; i++ ){
            this.apartments[i] = apartments[i];
        }
    }

    /**
     * Copy constructor for Building.
     * Performs a deep copy of the building's attributes.
     * * @param other The Building object to copy.
     */
    public Building(Building other){
        this.address = other.address;
        this.apartments = new Apartment[other.apartments.length];
        for(int i = 0; i < other.apartments.length; i++){
            this.apartments[i] = other.apartments[i];
        }
    }

    /**
     * Gets the address of the building.
     * * @return The building address.
     */
    public String getAddress(){
        return address;
    }

    /**
     * Gets the array of apartments in the building.
     * * @return The array of apartments.
     */
    public Apartment[] getApartments() {
        return apartments;
    }

    /**
     * Finds and returns an apartment by its number.
     * * @param num The apartment number to search for.
     * @return The Apartment object if found, null otherwise.
     */
    public Apartment findApartmentByNumber(int num){
        for (Apartment apt : apartments) {
            if (apt != null && apt.getNum() == num) {
                return apt;
            }
        }
        return null;
    }

    /**
     * Calculates the total value of all apartments in the building.
     * * @return The total monetary value of the building.
     */
    public long getTotalValue() {
        long total = 0;
        for (Apartment apt : apartments) {
            if (apt != null) {
                total += apt.getPrice();
            }
        }
        return total;
    }

    /**
     * Prints the details of all apartments that are currently unsold.
     */
    public void printAvailableApartments() {
        for (Apartment apt : apartments) {
            if (apt != null && !apt.isSold()) {
                System.out.println(apt);
            }
        }
    }

    /**
     * Counts the number of apartments of a specific type.
     * * @param type The class name of the apartment type (e.g., "StandardApartment").
     * @return The count of apartments matching the given type.
     */
    public int countType(String type) {
        int count = 0;
        for (Apartment apt : apartments) {
            if (apt != null && apt.getClass().getSimpleName().equals(type)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns a string representation of the building and its apartments.
     * * @return A string containing the building's address and details of all its apartments.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Building Address: ").append(address).append("\n");
        for (Apartment apt : apartments) {
            if (apt != null) {
                sb.append(apt.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
