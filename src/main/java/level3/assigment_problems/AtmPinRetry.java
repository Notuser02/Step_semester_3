package level3.assigment_problems;

public class AtmPinRetry {

    public static void atmPinRetry(String correctPin, String[] attempts) {
        int attempt = 0;
        boolean success = false;

        while (attempt < attempts.length && attempt < 3 && !success) {
            boolean isMatch = attempts[attempt].equals(correctPin);
            if (isMatch) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }
            attempt++;
        }

        if (!success) {
            System.out.println("Card blocked \u2014 too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1: correctPin=4821, attempts=[1111, 4821]");
        atmPinRetry("4821", new String[]{"1111", "4821"});
        System.out.println("---");
        System.out.println("Test 2: correctPin=4821, attempts=[1111, 2222, 3333]");
        atmPinRetry("4821", new String[]{"1111", "2222", "3333"});
        System.out.println("---");
        System.out.println("Test 3: correct on first try");
        atmPinRetry("1234", new String[]{"1234"});
    }
}
