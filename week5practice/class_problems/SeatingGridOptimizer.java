import java.util.Scanner;

public class SeatingGridOptimizer {
    
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }
    
    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = avg < threshold ? "Quiet Zone" : "Buzzing Zone";
            
            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ").append(zone);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        
        int[][] seatingScores = new int[rows][];
        
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter number of seats in row " + i + ": ");
            int cols = scanner.nextInt();
            seatingScores[i] = new int[cols];
            
            System.out.print("Enter " + cols + " scores for row " + i + ": ");
            for (int j = 0; j < cols; j++) {
                seatingScores[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();
        
        System.out.println(classifyRows(seatingScores, threshold));
    }
}