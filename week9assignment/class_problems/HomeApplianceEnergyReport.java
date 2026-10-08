import java.util.*;

interface SaverMode {
    boolean supportsSaver();
}

abstract class Appliance {
    protected int powerWatts;
    protected int hours;

    public Appliance(int powerWatts, int hours) {
        this.powerWatts = powerWatts;
        this.hours = hours;
    }

    public double calculateUnits(boolean saver) {
        double units = (powerWatts * hours) / 1000.0;
        if (saver && supportsSaver()) {
            units *= 0.75;
        }
        return units;
    }

    public double calculateCost(double units) {
        return units * 8;
    }

    public boolean supportsSaver() {
        return this instanceof SaverMode && ((SaverMode) this).supportsSaver();
    }

    public abstract String getName();
}

class Fridge extends Appliance {
    public Fridge(int hours) { super(150, hours); }
    public String getName() { return "FRIDGE"; }
}

class AC extends Appliance implements SaverMode {
    public AC(int hours) { super(1500, hours); }
    public String getName() { return "AC"; }
    public boolean supportsSaver() { return true; }
}

class TV extends Appliance {
    public TV(int hours) { super(100, hours); }
    public String getName() { return "TV"; }
}

class Washer extends Appliance implements SaverMode {
    public Washer(int hours) { super(500, hours); }
    public String getName() { return "WASHER"; }
    public boolean supportsSaver() { return true; }
}

class EnergyReport {
    public void processAppliances(List<String[]> appliances) {
        double totalCost = 0;
        for (String[] a : appliances) {
            String type = a[0];
            int hours = Integer.parseInt(a[1]);
            boolean saver = a.length > 2 && a[2].equals("SAVER");

            Appliance appliance = null;
            switch (type) {
                case "FRIDGE": appliance = new Fridge(hours); break;
                case "AC": appliance = new AC(hours); break;
                case "TV": appliance = new TV(hours); break;
                case "WASHER": appliance = new Washer(hours); break;
            }

            if (appliance != null) {
                if (saver && !appliance.supportsSaver()) {
                    System.out.println(appliance.getName() + ": saver mode not supported");
                } else {
                    double units = appliance.calculateUnits(saver);
                    double cost = appliance.calculateCost(units);
                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
                    totalCost += cost;
                }
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String[]> appliances = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            appliances.add(parts);
        }
        new EnergyReport().processAppliances(appliances);
    }
}