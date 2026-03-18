
import java.util.*;

// Reservation class
class Reservation {

    String reservationId;
    String roomType;
    String roomId;

    Reservation(String reservationId,
                String roomType,
                String roomId) {

        this.reservationId = reservationId;
        this.roomType = roomType;
        this.roomId = roomId;
    }
}

// Inventory class
class RoomInventory {

    HashMap<String,Integer> rooms;

    RoomInventory() {

        rooms = new HashMap<>();

        rooms.put("Single Room",1);
        rooms.put("Double Room",1);
        rooms.put("Suite Room",1);
    }

    void increaseRoom(String type) {

        rooms.put(type,rooms.get(type)+1);
    }

    void displayInventory() {

        System.out.println("\nCurrent Inventory:");

        for(String r : rooms.keySet()) {

            System.out.println(r+" : "
                    + rooms.get(r));
        }
    }
}

// Cancellation Service
class CancellationService {

    HashMap<String,Reservation> bookings;
    Stack<String> rollbackStack;

    CancellationService() {

        bookings = new HashMap<>();
        rollbackStack = new Stack<>();
    }

    void addBooking(Reservation r) {

        bookings.put(r.reservationId,r);
    }

    void cancelBooking(String id,
                       RoomInventory inv) {

        if(!bookings.containsKey(id)) {

            System.out.println(
                    "Cancellation Failed : Invalid ID");

            return;
        }

        Reservation r = bookings.get(id);

        rollbackStack.push(r.roomId);

        inv.increaseRoom(r.roomType);

        bookings.remove(id);

        System.out.println("Booking Cancelled : "
                + id);

        System.out.println("Released Room ID : "
                + rollbackStack.peek());
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Version : 10.1");

        RoomInventory inventory =
                new RoomInventory();

        CancellationService service =
                new CancellationService();

        Reservation r1 =
                new Reservation("R101",
                        "Single Room","S1");

        service.addBooking(r1);

        service.cancelBooking("R101",
                inventory);

        service.cancelBooking("R200",
                inventory); // invalid case

        inventory.displayInventory();
    }
}