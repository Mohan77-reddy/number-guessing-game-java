import java.util.*;
import java.io.*;

public class NumberGuessingGame {

    static final String HIGH_SCORE_FILE = "highscore.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int highScore = loadHighScore();
        int score = 0;
        int gamesPlayed = 0;

        char playAgain;

        System.out.println("\u001B[34m===== NUMBER GUESSING GAME =====\u001B[0m");

        do {

            gamesPlayed++;

            int maxNumber = 100;
            int maxAttempts = 7;

            System.out.println("\nChoose Difficulty Level:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");
            System.out.print("Enter choice: ");

            int choice = getValidNumber(scanner);

            if (choice == 1) {
                maxNumber = 50;
                maxAttempts = 10;
            } else if (choice == 3) {
                maxNumber = 200;
                maxAttempts = 5;
            }

            int numberToGuess = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessed = false;

            ArrayList<Integer> guessHistory = new ArrayList<>();

            System.out.println("\nGuess a number between 1 and " + maxNumber);

            while (attempts < maxAttempts) {

                System.out.print("Enter guess: ");
                int guess = getValidNumber(scanner);

                guessHistory.add(guess);
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("\u001B[33mToo low!\u001B[0m");
                }
                else if (guess > numberToGuess) {
                    System.out.println("\u001B[33mToo high!\u001B[0m");
                }
                else {
                    System.out.println("\u001B[32mCorrect! You guessed it in " + attempts + " attempts.\u001B[0m");
                    guessed = true;
                    score++;
                    break;
                }

                giveHint(numberToGuess, guess);

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\u001B[31mYou lost! Number was: " + numberToGuess + "\u001B[0m");
            }

            if (score > highScore) {
                highScore = score;
                saveHighScore(highScore);
                System.out.println("🏆 New High Score!");
            }

            System.out.println("\nGuess History: " + guessHistory);

            System.out.println("\n===== GAME STATS =====");
            System.out.println("Games Played: " + gamesPlayed);
            System.out.println("Score: " + score);
            System.out.println("High Score: " + highScore);

            System.out.print("\nPlay again? (y/n): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\nThanks for playing!");

        scanner.close();
    }

    public static int getValidNumber(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void giveHint(int target, int guess) {
        int diff = Math.abs(target - guess);

        if (diff <= 5)
            System.out.println("🔥 Very close!");
        else if (diff <= 15)
            System.out.println("🙂 Close.");
        else
            System.out.println("❄️ Far away.");
    }

    public static int loadHighScore() {
        try {
            File file = new File(HIGH_SCORE_FILE);
            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);
                int score = fileScanner.nextInt();
                fileScanner.close();
                return score;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static void saveHighScore(int score) {
        try {
            PrintWriter writer = new PrintWriter(HIGH_SCORE_FILE);
            writer.println(score);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving high score.");
        }
    }
}
