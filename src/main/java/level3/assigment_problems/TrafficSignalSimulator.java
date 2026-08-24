package level3.assigment_problems;

public class TrafficSignalSimulator {

    public static void simulateTrafficSignal(int cycles) {
        int state = 0;

        for (int i = 0; i < cycles; i++) {
            switch (state) {
                case 0:
                    System.out.println("Red - Stop");
                    break;
                case 1:
                    System.out.println("Green - Go");
                    break;
                case 2:
                    System.out.println("Yellow - Prepare to stop");
                    break;
                default:
                    System.out.println("Invalid state");
                    break;
            }
            state = (state + 1) % 3;
        }
    }

    public static void main(String[] args) {
        System.out.println("Test cycles=3:");
        simulateTrafficSignal(3);
        System.out.println("---");
        System.out.println("Test cycles=5 (wraparound demo):");
        simulateTrafficSignal(5);
        System.out.println("---");
        System.out.println("Test cycles=1:");
        simulateTrafficSignal(1);
    }
}
