import java.util.Random;

public class Jar {

    private String itemName;
    private int maxNumberOfItems;
    private int numberOfItems;

    public Jar(String itemName, int maxNumberOfItems) {
        this.itemName = itemName;
        this.maxNumberOfItems = maxNumberOfItems;

        //fillJarRandomly(); // Commented so prompter.playAgain() triggers new random number to be generated
    }

    public String getItemName() {
        return itemName;
    }

    public int getMaxNumberOfItems() {
        return maxNumberOfItems;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void fillJarRandomly(){
        Random random = new Random();
        this.numberOfItems = random.nextInt(this.maxNumberOfItems) + 1;
    }
}
