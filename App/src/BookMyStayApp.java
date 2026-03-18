
import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {

    InvalidBookingException(String message) {
        super(message);
    }
}

// Inventory class
class RoomInventory {

    private HashMap<String,Integer> rooms;

    RoomInventory() {

        rooms = new HashMap<>();

        rooms.put("Single Room",2);
        rooms.put("Double Room",1);
        rooms.put("Suite Room",0);
    }

    void validateRoom(String type)
            throws InvalidBookingException {

        if(!rooms.containsKey(type)) {

            throw new InvalidBookingException(
                    "Invalid Room Type : " + type);
        }

        if(rooms.get(type) <= 0) {

            throw new InvalidBookingException(
                    "No rooms available for : " + type);
        }
    }

    void bookRoom(String type)
            throws InvalidBookingException {

        validateRoom(type);

        int count = rooms.get(type);

        if(count-1 < 0) {

            throw new InvalidBookingException(
                    "Inventory cannot be negative");
        }

        rooms.put(type,count-1);

        System.out.println("Room booked successfully : "
                + type);
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Version : 9.1");

        RoomInventory inventory =
                new RoomInventory();

        try {

            inventory.bookRoom("Single Room");

            inventory.bookRoom("Suite Room"); // error case

            inventory.bookRoom("Luxury Room"); // invalid

        }

        catch(InvalidBookingException e) {

            System.out.println("Booking Failed : "
                    + e.getMessage());
        }

        System.out.println("\nSystem running safely...");
    }
}