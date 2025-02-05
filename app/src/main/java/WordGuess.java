import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordGuess implements Game {
    private String word;
    private char[] guessedWord;
    private int attempts;
    private Scanner scanner;
    private static final String[] WORD_LIST = {"apple", "banana", "cherry", "orange", "grape"};

    public WordGuess(int maxAttempts) {
        this.word = chooseRandomWord();
        this.guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '_');
        this.attempts = maxAttempts;
        this.scanner = new Scanner(System.in);
    }

    private String chooseRandomWord() {
        Random random = new Random();
        return WORD_LIST[random.nextInt(WORD_LIST.length)];
    }

    public void startGame() {
        System.out.println("Welcome to Word Guess!");
    }

    public void printBoard() {
        System.out.println("Word: " + String.valueOf(guessedWord));
        System.out.println("You have " + attempts + " chances remaining");
    }

    public void takeTurn() {
        System.out.print("Guess the letter or the entire word: ");
        String guess = scanner.next().toLowerCase();

        if (guess.length() == 1) {
            char guessedLetter = guess.charAt(0);
            boolean found = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guessedLetter) {
                    guessedWord[i] = guessedLetter;
                    found = true;
                }
            }

            if (!found) {
                attempts--;
                System.out.println(guessedLetter + " is not in the word");
            }
        } else if (guess.equals(word)) {
            guessedWord = word.toCharArray();
        } else {
            attempts--;
            System.out.println("Sorry, your guess was wrong");
        }
    }

    public boolean isGameOver() {
        return attempts == 0 || String.valueOf(guessedWord).equals(word);
    }

    public void endGame() {
        if (String.valueOf(guessedWord).equals(word)) {
            System.out.println("Congrats, your guess was correct! The word was \"" + word + "\"");
        } else {
            System.out.println("Sorry, your guesses were wrong. The word was \"" + word + "\"");
        }

        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next().toLowerCase();

        if (response.equals("yes")) {
            resetGame();
            playGame();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    private void resetGame() {
        this.word = chooseRandomWord();
        this.guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '_');
        this.attempts = 7;
    }

    public void playGame() {
        startGame();
        while (!isGameOver()) {
            printBoard();
            takeTurn();
        }
        endGame();
    }

    public static void main(String[] args) {
        WordGuess game = new WordGuess(7);
        game.playGame();
    }
}
