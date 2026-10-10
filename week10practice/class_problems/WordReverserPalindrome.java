import java.util.Scanner;

public class WordReverserPalindrome {
    
    public static void reverseAndCheckPalindrome(String word) {
        if (word == null) return;
        
        StringBuilder reversed = new StringBuilder(word).reverse();
        String reversedStr = reversed.toString();
        
        boolean isPalindrome = word.equalsIgnoreCase(reversedStr);
        
        System.out.println(reversedStr + " - " + (isPalindrome ? "palindrome" : "not a palindrome"));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word: ");
        String word = scanner.nextLine().trim();
        
        reverseAndCheckPalindrome(word);
    }
}