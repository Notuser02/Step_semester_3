import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingChar {
    
    public static Character findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) return null;
        
        Map<Character, Integer> frequency = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        
        for (char c : text.toCharArray()) {
            if (frequency.get(c) == 1) {
                return c;
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word or sentence: ");
        String input = scanner.nextLine();
        
        Character result = findFirstNonRepeatingChar(input);
        
        if (result != null) {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }
}