package level3.assigment_problems;

/**
 * P4. Multiplication Table Generator With Input Validation
 * Concepts: for loops, continue, break, if validation, nested loops
 */
public class MultiplicationTableGenerator {

    /**
     * Tries candidate numbers in order, skips invalid (<1), prints table for first valid.
     * Suggested signature: void generateFirstValidTable(int[] candidates)
     */
    public static void generateFirstValidTable(int[] candidates) {
        // for loop over the candidates
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];

            // check with if whether it is >=1
            if (candidate < 1) {
                System.out.println("Skipping invalid number: " + candidate);
                continue; // move to next candidate
            }

            // valid candidate found - print its multiplication table 1 to 10 using nested for loop
            for (int j = 1; j <= 10; j++) {
                System.out.println(candidate + " x " + j + " = " + (candidate * j));
            }

            // stop processing further candidates
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
