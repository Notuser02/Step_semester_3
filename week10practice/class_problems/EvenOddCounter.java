import java.util.Scanner;

public class EvenOddCounter {
    
    public static void countEvenOdd(int[] numbers) {
        int even = 0;
        int odd = 0;
        
        for (int num : numbers) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        
        System.out.print("Enter " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        countEvenOdd(numbers);
    }
}