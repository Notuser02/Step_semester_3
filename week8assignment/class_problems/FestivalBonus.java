import java.util.*;

interface Employee {
    String getName();
    double getSalary();
    String getType();
    double calculateBonus();
}

abstract class BaseEmployee implements Employee {
    protected String name;
    protected double salary;

    public BaseEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
}

class FullTimeEmployee extends BaseEmployee {
    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }
    public String getType() { return "FULLTIME"; }
    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends BaseEmployee {
    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }
    public String getType() { return "PARTTIME"; }
    public double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends BaseEmployee {
    public Intern(String name, double salary) {
        super(name, salary);
    }
    public String getType() { return "INTERN"; }
    public double calculateBonus() {
        return 2000;
    }
}

class BonusCalculator {
    public void processEmployees(List<Employee> employees) {
        double total = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f%n", e.getName(), bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);
            Employee e = null;
            switch (type) {
                case "FULLTIME": e = new FullTimeEmployee(name, salary); break;
                case "PARTTIME": e = new PartTimeEmployee(name, salary); break;
                case "INTERN": e = new Intern(name, salary); break;
            }
            if (e != null) employees.add(e);
        }
        new BonusCalculator().processEmployees(employees);
    }
}