public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Jar jar = admin.createJar();
        Prompter prompter;

        // Do play the game while you want to play again
        do{
            jar.fillJarRandomly();
            Game game = new Game(jar);
            prompter = new Prompter(game);

            prompter.displayWelcome();

            // While the amount has not been guessed (not won), keep trying
            while(!game.isWon()){
                prompter.promptForGuess();
            }

            prompter.displayOutcome();
        } while (prompter.playAgain());
    }
}
