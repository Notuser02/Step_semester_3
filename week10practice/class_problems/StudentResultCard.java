import java.util.Scanner;

class Student {
    String name;
    int[] marks;
    
    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
    
    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
    
    public String getGrade(double average) {
        if (average >= 75) {
            return "B";
        } else if (average >= 60) {
            return "A";
        } else if (average >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
    
    public void printResultCard() {
        double avg = calculateAverage();
        String grade = getGrade(avg);
        System.out.printf("%s: Average %.1f, Grade %s%n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCard {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter 3 marks: ");
            int[] marks = new int[3];
            for (int j = 0; j < 3; j++) {
                marks[j] = scanner.nextInt();
            }
            scanner.nextLine();
            
            Student student = new Student(name, marks);
            student.printResultCard();
        }
    }
}