import java.util.Scanner;

public class DigitSumAndReversal {
    
    public static void digitSumAndReverse(int number) {
        int original = number;
        int sum = 0;
        int reversed = 0;
        
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        digitSumAndReverse(number);
    }
}