

import java.util.*;

// Service class
class Service {

    String serviceName;
    int cost;

    Service(String serviceName,int cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    void display() {
        System.out.println(serviceName+" : "+cost);
    }
}

// Add-On Service Manager
class AddOnServiceManager {

    HashMap<String,List<Service>> serviceMap;

    AddOnServiceManager() {

        serviceMap = new HashMap<>();
    }

    // Add service to reservation
    void addService(String reservationId, Service service) {

        serviceMap
                .computeIfAbsent(reservationId,
                        k->new ArrayList<>())
                .add(service);
    }

    // Display services
    void showServices(String reservationId) {

        System.out.println("\nServices for Reservation "
                + reservationId);

        int total = 0;

        List<Service> list =
                serviceMap.get(reservationId);

        if(list != null) {

            for(Service s : list) {

                s.display();
                total += s.cost;
            }

            System.out.println("Total Add-On Cost : "
                    + total);
        }
    }
}

// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App");
        System.out.println("Version : 7.1");

        AddOnServiceManager manager =
                new AddOnServiceManager();

        String reservationId = "R101";

        manager.addService(reservationId,
                new Service("Breakfast",500));

        manager.addService(reservationId,
                new Service("Airport Pickup",800));

        manager.addService(reservationId,
                new Service("Extra Bed",700));

        manager.showServices(reservationId);
    }
}