package level3.assigment_problems;

/**
 * P3. Traffic Signal Simulator
 * Concepts: switch statement, for loops, modulus operator for wraparound, state cycling
 */
public class TrafficSignalSimulator {

    /**
     * Cycles traffic signal through Red, Green, Yellow for fixed number of cycles.
     * 0 = Red, 1 = Green, 2 = Yellow
     * Suggested signature: void simulateTrafficSignal(int cycles)
     */
    public static void simulateTrafficSignal(int cycles) {
        int state = 0; // start at Red

        // for loop over the cycles
        for (int i = 0; i < cycles; i++) {
            // switch statement on current state index
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
            // advance to next state, wrapping back to Red after Yellow using modulus
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
