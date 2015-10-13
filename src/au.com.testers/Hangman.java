package au.com.testers;

public class Hangman {
    public static void main(String[] args) {
        //Getting Started
//        System.out.println("Hello World!");

        //Storing Guesses
        Game game = new Game("Tester");

//        System.out.println(game.applyGuess('t'));
//        System.out.println(game.applyGuess('x'));

        //Prompting for guesses
        Prompter prompter = new Prompter(game);
        prompter.displayProgress(); //display current progress
        boolean isHit = prompter.promptForGuess();

        if (isHit) {
            System.out.println("We got a hit :)");
        } else {
            System.out.println("That was a miss :(");
        }

        prompter.displayProgress(); //display current progress
    }
}