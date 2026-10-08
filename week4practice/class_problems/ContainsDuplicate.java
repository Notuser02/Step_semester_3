import java.util.Scanner;

public class ContainsDuplicate {
    
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter array length: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        System.out.print("Enter " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.println(containsDuplicate(nums));
    }
}