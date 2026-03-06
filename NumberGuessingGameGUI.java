import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessingGameGUI {

    private int numberToGuess;
    private int attempts;
    private int maxAttempts = 7;

    private JTextField guessField;
    private JLabel messageLabel;
    private JLabel attemptsLabel;

    public NumberGuessingGameGUI() {

        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;

        JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(400,250);
        frame.setLayout(new GridLayout(5,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Guess a number (1-100)", JLabel.CENTER);

        guessField = new JTextField();
        JButton guessButton = new JButton("Submit Guess");

        messageLabel = new JLabel("Start guessing!", JLabel.CENTER);
        attemptsLabel = new JLabel("Attempts left: 7", JLabel.CENTER);

        guessButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    int guess = Integer.parseInt(guessField.getText());
                    attempts++;

                    if (guess < numberToGuess) {
                        messageLabel.setText("Too low!");
                    }
                    else if (guess > numberToGuess) {
                        messageLabel.setText("Too high!");
                    }
                    else {
                        messageLabel.setText("Correct! You guessed it!");
                        guessButton.setEnabled(false);
                    }

                    attemptsLabel.setText("Attempts left: " + (maxAttempts - attempts));

                    if (attempts >= maxAttempts && guess != numberToGuess) {
                        messageLabel.setText("Game Over! Number was " + numberToGuess);
                        guessButton.setEnabled(false);
                    }

                } catch(Exception ex) {
                    messageLabel.setText("Enter a valid number!");
                }

                guessField.setText("");
            }

        });

        frame.add(title);
        frame.add(guessField);
        frame.add(guessButton);
        frame.add(messageLabel);
        frame.add(attemptsLabel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new NumberGuessingGameGUI();
    }
}
