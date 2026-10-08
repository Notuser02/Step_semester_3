import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

abstract class LibraryItem {
    private String title;
    public LibraryItem(String title) { this.title = title; }
    public String getTitle() { return title; }
    public abstract int getBorrowDays();
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowDays());
    }
}

class Book extends LibraryItem {
    public Book(String title) { super(title); }
    public int getBorrowDays() { return 14; }
}

class DVD extends LibraryItem {
    public DVD(String title) { super(title); }
    public int getBorrowDays() { return 7; }
}

class Magazine extends LibraryItem {
    public Magazine(String title) { super(title); }
    public int getBorrowDays() { return 3; }
}

class LibraryProcessor {
    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Map<String, java.util.function.Function<String, LibraryItem>> factory = new HashMap<>();

    public LibraryProcessor() {
        factory.put("BOOK", Book::new);
        factory.put("DVD", DVD::new);
        factory.put("MAGAZINE", Magazine::new);
    }

    public void processItems(List<String[]> items) {
        for (String[] item : items) {
            String type = item[0];
            String title = item[1].replaceAll("^\"|\"$", "");
            java.util.function.Function<String, LibraryItem> creator = factory.get(type);
            if (creator != null) {
                LibraryItem libItem = creator.apply(title);
                LocalDate dueDate = libItem.calculateDueDate(CURRENT_DATE);
                System.out.println(title + ": " + dueDate.format(FORMATTER));
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String[]> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+", 2);
            items.add(new String[]{parts[0], parts[1]});
        }
        new LibraryProcessor().processItems(items);
    }
}