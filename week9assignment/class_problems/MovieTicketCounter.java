import java.util.*;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getPricePerTicket();

    public double getTotal() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }

    public abstract String getSeatType();
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) { super(count); }
    public double getPricePerTicket() { return 150; }
    public String getSeatType() { return "REGULAR"; }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) { super(count); }
    public double getPricePerTicket() { return 250; }
    public String getSeatType() { return "PREMIUM"; }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) { super(count); }
    public double getPricePerTicket() { return 400; }
    public String getSeatType() { return "RECLINER"; }
}

class TicketCounter {
    public void processTickets(List<Ticket> tickets) {
        double total = 0;
        for (Ticket t : tickets) {
            System.out.printf("%s: %.2f%n", t.getSeatType(), t.getTotal());
            total += t.getTotal();
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            int count = Integer.parseInt(parts[1]);
            Ticket ticket = null;
            switch (type) {
                case "REGULAR": ticket = new RegularTicket(count); break;
                case "PREMIUM": ticket = new PremiumTicket(count); break;
                case "RECLINER": ticket = new ReclinerTicket(count); break;
            }
            if (ticket != null) tickets.add(ticket);
        }
        new TicketCounter().processTickets(tickets);
    }
}