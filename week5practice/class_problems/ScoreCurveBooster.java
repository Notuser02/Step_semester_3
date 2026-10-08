import java.util.Arrays;
import java.util.Scanner;

public class ScoreCurveBooster {
    
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of scores: ");
        int n = scanner.nextInt();
        int[] scores = new int[n];
        
        System.out.print("Enter " + n + " scores: ");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        
        System.out.print("Enter bonus: ");
        int bonus = scanner.nextInt();
        
        curveScores(scores, bonus);
        System.out.println(Arrays.toString(scores));
    }
}