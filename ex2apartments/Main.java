// Assignment: 3
// Author: Liav Lugasi, ID: 213007271

package ex2apartments;
import java.util.Scanner;

public class Main {

    static final int NUM_BUILDINGS = 3;
    static final int NUM_PEOPLE = 4;
    static final int B_SIZE = 6;

    public static void main(String[] args) {

        // ============================
        // People
        // ============================
        Person[] people = new Person[NUM_PEOPLE];

        people[0] = new Person("Alice", "Smith");
        people[1] = new Person("Bob", "Johnson");
        people[2] = new Person("Charlie", "Williams");
        people[3] = new Person("Diana", "Brown");

        // ============================
        // Buildings + Apartments
        // ============================

        Apartment[] building1Apartments = new Apartment[B_SIZE];
        building1Apartments[0] = new GardenApartment(101, 120, false, 50, true);
        building1Apartments[1] = new StandardApartment(201, 80, false, 2, new int[]{5,7});
        building1Apartments[2] = new StandardApartment(202, 85, false, 1, new int[]{6});
        building1Apartments[3] = new StandardApartment(301, 75, false, 1, new int[]{4});
        building1Apartments[4] = new StandardApartment(302, 90, false, 2, new int[]{5,5});
        building1Apartments[5] = new Penthouse(401, 210, false, 60);

        Building building1 = new Building("123 Main St", building1Apartments);

        Apartment[] building2Apartments = new Apartment[B_SIZE];
        building2Apartments[0] = new GardenApartment(101, 100, false, 40, false);
        building2Apartments[1] = new StandardApartment(201, 70, false, 1, new int[]{5});
        building2Apartments[2] = new StandardApartment(202, 80, false, 2, new int[]{6,4});
        building2Apartments[3] = new StandardApartment(301, 75, false, 1, new int[]{5});
        building2Apartments[4] = new StandardApartment(302, 85, false, 2, new int[]{5,5});
        building2Apartments[5] = new Penthouse(401, 220, false, 55);

        Building building2 = new Building("456 Oak Ave", building2Apartments);

        Apartment[] building3Apartments = new Apartment[B_SIZE];
        building3Apartments[0] = new GardenApartment(101, 130, false, 60, true);
        building3Apartments[1] = new StandardApartment(201, 78, false, 2, new int[]{4,5});
        building3Apartments[2] = new StandardApartment(202, 82, false, 1, new int[]{6});
        building3Apartments[3] = new StandardApartment(301, 76, false, 2, new int[]{5,4});
        building3Apartments[4] = new StandardApartment(302, 88, false, 1, new int[]{5});
        building3Apartments[5] = new Penthouse(401, 200, false, 50);

        Building building3 = new Building("789 Pine Rd", building3Apartments);

        Building[] buildings = {building1, building2, building3};

        // ============================
        // Menu
        // ============================

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMENU OPTIONS:");
            System.out.println("1. Print all people with standard apartments");
            System.out.println("2. Print apartment details by number and building address");
            System.out.println("3. Print all standard apartments with 2 balconies that are not sold");
            System.out.println("4. Buy an apartment");
            System.out.println("5. Print all penthouse prices");
            System.out.println("6. Print the richest owner");
            System.out.println("7. Print most expensive apartment in each building");
            System.out.println("8. Print all garden apartments with pool that are not sold");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.println("\nPeople Owning Standard Apartments:");
                    for (Person person : people) {
                        boolean hasStandard = false;
                        for (Apartment apt : person.getOwnedApartments()) {
                            if (apt instanceof StandardApartment) {
                                hasStandard = true;
                                break;
                            }
                        }
                        if (hasStandard) {
                            person.printOwnershipDetails();
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter building address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter apartment number: ");
                    int aptNum = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundApt = false;
                    for (Building building : buildings) {
                        if (building.getAddress().equalsIgnoreCase(address)) {
                            Apartment apt = building.findApartmentByNumber(aptNum);
                            if (apt != null) {
                                System.out.println("Apartment Details: " + apt);
                                foundApt = true;
                            }
                        }
                    }
                    if (!foundApt) {
                        System.out.println("Apartment not found in the given address.");
                    }
                    break;

                case 3:
                    // 3. Print all standard apartments with 2 balconies that are not sold
                    System.out.println("\n Unsold Standard Apartments with 2 Balconies: ");
                    for (Building building : buildings) {
                        for (Apartment apt : building.getApartments()) {
                            if (apt instanceof StandardApartment && !apt.isSold()) {
                                StandardApartment stdApt = (StandardApartment) apt;
                                if (stdApt.getNumBalconies() == 2) {
                                    System.out.println("Address: " + building.getAddress() + " / " + stdApt);
                                }
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter buyer's first name: ");
                    String fName = scanner.nextLine();
                    System.out.print("Enter buyer's last name: ");
                    String lName = scanner.nextLine();
                    Person buyer = null;

                    for (Person p : people) {
                        if (p.getFirstName().equalsIgnoreCase(fName) && p.getLastName().equalsIgnoreCase(lName)) {
                            buyer = p;
                            break;
                        }
                    }

                    if (buyer == null) {
                        System.out.println("Error: Person not found in the system.");
                        break;
                    }

                    System.out.print("Enter building address of the apartment: ");
                    String buyAddress = scanner.nextLine();
                    System.out.print("Enter apartment number to buy: ");
                    int buyAptNum = scanner.nextInt();
                    scanner.nextLine();

                    Apartment aptToBuy = null;
                    for (Building building : buildings) {
                        if (building.getAddress().equalsIgnoreCase(buyAddress)) {
                            aptToBuy = building.findApartmentByNumber(buyAptNum);
                            break;
                        }
                    }

                    if (aptToBuy == null) {
                        System.out.println("Error: Apartment not found.");
                    } else if (aptToBuy.isSold()) {
                        System.out.println("Error: This apartment is already sold!");
                    } else {
                        buyer.addApartment(aptToBuy);
                        aptToBuy.markAsSold();        // Mark apartment as sold
                        System.out.println("Success! " + fName + " " + lName + " successfully bought apartment " + buyAptNum + ".");
                    }
                    break;

                case 5:
                    System.out.println("\nPenthouse Prices: ");
                    for (Building building : buildings) {
                        for (Apartment apt : building.getApartments()) {
                            if (apt instanceof Penthouse) {
                                System.out.println("Building: " + building.getAddress() + ", Apt Number: " + apt.getNum() + ", Price: " + apt.getPrice() + " NIS");
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("\nThe Richest Owner: ");
                    Person richest = people[0];
                    for (int i = 1; i < people.length; i++) {
                        if (people[i].getTotalPropertyValue() > richest.getTotalPropertyValue()) {
                            richest = people[i];
                        }
                    }
                    richest.printOwnershipDetails();
                    break;

                case 7:
                    System.out.println("\nMost Expensive Apartment Per Building: ");
                    for (Building building : buildings) {
                        Apartment mostExpensive = null;
                        for (Apartment apt : building.getApartments()) {
                            if (apt != null) {
                                if (mostExpensive == null || apt.getPrice() > mostExpensive.getPrice()) {
                                    mostExpensive = apt;
                                }
                            }
                        }
                        if (mostExpensive != null) {
                            System.out.println("Building: " + building.getAddress() + "\n   -> " + mostExpensive);
                        }
                    }
                    break;

                case 8:
                    System.out.println("\nUnsold Garden Apartments With Pool: ");
                    for (Building building : buildings) {
                        for (Apartment apt : building.getApartments()) {
                            if (apt instanceof GardenApartment && !apt.isSold()) {
                                GardenApartment gardenApt = (GardenApartment) apt;
                                if (gardenApt.hasPool()) {
                                    System.out.println("Building: " + building.getAddress() + " / " + gardenApt);
                                }
                            }
                        }
                    }
                    break;

                case 9:
                    System.out.println("Thank you and Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }

        } while (choice != 9);

    }
}