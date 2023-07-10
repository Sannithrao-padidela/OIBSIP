import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber1 {
    public static void main(String[] args) {
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 5;
        int round = 1;
        int score = 0;
        
        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!");
        
        while (true) {
            JOptionPane.showMessageDialog(null, "Round " + round);
            
            // Generate a random number
            Random random = new Random();
            int randomNumber = rangeStart + random.nextInt(rangeEnd - rangeStart + 1);
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < maxAttempts) {
                // Prompt the user to enter a number
                String input = JOptionPane.showInputDialog("Enter a number between " + rangeStart + " and " + rangeEnd + ":");
                
                // Validate the input
                int guessedNumber;
                try {
                    guessedNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    continue;
                }
                
                // Increment the attempts counter
                attempts++;
                
                // Check if the guessed number matches the random number
                if (guessedNumber == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    
                    // Calculate and update the score
                    score += calculateScore(attempts);
                    guessedCorrectly = true;
                    break;
                } else if (guessedNumber < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry, you didn't guess the number. The correct number was " + randomNumber + ".");
            }
            
            // Ask the user if they want to play another round
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Play Again?", JOptionPane.YES_NO_OPTION);
            
            if (choice == JOptionPane.NO_OPTION) {
                break;
            }
            
            // Increment the round counter
            round++;
        }
        
        JOptionPane.showMessageDialog(null, "Game over! Your final score is: " + score);
    }
    
    // Method to calculate the score based on the number of attempts
    public static int calculateScore(int attempts) {
        int maxScore = 100;
        
        // Adjust the maximum score based on the number of attempts allowed
        if (attempts > 10) {
            maxScore = 50;
        } else if (attempts > 7) {
            maxScore = 75;
        }
        
        // Calculate the score based on the number of attempts
        int score = maxScore - (attempts - 1) * 10;
        
        return score;
    }
}
