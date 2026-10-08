import java.util.*;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private int hours;
    private double rate;

    public HourlyStaff(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }
}

class Intern extends Staff {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    public double calculatePay() {
        return stipend;
    }
}

class Payroll {
    public void processPayroll(List<Staff> staffList) {
        double total = 0;
        for (Staff s : staffList) {
            double pay = s.calculatePay();
            System.out.printf("%s: %.2f%n", s.getName(), pay);
            total += pay;
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Staff> staffList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            Staff staff = null;
            switch (type) {
                case "FULLTIME":
                    double salary = Double.parseDouble(parts[2]);
                    staff = new FullTimeStaff(name, salary);
                    break;
                case "HOURLY":
                    int hours = Integer.parseInt(parts[2]);
                    double rate = Double.parseDouble(parts[3]);
                    staff = new HourlyStaff(name, hours, rate);
                    break;
                case "INTERN":
                    double stipend = Double.parseDouble(parts[2]);
                    staff = new Intern(name, stipend);
                    break;
            }
            if (staff != null) staffList.add(staff);
        }
        new Payroll().processPayroll(staffList);
    }
}