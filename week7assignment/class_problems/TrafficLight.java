public class TrafficLight {
    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public void next() {
        switch (this.color) {
            case "RED":
                this.color = "GREEN";
                break;
            case "GREEN":
                this.color = "YELLOW";
                break;
            case "YELLOW":
                this.color = "RED";
                break;
        }
    }

    public String getColor() {
        return this.color;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Initial: " + t.getColor());
        t.next();
        System.out.println("After next(): " + t.getColor());
        t.next();
        System.out.println("After next(): " + t.getColor());
        t.next();
        System.out.println("After next(): " + t.getColor());
    }
}