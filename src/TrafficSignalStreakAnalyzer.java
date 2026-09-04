public class TrafficSignalStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog.length() == 0) {
            System.out.println("Longest Streak: '' repeated 0 times");
            return;
        }

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;
        char longestChar = currentChar;
        int longestStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentStreak++;
            } else {
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    longestChar = currentChar;
                }
                currentChar = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        if (currentStreak > longestStreak) {
            longestStreak = currentStreak;
            longestChar = currentChar;
        }

        System.out.println("Longest Streak: '" + longestChar + "' repeated " + longestStreak + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}