import java.util.Scanner;

public class ReverseCustomerName {
    
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) return "";
        
        char[] chars = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder();
        
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed.append(chars[i]);
        }
        
        return reversed.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        
        String reversed = reverseCustomerName(name);
        
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);
    }
}