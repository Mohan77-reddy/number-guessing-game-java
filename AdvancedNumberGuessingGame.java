import java.util.*;

public class AdvancedNumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int gamesPlayed = 0;
        char playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {

            gamesPlayed++;

            System.out.println("\nChoose Difficulty:");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-200)");

            int choice = scanner.nextInt();

            int maxNumber = 100;
            int maxAttempts = 7;

            if (choice == 1) {
                maxNumber = 50;
                maxAttempts = 10;
            } 
            else if (choice == 3) {
                maxNumber = 200;
                maxAttempts = 5;
            }

            int numberToGuess = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("Guess a number between 1 and " + maxNumber);

            while (attempts < maxAttempts) {

                System.out.print("Enter guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } 
                else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } 
                else {
                    System.out.println("Correct! Attempts: " + attempts);
                    score++;
                    guessed = true;
                    break;
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("Game Over! Number was " + numberToGuess);
            }

            System.out.println("Games Played: " + gamesPlayed);
            System.out.println("Score: " + score);

            System.out.print("Play again? (y/n): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'y');

        scanner.close();
    }
}
