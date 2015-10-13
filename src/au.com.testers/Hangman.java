package au.com.testers;

public class Hangman {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
        Game game = new Game("Tester");

        System.out.println(game.applyGuess('t'));
        System.out.println(game.applyGuess('x'));
    }
}