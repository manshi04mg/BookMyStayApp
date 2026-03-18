
abstract class Room {

    String roomType;
    int beds;
    double price;

    Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    void displayRoomDetails() {
        System.out.println("Room Type : " + roomType);
        System.out.println("Beds : " + beds);
        System.out.println("Price : " + price);
    }
}

// Single Room
class SingleRoom extends Room {

    SingleRoom() {
        super("Single Room",1,2000);
    }
}

// Double Room
class DoubleRoom extends Room {

    DoubleRoom() {
        super("Double Room",2,3500);
    }
}

// Suite Room
class SuiteRoom extends Room {

    SuiteRoom() {
        super("Suite Room",3,5000);
    }
}

// Main class (must be public)
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Version : 2.1");

        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        int singleAvailable = 10;
        int doubleAvailable = 5;
        int suiteAvailable = 2;

        System.out.println("\nRoom Details:");

        r1.displayRoomDetails();
        System.out.println("Available : " + singleAvailable);

        System.out.println();

        r2.displayRoomDetails();
        System.out.println("Available : " + doubleAvailable);

        System.out.println();

        r3.displayRoomDetails();
        System.out.println("Available : " + suiteAvailable);

    }
}