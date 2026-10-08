import java.util.Scanner;

public class FileExtensionValidator {
    
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.isEmpty()) {
            return "Rejected — invalid file type";
        }
        
        int lastDot = filename.lastIndexOf('.');
        
        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        
        String extension = filename.substring(lastDot + 1).toLowerCase();
        
        if (extension.equals("pdf") || extension.equals("docx") || extension.equals("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter filename: ");
        String input = scanner.nextLine();
        
        System.out.println(validateFileExtension(input));
    }
}