import java.util.Scanner;

public class BankTransactionValidator {
    
    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed.toUpperCase();
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }
    
    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be 11 digits";
            }
        }
        
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(reference.substring(0, 3)).append("] ");
        formatted.append("DATE: ");
        formatted.append(reference.substring(3, 5)).append("/");
        formatted.append(reference.substring(5, 7)).append("/");
        formatted.append(reference.substring(7, 9)).append(" | ");
        formatted.append("SEQ: ").append(reference.substring(9));
        
        return formatted.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter reference: ");
        String input = scanner.nextLine();
        
        String normalized = normalizeReference(input);
        System.out.println(validateAndFormat(normalized));
    }
}