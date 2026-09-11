import java.util.ArrayList;
import java.util.Arrays;

public class Problem5_FantasyLeagueAutoDraft {
    
    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;
        
        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }
        
        public String getName() {
            return name;
        }
        
        public int getMatchesPlayed() {
            return matchesPlayed;
        }
        
        public double getBattingAverage() {
            return battingAverage;
        }
        
        public boolean isInjured() {
            return injured;
        }
        
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
    
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }
    
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }
    
    public static String draftAndRank(Player[] players) {
        ArrayList<Player> draftable = new ArrayList<>();
        
        for (Player player : players) {
            boolean draftableFlag = false;
            
            if (isDraftable(player.getMatchesPlayed())) {
                draftableFlag = true;
            } else if (isDraftable(player.getMatchesPlayed(), player.isInjured())) {
                draftableFlag = true;
            }
            
            if (draftableFlag) {
                draftable.add(player);
            }
        }
        
        Player[] draftableArray = draftable.toArray(new Player[0]);
        Arrays.sort(draftableArray);
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(draftableArray[i].getName());
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        
        System.out.println(draftAndRank(players));
    }
}