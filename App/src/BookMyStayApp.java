
import java.io.*;
import java.util.*;

// Reservation class
class Reservation implements Serializable {

    String reservationId;
    String guestName;
    String roomType;

    Reservation(String reservationId,
                String guestName,
                String roomType) {

        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {

        System.out.println(reservationId+" "
                +guestName+" "+roomType);
    }
}

// Inventory class
class RoomInventory implements Serializable {

    HashMap<String,Integer> rooms;

    RoomInventory() {

        rooms = new HashMap<>();

        rooms.put("Single Room",2);
        rooms.put("Double Room",1);
    }
}

// Persistence Service
class PersistenceService {

    void saveData(List<Reservation> history,
                  RoomInventory inventory) {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream("hotel.dat"));

            out.writeObject(history);
            out.writeObject(inventory);

            out.close();

            System.out.println("Data saved successfully");

        }

        catch(Exception e) {

            System.out.println(
                    "Error saving data");
        }
    }

    void loadData() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream("hotel.dat"));

            List<Reservation> history =
                    (List<Reservation>)in.readObject();

            RoomInventory inventory =
                    (RoomInventory)in.readObject();

            in.close();

            System.out.println(
                    "\nRecovered Booking History:");

            for(Reservation r : history) {

                r.display();
            }

            System.out.println(
                    "\nRecovered Inventory:");

            for(String room :
                    inventory.rooms.keySet()) {

                System.out.println(room+" : "
                        + inventory.rooms.get(room));
            }

        }

        catch(Exception e) {

            System.out.println(
                    "No previous data found. Starting fresh.");
        }
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Version : 12.1");

        List<Reservation> history =
                new ArrayList<>();

        history.add(new Reservation(
                "R101","Amit","Single Room"));

        history.add(new Reservation(
                "R102","Neha","Double Room"));

        RoomInventory inventory =
                new RoomInventory();

        PersistenceService ps =
                new PersistenceService();

        ps.saveData(history,inventory);

        ps.loadData();
    }
}