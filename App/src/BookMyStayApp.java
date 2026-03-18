
import java.util.*;

// Reservation class
class Reservation {

    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {

        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Shared Inventory
class RoomInventory {

    private HashMap<String,Integer> rooms;

    RoomInventory() {

        rooms = new HashMap<>();

        rooms.put("Single Room",2);
        rooms.put("Double Room",1);
    }

    // Critical section
    synchronized void allocateRoom(Reservation r) {

        int available = rooms.getOrDefault(r.roomType,0);

        if(available > 0) {

            rooms.put(r.roomType, available-1);

            System.out.println(Thread.currentThread().getName()
                    + " booked " + r.roomType
                    + " for " + r.guestName);

        }
        else {

            System.out.println(Thread.currentThread().getName()
                    + " failed booking for "
                    + r.guestName);
        }
    }
}

// Booking Processor Thread
class BookingProcessor extends Thread {

    private Queue<Reservation> queue;
    private RoomInventory inventory;

    BookingProcessor(Queue<Reservation> queue,
                     RoomInventory inventory,
                     String name) {

        super(name);

        this.queue = queue;
        this.inventory = inventory;
    }

    public void run() {

        while(true) {

            Reservation r;

            synchronized(queue) {

                if(queue.isEmpty())
                    break;

                r = queue.poll();
            }

            inventory.allocateRoom(r);
        }
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Book My Stay App");
        System.out.println("Version : 11.1");

        Queue<Reservation> queue = new LinkedList<>();

        queue.add(new Reservation("Amit","Single Room"));
        queue.add(new Reservation("Neha","Single Room"));
        queue.add(new Reservation("Rahul","Double Room"));
        queue.add(new Reservation("Priya","Double Room"));

        RoomInventory inventory = new RoomInventory();

        BookingProcessor t1 =
                new BookingProcessor(queue, inventory,"Thread-1");

        BookingProcessor t2 =
                new BookingProcessor(queue, inventory,"Thread-2");

        t1.start();
        t2.start();

        // Wait for threads to finish
        t1.join();
        t2.join();

        System.out.println("\nAll booking requests processed.");
    }
}