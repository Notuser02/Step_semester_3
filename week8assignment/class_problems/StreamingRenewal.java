import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

interface Plan {
    String getName();
    int getValidityDays();
}

class BasicPlan implements Plan {
    public String getName() { return "BASIC"; }
    public int getValidityDays() { return 30; }
}

class StandardPlan implements Plan {
    public String getName() { return "STANDARD"; }
    public int getValidityDays() { return 90; }
}

class PremiumPlan implements Plan {
    public String getName() { return "PREMIUM"; }
    public int getValidityDays() { return 365; }
}

class SubscriptionManager {
    private Map<String, Plan> plans = new HashMap<>();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public SubscriptionManager() {
        plans.put("BASIC", new BasicPlan());
        plans.put("STANDARD", new StandardPlan());
        plans.put("PREMIUM", new PremiumPlan());
    }

    public void processSubscriptions(List<String[]> subs) {
        for (String[] s : subs) {
            String type = s[0];
            String name = s[1];
            LocalDate startDate = LocalDate.parse(s[2], FORMATTER);
            Plan plan = plans.get(type);
            if (plan != null) {
                LocalDate renewalDate = startDate.plusDays(plan.getValidityDays());
                System.out.println(name + ": " + renewalDate.format(FORMATTER));
            }
        }
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String[]> subs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            subs.add(parts);
        }
        new SubscriptionManager().processSubscriptions(subs);
    }
}