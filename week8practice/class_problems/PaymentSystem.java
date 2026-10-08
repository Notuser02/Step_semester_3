import java.util.*;

interface PaymentMethod {
    String getType();
    double calculateAdjustedAmount(double amount);
}

class CardPayment implements PaymentMethod {
    public String getType() { return "CARD"; }
    public double calculateAdjustedAmount(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment implements PaymentMethod {
    public String getType() { return "WALLET"; }
    public double calculateAdjustedAmount(double amount) {
        return amount * 1.01;
    }
}

class BankTransferPayment implements PaymentMethod {
    public String getType() { return "BANKTRANSFER"; }
    public double calculateAdjustedAmount(double amount) {
        return amount;
    }
}

class PaymentProcessor {
    private Map<String, PaymentMethod> methods = new HashMap<>();

    public PaymentProcessor() {
        methods.put("CARD", new CardPayment());
        methods.put("WALLET", new WalletPayment());
        methods.put("BANKTRANSFER", new BankTransferPayment());
    }

    public void processTransactions(List<String[]> transactions) {
        double total = 0;
        for (String[] t : transactions) {
            String type = t[0];
            double amount = Double.parseDouble(t[1]);
            PaymentMethod method = methods.get(type);
            if (method != null) {
                double adjusted = method.calculateAdjustedAmount(amount);
                System.out.printf("%s: %.2f%n", type, adjusted);
                total += adjusted;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String[]> transactions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+", 2);
            transactions.add(new String[]{parts[0], parts[1]});
        }
        new PaymentProcessor().processTransactions(transactions);
    }
}