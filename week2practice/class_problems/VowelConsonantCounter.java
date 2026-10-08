import java.util.Scanner;

public class VowelConsonantCounter {
    
    public static void countVowelsAndConsonants(String text) {
        if (text == null || text.isEmpty()) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }
        
        int vowels = 0;
        int consonants = 0;
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') continue;
            
            char lower = Character.toLowerCase(c);
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                vowels++;
            } else if (Character.isLetter(c)) {
                consonants++;
            }
        }
        
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        
        countVowelsAndConsonants(input);
    }
}