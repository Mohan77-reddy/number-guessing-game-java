import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int userGuess = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");

        while (userGuess != numberToGuess) {

            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } 
            else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } 
            else {
                System.out.println("Correct! You guessed the number!");
            }
        }

        scanner.close();
    }
}
