public class TypingSpeedTestAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = (matched * 100.0) / original.length();

        if (firstMismatchPos == -1) {
            System.out.println("Matched: " + matched + "/" + original.length() + " | Accuracy: " + String.format("%.2f", accuracy) + "% | No Mismatches");
        } else {
            System.out.println("Matched: " + matched + "/" + original.length() + " | Accuracy: " + String.format("%.2f", accuracy) + "% | First Mismatch at position " + firstMismatchPos + " ('" + origChar + "' vs '" + typedChar + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}