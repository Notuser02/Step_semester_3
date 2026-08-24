package level3.assigment_problems;

public class GuessTheNumberGame {

    public static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries && tries < guesses.length && !guessed) {
            int guess = guesses[tries];

            if (guess > secretNumber) {
                System.out.println("Too high");
            } else if (guess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }
            tries++;
        }

        if (!guessed) {
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
