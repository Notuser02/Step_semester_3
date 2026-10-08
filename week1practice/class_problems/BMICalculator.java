import java.util.Random;
import java.util.Scanner;

public class BMICalculator {
    
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }
    
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-8s %-12s %-12s %-8s %s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-8d %-12.2f %-12.1f %-8.2f %s%n", 
                i + 1, heights[i], weights[i], bmi, status);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter number of people (default 10): ");
        int n = scanner.hasNextInt() ? scanner.nextInt() : 10;
        
        double[] heights = new double[n];
        double[] weights = new double[n];
        
        System.out.print("Use random values? (y/n): ");
        String useRandom = scanner.next().toLowerCase();
        
        if (useRandom.startsWith("y")) {
            for (int i = 0; i < n; i++) {
                heights[i] = 1.5 + random.nextDouble() * 0.45; // 1.50 - 1.95
                weights[i] = 45 + random.nextDouble() * 55;    // 45 - 100
            }
        } else {
            for (int i = 0; i < n; i++) {
                System.out.printf("Person %d - Height (m) Weight (kg): ", i + 1);
                heights[i] = scanner.nextDouble();
                weights[i] = scanner.nextDouble();
            }
        }
        
        printWellnessReport(heights, weights);
    }
}