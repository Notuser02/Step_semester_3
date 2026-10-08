import java.util.*;

interface Insurable {
    double getInsurance();
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();

    public double getInsurance() {
        return 0;
    }

    public double getTotal() {
        return calculateCharge() + getInsurance();
    }

    public abstract String getType();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    public double calculateCharge() {
        return 40 + 10 * weight;
    }
    public String getType() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    public double calculateCharge() {
        return 80 + 15 * weight;
    }
    public double getInsurance() {
        return declaredValue * 0.02;
    }
    public String getType() { return "EXPRESS"; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    public double calculateCharge() {
        return (40 + 10 * weight) + 50;
    }
    public double getInsurance() {
        return declaredValue * 0.02;
    }
    public String getType() { return "FRAGILE"; }
}

class ShippingDesk {
    public void processParcels(List<Parcel> parcels) {
        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = p.getInsurance();
            double total = p.getTotal();
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                p.getType(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}

public class ParcelShipping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double declaredValue = Double.parseDouble(parts[2]);
            Parcel parcel = null;
            switch (type) {
                case "STANDARD": parcel = new StandardParcel(weight, declaredValue); break;
                case "EXPRESS": parcel = new ExpressParcel(weight, declaredValue); break;
                case "FRAGILE": parcel = new FragileParcel(weight, declaredValue); break;
            }
            if (parcel != null) parcels.add(parcel);
        }
        new ShippingDesk().processParcels(parcels);
    }
}