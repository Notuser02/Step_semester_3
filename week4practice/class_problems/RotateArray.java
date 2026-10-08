import java.util.Scanner;

public class RotateArray {
    
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        k = k % n;
        if (k < 0) k += n;
        if (k == 0) return nums.clone();
        
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }
        
        return rotated;
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
        
        System.out.print("Enter k (rotation steps): ");
        int k = scanner.nextInt();
        
        int[] result = rotateArray(nums, k);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}