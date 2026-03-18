/**
 * Use Case 4: Room Search & Availability Check
 * Book My Stay – Hotel Booking Management System
 * @version 4.1
 */

import java.util.*;

// Abstract Room class
abstract class Room {

    String type;
    int beds;
    double price;

    Room(String type,int beds,double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Room Type : "+type);
        System.out.println("Beds : "+beds);
        System.out.println("Price : "+price);
    }
}

// Room types
class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room",1,2000);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room",2,3500);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room",3,5000);
    }
}

// Inventory class
class RoomInventory {

    private HashMap<String,Integer> inventory;

    RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single Room",10);
        inventory.put("Double Room",5);
        inventory.put("Suite Room",0);
    }

    int getAvailability(String type) {
        return inventory.get(type);
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Version : 4.1");

        RoomInventory inventory = new RoomInventory();

        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        System.out.println("\nAvailable Rooms:\n");

        if(inventory.getAvailability(r1.type) > 0) {
            r1.displayDetails();
            System.out.println("Available : "
                    + inventory.getAvailability(r1.type));
            System.out.println();
        }

        if(inventory.getAvailability(r2.type) > 0) {
            r2.displayDetails();
            System.out.println("Available : "
                    + inventory.getAvailability(r2.type));
            System.out.println();
        }

        if(inventory.getAvailability(r3.type) > 0) {
            r3.displayDetails();
            System.out.println("Available : "
                    + inventory.getAvailability(r3.type));
        }

    }
}