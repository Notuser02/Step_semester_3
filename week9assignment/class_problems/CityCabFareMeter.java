import java.util.*;

interface NightService {
    boolean supportsNightService();
}

abstract class Cab {
    protected double ratePerKm;
    protected static final double MIN_FARE = 100;

    public Cab(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    public double calculateBaseFare(double km) {
        double fare = km * ratePerKm;
        return Math.max(fare, MIN_FARE);
    }

    public boolean isNightAvailable() {
        return this instanceof NightService && ((NightService) this).supportsNightService();
    }

    public double calculateNightFare(double baseFare) {
        return baseFare * 1.20;
    }

    public abstract String getCabType();
}

class MiniCab extends Cab {
    public MiniCab() { super(10); }
    public String getCabType() { return "MINI"; }
}

class SedanCab extends Cab implements NightService {
    public SedanCab() { super(14); }
    public String getCabType() { return "SEDAN"; }
    public boolean supportsNightService() { return true; }
}

class SUVCab extends Cab implements NightService {
    public SUVCab() { super(18); }
    public String getCabType() { return "SUV"; }
    public boolean supportsNightService() { return true; }
}

class CabMeter {
    public void processTrips(List<String[]> trips) {
        double total = 0;
        for (String[] t : trips) {
            String type = t[0];
            double km = Double.parseDouble(t[1]);
            String time = t[2];

            Cab cab = null;
            switch (type) {
                case "MINI": cab = new MiniCab(); break;
                case "SEDAN": cab = new SedanCab(); break;
                case "SUV": cab = new SUVCab(); break;
            }

            if (cab != null) {
                if (time.equals("NIGHT") && !cab.isNightAvailable()) {
                    System.out.println(cab.getCabType() + ": night service not available");
                } else {
                    double baseFare = cab.calculateBaseFare(km);
                    double fare = time.equals("NIGHT") ? cab.calculateNightFare(baseFare) : baseFare;
                    System.out.printf("%s: %.2f%n", cab.getCabType(), fare);
                    total += fare;
                }
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String[]> trips = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            trips.add(parts);
        }
        new CabMeter().processTrips(trips);
    }
}