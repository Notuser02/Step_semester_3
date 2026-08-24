package level3.assigment_problems;

public class MultiplicationTableGenerator {

    public static void generateFirstValidTable(int[] candidates) {
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];

            if (candidate < 1) {
                System.out.println("Skipping invalid number: " + candidate);
                continue;
            }

            for (int j = 1; j <= 10; j++) {
                System.out.println(candidate + " x " + j + " = " + (candidate * j));
            }

            break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Test candidates=[-3, 0, 7, 9]:");
        generateFirstValidTable(new int[]{-3, 0, 7, 9});
        System.out.println("---");
        System.out.println("Test candidates=[5]:");
        generateFirstValidTable(new int[]{5});
        System.out.println("---");
        System.out.println("Test candidates=[-1, -2, 3]:");
        generateFirstValidTable(new int[]{-1, -2, 3});
    }
}
