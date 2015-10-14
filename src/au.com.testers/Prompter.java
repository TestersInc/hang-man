package au.com.testers;

import java.io.Console;
import java.util.Scanner;

/**
 * Created by ravi on 13/10/2015.
 */
public class Prompter {
    private Game mGame;

    public Prompter(Game game) {
        this.mGame = game;
    }

    //step-6
    public void play() {
        while (mGame.getRemainingTries() > 0 && !mGame.isSolved()) {
            displayProgress();
            promptForGuess();
        }

        if (mGame.isSolved()) {
            System.out.printf("Congrats! you won with %d tries remaining. :) \n", mGame.getRemainingTries());
        } else {
            System.out.printf("Bummer! the word was %s. :( \n", mGame.getAnswer());
        }
    }

    public boolean promptForGuess() {
//        Console console = System.console();
        Scanner sc = new Scanner(System.in);
//        String guessAsString = console.readLine("Enter a letter:  ");

        //validate
        boolean isHit = false;
        boolean isValidGuess = false;

        while (!isValidGuess) {
//            String guessAsString = console.readLine("Enter a letter:  ");
//            char guessLetter = guessAsString.charAt(0);
            String guessAsString = sc.next();
            try {
//                isHit = mGame.applyGuess(guessLetter);
                isHit = mGame.applyGuess(guessAsString);
                isValidGuess = true;
            } catch (IllegalArgumentException iae) {
//                console.printf("%s. Please try again \n", iae.getMessage());
                System.out.printf("%s. Please try again \n", iae.getMessage());
            }
        }

//        char guessLetter = guessAsString.charAt(0);

//        return mGame.applyGuess(guessLetter);
        return isHit;
    }

    //step-6
    public void displayProgress() {
        System.out.printf("You have %d tries left to solve %s \n", mGame.getRemainingTries(), mGame.getCurrentProgress());
    }
}
