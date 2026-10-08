import java.util.*;

abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super(units);
    }

    public double calculateBill() {
        if (units <= 100) {
            return units * 5;
        } else {
            return 100 * 5 + (units - 100) * 7;
        }
    }

    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super(units);
    }

    public double calculateBill() {
        return units * 8 + 100;
    }

    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super(units);
    }

    public double calculateBill() {
        double bill = units * 6;
        return Math.max(bill, 1000);
    }

    public String getType() {
        return "FACTORY";
    }
}

class BillingSystem {
    public void processBills(List<Connection> connections) {
        double total = 0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            System.out.printf("%s: %.2f%n", c.getType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);
            Connection conn = null;
            switch (type) {
                case "HOME":
                    conn = new HomeConnection(units);
                    break;
                case "SHOP":
                    conn = new ShopConnection(units);
                    break;
                case "FACTORY":
                    conn = new FactoryConnection(units);
                    break;
            }
            if (conn != null) connections.add(conn);
        }
        new BillingSystem().processBills(connections);
    }
}