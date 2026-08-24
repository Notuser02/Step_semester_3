package level3.assigment_problems;

public class NumberPyramidPrinter {

    public static void printNumberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
                if (j < i) {
                    System.out.print(" ");
                }
            }
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
