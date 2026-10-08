import java.util.*;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if (playerMove.equalsIgnoreCase("Rock")) {
            return computerMove.equalsIgnoreCase("Scissors") ? "Player Wins" : "Computer Wins";
        }
        if (playerMove.equalsIgnoreCase("Paper")) {
            return computerMove.equalsIgnoreCase("Rock") ? "Player Wins" : "Computer Wins";
        }
        if (playerMove.equalsIgnoreCase("Scissors")) {
            return computerMove.equalsIgnoreCase("Paper") ? "Player Wins" : "Computer Wins";
        }
        return "Invalid Move";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter number of rounds (default 5): ");
        int n = scanner.hasNextInt() ? scanner.nextInt() : 5;
        scanner.nextLine();
        
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[][] results = new String[n][4];
        
        int wins = 0, losses = 0, draws = 0;
        
        for (int i = 0; i < n; i++) {
            System.out.print("Round " + (i + 1) + " - Player (Rock/Paper/Scissors): ");
            String playerMove = scanner.nextLine().trim();
            
            if (!Arrays.asList(moves).contains(playerMove)) {
                System.out.println("Invalid move! Defaulting to Rock.");
                playerMove = "Rock";
            }
            
            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);
            
            results[i][0] = String.valueOf(i + 1);
            results[i][1] = playerMove;
            results[i][2] = computerMove;
            results[i][3] = result;
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            
            System.out.println("Computer: " + computerMove + " -> " + result);
        }
        
        System.out.println("\n--- Final Summary ---");
        System.out.printf("%-8s %-15s %-15s %s%n", "Round", "Player Move", "Computer Move", "Result");
        for (String[] row : results) {
            System.out.printf("%-8s %-15s %-15s %s%n", row[0], row[1], row[2], row[3]);
        }
        System.out.println();
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", 
            wins, losses, draws, n > 0 ? (wins * 100.0 / n) : 0);
    }
}