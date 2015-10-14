package au.com.testers;

/**
 * Created by ravi on 13/10/2015.
 */
public class Game {
    public static final int MAX_MISSES = 7;

    private String mAnswer;
    private String mHits;
    private String mMisses;

    public Game(String answer) {
        this.mAnswer = answer;
        this.mHits = "";
        this.mMisses = "";
    }

    public String getAnswer() {
        return this.mAnswer;
    }

    public boolean applyGuess(char letter) {
        letter = validateGuess(letter);
        boolean isHit = mAnswer.indexOf(letter) >= 0;
        if (isHit) {
            mHits += letter;
        } else {
            mMisses += letter;
        }
        return isHit;
    }

    //refactor
    public boolean applyGuess(String letters) {
        if (letters.length() == 0) {
            throw  new IllegalArgumentException("No letter found");
        }
//        char firstLetter = letters.charAt(0);
//        return applyGuess(firstLetter);
        return applyGuess(letters.charAt(0));
    }

    //step-5 display current progress
    public String getCurrentProgress() {
        String progress = "";

        for (char letter : mAnswer.toCharArray()) {
            char display = '-';
            if (mHits.indexOf(letter) >= 0) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    //step-6 remaining tries
    public int getRemainingTries() {
        return MAX_MISSES - mMisses.length();
    }

    //step-7 validation
    private char validateGuess(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("A letter is required");
        }

        letter = Character.toLowerCase(letter);

        if (mMisses.indexOf(letter) >= 0 || mHits.indexOf(letter) >= 0) {
            throw new IllegalArgumentException(letter + " has already been guessed!");
        }

        return letter;
    }

    public boolean isSolved() {
        return getCurrentProgress().indexOf('-') == -1;
    }
}
