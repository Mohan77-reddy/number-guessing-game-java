import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {

            int maxNumber = 100;
            int maxAttempts = 7;

            System.out.println("\nChoose Difficulty Level:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                maxNumber = 50;
                maxAttempts = 10;
            } 
            else if (choice == 2) {
                maxNumber = 100;
                maxAttempts = 7;
            } 
            else if (choice == 3) {
                maxNumber = 200;
                maxAttempts = 5;
            } 
            else {
                System.out.println("Invalid choice! Defaulting to Medium.");
                maxNumber = 100;
                maxAttempts = 7;
            }

            int numberToGuess = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and " + maxNumber);
            System.out.println("You have " + maxAttempts + " attempts!");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } 
                else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } 
                else {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You lost! The correct number was: " + numberToGuess);
            }

            System.out.println("Current Score: " + score);

            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\nThanks for playing! Final Score: " + score);

        scanner.close();
    }
}
