package level3.assigment_problems;

/**
 * P5. Guess the Number Game
 * Concepts: while loops, if/else if/else, break, boolean-driven loop conditions
 */
public class GuessTheNumberGame {

    /**
     * Player guesses secret number until correct or out of tries.
     * Suggested signature: void guessTheNumber(int secretNumber, int maxTries, int[] guesses)
     */
    public static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tries = 0;
        boolean guessed = false;

        // while loop with try counter, continuing while tries remain and not yet guessed
        while (tries < maxTries && tries < guesses.length && !guessed) {
            int guess = guesses[tries];

            // if / else if / else to give hints
            if (guess > secretNumber) {
                System.out.println("Too high");
            } else if (guess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break; // break out immediately on correct guess
            }
            tries++;
        }

        // if tries run out without correct guess, notify
        // Note: we check guessed flag, and also handle case where loop exhausted maxTries
        if (!guessed) {
            // only print out-of-tries if we actually consumed maxTries or guesses
            // To match spec: print if not guessed after loop ends
            System.out.println("Out of tries \u2014 the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1: secret=42, maxTries=4, guesses=[20, 60, 42]");
        guessTheNumber(42, 4, new int[]{20, 60, 42});
        System.out.println("---");
        System.out.println("Test 2: secret=42, maxTries=2, guesses=[10, 15]");
        guessTheNumber(42, 2, new int[]{10, 15});
        System.out.println("---");
        System.out.println("Test 3: secret=10, maxTries=3, guesses=[10]");
        guessTheNumber(10, 3, new int[]{10});
    }
}
