import java.util.Scanner;

public class PalindromeChecker {
    
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeRecursiveHelper(clean, 0, clean.length() - 1);
    }
    
    private static boolean isPalindromeRecursiveHelper(String clean, int left, int right) {
        if (left >= right) return true;
        if (clean.charAt(left) != clean.charAt(right)) return false;
        return isPalindromeRecursiveHelper(clean, left + 1, right - 1);
    }
    
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] chars = clean.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return new String(chars).equals(new String(reversed));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to check: ");
        String input = scanner.nextLine();
        
        boolean iterative = isPalindromeIterative(input);
        boolean recursive = isPalindromeRecursive(input);
        boolean arrayReversal = isPalindromeArrayReversal(input);
        
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n",
            iterative ? "Palindrome" : "Not Palindrome",
            recursive ? "Palindrome" : "Not Palindrome",
            arrayReversal ? "Palindrome" : "Not Palindrome");
        
        if (iterative == recursive && recursive == arrayReversal) {
            System.out.println("All three approaches agree.");
        } else {
            System.out.println("Warning: Approaches disagree!");
        }
    }
}