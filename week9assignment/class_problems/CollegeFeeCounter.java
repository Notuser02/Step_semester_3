import java.util.*;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;
    protected static final double TRANSPORT_FEE = 12000;

    public Student(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract double getTuition();

    public boolean usesBus() {
        return this instanceof BusUser;
    }

    public double getTransportFee() {
        return usesBus() ? TRANSPORT_FEE : 0;
    }

    public double getTotalFee() {
        return getTuition() + getTransportFee();
    }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) { super(name); }
    public double getTuition() { return 40000; }
    public double getTransportFee() { return TRANSPORT_FEE; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    public double getTuition() { return 40000 + 60000; }
}

class Scholar extends Student implements BusUser {
    public Scholar(String name) { super(name); }
    public double getTuition() { return 20000; }
    public double getTransportFee() { return TRANSPORT_FEE; }
}

class FeeCounter {
    public void processStudents(List<Student> students) {
        double total = 0;
        for (Student s : students) {
            System.out.printf("%s: %.2f%n", s.getName(), s.getTotalFee());
            total += s.getTotalFee();
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            Student student = null;
            switch (type) {
                case "DAY_SCHOLAR": student = new DayScholar(name); break;
                case "HOSTELLER": student = new Hosteller(name); break;
                case "SCHOLAR": student = new Scholar(name); break;
            }
            if (student != null) students.add(student);
        }
        new FeeCounter().processStudents(students);
    }
}