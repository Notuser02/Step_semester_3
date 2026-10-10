import java.util.Scanner;

public class VowelConsonantCounter {
    
    public static void countVowelsAndConsonants(String word) {
        if (word == null || word.isEmpty()) {
            System.out.println("Vowels: 0");
            System.out.println("Consonants: 0");
            return;
        }
        
        int vowels = 0;
        int consonants = 0;
        
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else if (Character.isLetter(c)) {
                consonants++;
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word: ");
        String word = scanner.nextLine().trim();
        
        countVowelsAndConsonants(word);
    }
}