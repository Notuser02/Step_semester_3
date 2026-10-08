import java.util.*;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    public double calculateFine() {
        return 2 * daysLate;
    }
}

class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    public double calculateFine() {
        double fine = 5 * daysLate;
        return Math.min(fine, 50);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    public double calculateFine() {
        return 1 * daysLate;
    }
}

class FineCounter {
    public void processFines(List<LibraryItem> items) {
        double total = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
            total += fine;
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}

public class LibraryFines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String title = parts[1];
            int daysLate = Integer.parseInt(parts[2]);
            LibraryItem item = null;
            switch (type) {
                case "BOOK":
                    item = new Book(title, daysLate);
                    break;
                case "DVD":
                    item = new DVD(title, daysLate);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title, daysLate);
                    break;
            }
            if (item != null) items.add(item);
        }
        new FineCounter().processFines(items);
    }
}