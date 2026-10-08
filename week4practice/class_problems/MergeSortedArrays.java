import java.util.Scanner;

public class MergeSortedArrays {
    
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter arr1 length: ");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        
        System.out.print("Enter " + n1 + " sorted numbers for arr1: ");
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }
        
        System.out.print("Enter arr2 length: ");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        
        System.out.print("Enter " + n2 + " sorted numbers for arr2: ");
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }
        
        int[] result = mergeSortedArrays(arr1, arr2);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}