

import java.util.*;

// Reservation class
class Reservation {

    private String reservationId;
    private String guestName;
    private String roomType;

    Reservation(String reservationId, String guestName, String roomType) {

        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {

        System.out.println("Reservation ID : " + reservationId);
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type : " + roomType);
        System.out.println();
    }
}

// Booking History class
class BookingHistory {

    private List<Reservation> history;

    BookingHistory() {

        history = new ArrayList<>();
    }

    void addReservation(Reservation r) {

        history.add(r);
    }

    List<Reservation> getHistory() {

        return history;
    }
}

// Booking Report Service
class BookingReportService {

    void generateReport(List<Reservation> list) {

        System.out.println("\nBooking History Report:\n");

        for (Reservation r : list) {

            r.display();
        }

        System.out.println("Total Bookings : " + list.size());
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Version : 8.1");

        BookingHistory history = new BookingHistory();

        history.addReservation(
                new Reservation("R101", "Amit", "Single Room"));

        history.addReservation(
                new Reservation("R102", "Neha", "Double Room"));

        history.addReservation(
                new Reservation("R103", "Rahul", "Suite Room"));

        BookingReportService report = new BookingReportService();

        report.generateReport(history.getHistory());
    }
}