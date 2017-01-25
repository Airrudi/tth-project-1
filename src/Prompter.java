import java.util.Scanner;

public class Prompter {

    Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public void displayWelcome(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Are you ready to play the game?");
        scanner.nextLine();

        System.out.printf("%n===== JAR GAMBLER 2000 ===== %n");
        System.out.printf("Guess the amount of %s in the jar, has to be between 1 and %s.%n",game.getJar().getItemName(), game.getJar().getMaxNumberOfItems());
    }

    public boolean promptForGuess(){
        Scanner scanner = new Scanner(System.in);
        boolean validEntry = false;
        boolean won = false;
        int guess = 0;

        System.out.printf("How many %s are in the jar?%n", game.getJar().getItemName());

        do {
            String entry = scanner.nextLine();

            try {
                guess = Integer.parseInt(entry);
                validEntry = true;
                won = game.applyGuess(guess);
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a number");
            }
        } while (!validEntry);

        return won;
    }

    public boolean playAgain(){
        boolean playAgain = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Play another game? (Y / N)");
        char entry = scanner.nextLine().toUpperCase().charAt(0);

        if(entry == 'Y'){
            playAgain = true;
        }

        return playAgain;
    }

    public void displayOutcome(){
        System.out.printf("Congratulations! You guessed the correct amount of %s (%s) in %s tries!%n", game.getJar().getItemName(), game.getJar().getNumberOfItems(), game.getTries());
    }
}
