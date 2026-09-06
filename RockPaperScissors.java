import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // Method to decide the result of one round
    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int N = 5;

        String[] moves = {"Rock", "Paper", "Scissors"};

        // Arrays to store round details
        String[] playerMoves = new String[N];
        String[] computerMoves = new String[N];
        String[] results = new String[N];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        // Play N rounds
        for (int i = 0; i < N; i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter your move (Rock/Paper/Scissors): ");

            playerMoves[i] = sc.next();

            // Generate computer move randomly
            int randomNumber = random.nextInt(3);
            computerMoves[i] = moves[randomNumber];

            // Find result
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            System.out.println("Computer: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);

            // Count results
            if (results[i].equals("Player Wins")) {
                wins++;
            } 
            else if (results[i].equals("Computer Wins")) {
                losses++;
            } 
            else {
                draws++;
            }
        }

        // Calculate win percentage
        double winPercentage = ((double) wins / N) * 100;

        // Final summary
        System.out.println("\n========== FINAL SUMMARY ==========");
        System.out.printf("%-8s %-15s %-17s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < N; i++) {
            System.out.printf("%-8d %-15s %-17s %-15s%n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }

        System.out.println("\nWins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);

        sc.close();
    }
}