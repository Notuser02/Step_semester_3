import java.util.*;

interface TransportType {
    String getType();
    double calculateFare(double distance, double... extraParams);
}

class Bus implements TransportType {
    public String getType() { return "BUS"; }
    public double calculateFare(double distance, double... extraParams) {
        double fare = 2 + 0.10 * distance;
        return Math.min(fare, 10);
    }
}

class Train implements TransportType {
    public String getType() { return "TRAIN"; }
    public double calculateFare(double distance, double... extraParams) {
        return 3 + 0.15 * distance;
    }
}

class Metro implements TransportType {
    public String getType() { return "METRO"; }
    public double calculateFare(double distance, double... extraParams) {
        double peakFactor = extraParams.length > 0 ? extraParams[0] : 1.0;
        return (1.50 + 0.20 * distance) * peakFactor;
    }
}

class TransportProcessor {
    private Map<String, TransportType> types = new HashMap<>();

    public TransportProcessor() {
        types.put("BUS", new Bus());
        types.put("TRAIN", new Train());
        types.put("METRO", new Metro());
    }

    public void processJourneys(List<String[]> journeys) {
        double total = 0;
        for (String[] j : journeys) {
            String type = j[0];
            double distance = Double.parseDouble(j[1]);
            double peakFactor = j.length > 2 ? Double.parseDouble(j[2]) : 1.0;
            
            TransportType transport = types.get(type);
            if (transport != null) {
                double fare = transport.calculateFare(distance, peakFactor);
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String[]> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            journeys.add(parts);
        }
        new TransportProcessor().processJourneys(journeys);
    }
}