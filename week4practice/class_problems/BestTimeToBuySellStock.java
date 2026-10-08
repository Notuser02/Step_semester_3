import java.util.Scanner;

public class BestTimeToBuySellStock {
    
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter array length: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        
        System.out.print("Enter " + n + " prices: ");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        
        System.out.println(maxProfit(prices));
    }
}