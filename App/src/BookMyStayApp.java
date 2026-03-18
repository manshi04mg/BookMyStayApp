
import java.util.HashMap;

// Inventory class
class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single Room", 10);
        inventory.put("Double Room", 5);
        inventory.put("Suite Room", 2);
    }

    // Method to get availability
    int getAvailability(String roomType) {
        return inventory.get(roomType);
    }

    // Method to update availability
    void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Method to display inventory
    void displayInventory() {

        System.out.println("\nCurrent Room Inventory:");

        for (String room : inventory.keySet()) {
            System.out.println(room + " : " + inventory.get(room));
        }
    }
}

// Main class (must remain BookMyStayApp)
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Version : 3.1");

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();

        System.out.println("\nAvailability of Single Room : "
                + inventory.getAvailability("Single Room"));

        System.out.println("\nUpdating Single Room availability to 8");

        inventory.updateAvailability("Single Room", 8);

        inventory.displayInventory();
    }
}