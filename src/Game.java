import java.util.HashSet;
import java.util.Set;

public class Game {

    private Jar jar;
    private Set<Integer> guesses = new HashSet<>();
    private boolean won = false;

    public Game(Jar jar) {
        this.jar = jar;
    }

    public boolean isWon() {
        return won;
    }

    public Jar getJar(){
        return this.jar;
    }

    public int getTries(){
        return this.guesses.size();
    }

    public boolean applyGuess(int guess) {
        this.won = guess == jar.getNumberOfItems();

        if(guess > jar.getMaxNumberOfItems()){
            System.out.printf("Oops, remember that your guess should be less than %d%n", jar.getMaxNumberOfItems());
            return false;
        }

        if(!this.won) {
            if(guess > jar.getNumberOfItems()){
                System.out.printf("Your guess is too high. ");
            } else {
                System.out.printf("Your guess is too low. ");
            }


        }

        guesses.add(guess);

        return this.won;
    }

}
