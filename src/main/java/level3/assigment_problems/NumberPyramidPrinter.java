package level3.assigment_problems;

/**
 * P1. Number Pyramid Pattern Printer
 * Concepts: Nested for loops, outer/inner loop counters, pattern printing
 */
public class NumberPyramidPrinter {

    /**
     * Prints a numeric pyramid with N rows.
     * Row i contains the number i printed i times.
     * Suggested signature: void printNumberPyramid(int n)
     */
    public static void printNumberPyramid(int n) {
        // outer for loop for each row from 1 to N
        for (int i = 1; i <= n; i++) {
            // inner for loop prints the row number that many times
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
                if (j < i) {
                    System.out.print(" ");
                }
            }
            // move to new line after each row completes
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Test n=4:");
        printNumberPyramid(4);
        System.out.println("---");
        System.out.println("Test n=1:");
        printNumberPyramid(1);
        System.out.println("---");
        System.out.println("Test n=5:");
        printNumberPyramid(5);
    }
}
