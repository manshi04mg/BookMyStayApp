
import java.util.*;

// Reservation class
class Reservation {

    String guestName;
    String roomType;

    Reservation(String guestName,String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Inventory class
class RoomInventory {

    HashMap<String,Integer> rooms;

    RoomInventory() {

        rooms = new HashMap<>();

        rooms.put("Single Room",2);
        rooms.put("Double Room",1);
        rooms.put("Suite Room",1);
    }

    int getAvailability(String type) {
        return rooms.get(type);
    }

    void decreaseRoom(String type) {

        rooms.put(type, rooms.get(type)-1);
    }
}

// Allocation service
class RoomAllocationService {

    Set<String> allocatedRooms;
    HashMap<String,Set<String>> roomMap;

    RoomAllocationService() {

        allocatedRooms = new HashSet<>();
        roomMap = new HashMap<>();
    }

    void allocate(Reservation r, RoomInventory inv) {

        if(inv.getAvailability(r.roomType) > 0) {

            String roomId =
                    r.roomType.substring(0,1)
                            + (allocatedRooms.size()+1);

            if(!allocatedRooms.contains(roomId)) {

                allocatedRooms.add(roomId);

                roomMap
                        .computeIfAbsent(r.roomType,
                                k->new HashSet<>())
                        .add(roomId);

                inv.decreaseRoom(r.roomType);

                System.out.println("Reservation Confirmed");
                System.out.println("Guest : "+r.guestName);
                System.out.println("Room Type : "+r.roomType);
                System.out.println("Room ID : "+roomId);
                System.out.println();
            }

        } else {

            System.out.println("No rooms available for "
                    + r.guestName);
        }
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Version : 6.1");

        Queue<Reservation> queue =
                new LinkedList<>();

        queue.add(new Reservation("Amit","Single Room"));
        queue.add(new Reservation("Neha","Double Room"));
        queue.add(new Reservation("Rahul","Single Room"));

        RoomInventory inventory =
                new RoomInventory();

        RoomAllocationService service =
                new RoomAllocationService();

        while(!queue.isEmpty()) {

            Reservation r = queue.poll();

            service.allocate(r,inventory);
        }
    }
}