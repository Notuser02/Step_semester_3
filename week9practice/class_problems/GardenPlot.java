import java.util.*;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract double calculateArea();

    public abstract String getShape();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }

    public String getShape() {
        return "TRIANGLE";
    }
}

class GardenReport {
    public void generateReport(List<Plot> plots) {
        double totalArea = 0;
        for (Plot plot : plots) {
            double area = plot.calculateArea();
            System.out.printf("%s (%s): %.2f%n", plot.getOwner(), plot.getShape(), area);
            totalArea += area;
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}

public class GardenPlot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String shape = parts[0];
            String owner = parts[1];
            Plot plot = null;
            switch (shape) {
                case "CIRCLE":
                    double radius = Double.parseDouble(parts[2]);
                    plot = new CirclePlot(owner, radius);
                    break;
                case "RECTANGLE":
                    double length = Double.parseDouble(parts[2]);
                    double width = Double.parseDouble(parts[3]);
                    plot = new RectanglePlot(owner, length, width);
                    break;
                case "TRIANGLE":
                    double base = Double.parseDouble(parts[2]);
                    double height = Double.parseDouble(parts[3]);
                    plot = new TrianglePlot(owner, base, height);
                    break;
            }
            if (plot != null) plots.add(plot);
        }
        new GardenReport().generateReport(plots);
    }
}