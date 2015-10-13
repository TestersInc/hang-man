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

    public boolean applyGuess(char letter) {
        boolean isHit = mAnswer.indexOf(letter) >= 0;
        if (isHit) {
            mHits += letter;
        } else {
            mMisses += letter;
        }
        return isHit;
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
}
