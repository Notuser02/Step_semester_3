import java.util.*;

abstract class Booking {
    protected double distance;
    protected static final double BOOKING_FEE = 50;

    public Booking(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();

    public double getTotal() {
        return calculateFare() + BOOKING_FEE;
    }

    public abstract String getMode();
}

class BusBooking extends Booking {
    public BusBooking(double distance) {
        super(distance);
    }

    public double calculateFare() {
        return 2 * distance;
    }

    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distance) {
        super(distance);
    }

    public double calculateFare() {
        return 1.5 * distance;
    }

    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distance) {
        super(distance);
    }

    public double calculateFare() {
        return 2500 + 4 * distance;
    }

    public String getMode() {
        return "FLIGHT";
    }
}

class BookingSystem {
    public void processBookings(List<Booking> bookings) {
        for (Booking b : bookings) {
            System.out.printf("%s: %.2f%n", b.getMode(), b.getTotal());
        }
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String mode = parts[0];
            double distance = Double.parseDouble(parts[1]);
            Booking booking = null;
            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distance);
                    break;
                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;
                case "FLIGHT":
                    booking = new FlightBooking(distance);
                    break;
            }
            if (booking != null) bookings.add(booking);
        }
        new BookingSystem().processBookings(bookings);
    }
}