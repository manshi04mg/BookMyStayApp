/**
 * Use Case 5: Booking Request Queue (FIFO)
 * Book My Stay – Hotel Booking Management System
 * @version 5.1
 */

import java.util.*;

// Reservation class
class Reservation {

    String guestName;
    String roomType;

    Reservation(String guestName,String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println("Guest : "+guestName+
                " | Requested Room : "+roomType);
    }
}

// Booking Queue class
class BookingRequestQueue {

    Queue<Reservation> queue;

    BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    void addRequest(Reservation r) {

        queue.add(r);

        System.out.println("Request added for "
                + r.guestName);
    }

    void showRequests() {

        System.out.println("\nBooking Requests (FIFO Order):");

        for(Reservation r : queue) {
            r.display();
        }
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Version : 5.1");

        BookingRequestQueue bookingQueue =
                new BookingRequestQueue();

        Reservation r1 =
                new Reservation("Amit","Single Room");

        Reservation r2 =
                new Reservation("Neha","Double Room");

        Reservation r3 =
                new Reservation("Rahul","Suite Room");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        bookingQueue.showRequests();
    }
}