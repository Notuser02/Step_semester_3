import java.util.*;

interface Customer {
    String getType();
    double calculateFinalAmount(double amount);
}

class Student implements Customer {
    public String getType() { return "STUDENT"; }
    public double calculateFinalAmount(double amount) {
        return amount * 0.90;
    }
}

class Staff implements Customer {
    public String getType() { return "STAFF"; }
    public double calculateFinalAmount(double amount) {
        return amount * 0.95;
    }
}

class Guest implements Customer {
    public String getType() { return "GUEST"; }
    public double calculateFinalAmount(double amount) {
        return amount + 10;
    }
}

class BillingCounter {
    private Map<String, Customer> customers = new HashMap<>();

    public BillingCounter() {
        customers.put("STUDENT", new Student());
        customers.put("STAFF", new Staff());
        customers.put("GUEST", new Guest());
    }

    public void processBills(List<String[]> bills) {
        double total = 0;
        for (String[] bill : bills) {
            String type = bill[0];
            double amount = Double.parseDouble(bill[1]);
            Customer customer = customers.get(type);
            if (customer != null) {
                double finalAmount = customer.calculateFinalAmount(amount);
                System.out.printf("%s: %.2f%n", type, finalAmount);
                total += finalAmount;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String[]> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            bills.add(parts);
        }
        new BillingCounter().processBills(bills);
    }
}