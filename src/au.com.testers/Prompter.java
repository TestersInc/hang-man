package au.com.testers;

import java.io.Console;

/**
 * Created by ravi on 13/10/2015.
 */
public class Prompter {
    private Game mGame;

    public Prompter(Game game) {
        this.mGame = game;
    }

    public boolean promptForGuess() {
        Console console = System.console();
        String guessAsString = console.readLine("Enter a letter:  ");

        char guessLetter = guessAsString.charAt(0);

        return mGame.applyGuess(guessLetter);
    }
}
