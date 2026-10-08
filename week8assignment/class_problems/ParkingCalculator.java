import java.util.*;

interface Vehicle {
    String getType();
    double calculateCharge(int hours);
}

class Bike implements Vehicle {
    public String getType() { return "BIKE"; }
    public double calculateCharge(int hours) {
        return 10 * hours;
    }
}

class Car implements Vehicle {
    public String getType() { return "CAR"; }
    public double calculateCharge(int hours) {
        if (hours <= 1) return 30;
        return 30 + 20 * (hours - 1);
    }
}

class Truck implements Vehicle {
    public String getType() { return "TRUCK"; }
    public double calculateCharge(int hours) {
        double charge = 50 * hours;
        return Math.max(charge, 100);
    }
}

class ParkingSystem {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public ParkingSystem() {
        vehicles.put("BIKE", new Bike());
        vehicles.put("CAR", new Car());
        vehicles.put("TRUCK", new Truck());
    }

    public void processVehicles(List<String[]> vehicles) {
        double total = 0;
        for (String[] v : vehicles) {
            String type = v[0];
            int hours = Integer.parseInt(v[1]);
            Vehicle vehicle = this.vehicles.get(type);
            if (vehicle != null) {
                double charge = vehicle.calculateCharge(hours);
                System.out.printf("%s: %.2f%n", type, charge);
                total += charge;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String[]> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            vehicles.add(parts);
        }
        new ParkingSystem().processVehicles(vehicles);
    }
}