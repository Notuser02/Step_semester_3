import java.util.*;

interface Room {
    String getType();
    double calculateBill(double units, double... extraParams);
}

class SingleRoom implements Room {
    public String getType() { return "SINGLE"; }
    public double calculateBill(double units, double... extraParams) {
        return 8 * units;
    }
}

class SharedRoom implements Room {
    public String getType() { return "SHARED"; }
    public double calculateBill(double units, double... extraParams) {
        double occupants = extraParams.length > 0 ? extraParams[0] : 1;
        return (6 * units) / occupants;
    }
}

class ACRoom implements Room {
    public String getType() { return "AC"; }
    public double calculateBill(double units, double... extraParams) {
        return 10 * units + 200;
    }
}

class ElectricityCalculator {
    private Map<String, Room> rooms = new HashMap<>();

    public ElectricityCalculator() {
        rooms.put("SINGLE", new SingleRoom());
        rooms.put("SHARED", new SharedRoom());
        rooms.put("AC", new ACRoom());
    }

    public void processRooms(List<String[]> rooms) {
        double total = 0;
        for (String[] r : rooms) {
            String type = r[0];
            double units = Double.parseDouble(r[1]);
            double occupants = r.length > 2 ? Double.parseDouble(r[2]) : 1;
            Room room = this.rooms.get(type);
            if (room != null) {
                double bill = room.calculateBill(units, occupants);
                System.out.printf("%s: %.2f%n", type, bill);
                total += bill;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String[]> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            rooms.add(parts);
        }
        new ElectricityCalculator().processRooms(rooms);
    }
}