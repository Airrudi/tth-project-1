import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Admin {

    public Admin() {}

    public Jar createJar(){
        System.out.println("===== ADMINISTRATOR =====");

        String itemName = promptItemName();
        int maxNumberOfItems = promptMaxNumberOfItems(itemName);

        return new Jar(itemName, maxNumberOfItems);
    }

    private String promptItemName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What items will be put in the jar?");
        String itemName = scanner.nextLine();

        // TODO: Validation
        return itemName;
    }

    private int promptMaxNumberOfItems(String itemName){
        Scanner scanner = new Scanner(System.in);
        boolean validEntry = false;
        int maxNumberOfItems = 0;

        System.out.printf("What is the maximum amount of %s that can be stored in the jar?%n", itemName);

        do {
            String entry = scanner.nextLine();

            try {
                maxNumberOfItems = Integer.parseInt(entry);
                validEntry = true;
            } catch (NumberFormatException nfe){
                System.out.println("Please enter a number");
            }

        } while (!validEntry);

        System.out.printf("============================== %n%n");

        return maxNumberOfItems;
    }
}
