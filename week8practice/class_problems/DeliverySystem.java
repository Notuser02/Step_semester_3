import java.util.*;

interface DeliveryType {
    String getType();
    double calculateFee(double weight, double distance, double... extraParams);
}

class StandardDelivery implements DeliveryType {
    public String getType() { return "STANDARD"; }
    public double calculateFee(double weight, double distance, double... extraParams) {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery implements DeliveryType {
    public String getType() { return "EXPRESS"; }
    public double calculateFee(double weight, double distance, double... extraParams) {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery implements DeliveryType {
    public String getType() { return "INTERNATIONAL"; }
    public double calculateFee(double weight, double distance, double... extraParams) {
        double customsFee = extraParams.length > 0 ? extraParams[0] : 0;
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

class DeliveryProcessor {
    private Map<String, DeliveryType> types = new HashMap<>();

    public DeliveryProcessor() {
        types.put("STANDARD", new StandardDelivery());
        types.put("EXPRESS", new ExpressDelivery());
        types.put("INTERNATIONAL", new InternationalDelivery());
    }

    public void processDeliveries(List<String[]> deliveries) {
        double total = 0;
        for (String[] d : deliveries) {
            String type = d[0];
            double weight = Double.parseDouble(d[1]);
            double distance = Double.parseDouble(d[2]);
            double customsFee = d.length > 3 ? Double.parseDouble(d[3]) : 0;
            
            DeliveryType delivery = types.get(type);
            if (delivery != null) {
                double fee = delivery.calculateFee(weight, distance, customsFee);
                System.out.printf("%s: %.2f%n", type, fee);
                total += fee;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String[]> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            deliveries.add(parts);
        }
        new DeliveryProcessor().processDeliveries(deliveries);
    }
}