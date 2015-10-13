package au.com.testers;

/**
 * Created by ravi on 13/10/2015.
 */
public class Game {
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
}
