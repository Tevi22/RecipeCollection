import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        RecipeBox myRecipeBox = new RecipeBox();
        boolean quit = false;

        while (!quit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new recipe");
            System.out.println("2. List all recipe names");
            System.out.println("3. View a recipe");
            System.out.println("4. Quit");
            System.out.print("Enter choice: ");

            int choice;
            while (!scnr.hasNextInt()) {
                System.out.print("Invalid input. Enter a number between 1 and 4: ");
                scnr.next();
            }
            choice = scnr.nextInt();
            scnr.nextLine(); // consume newline

            //FIXME Add custom method choice to menu to scale recipe ingredients


            switch (choice) {
                case 1:
                    // Create new recipe using the createNewRecipe() method from Recipe class
                    myRecipeBox.addNewRecipe();
                    break;

                case 2:
                    myRecipeBox.printAllRecipeNames();
                    break;

                case 3:
                    System.out.print("Enter the name of the recipe to view: ");
                    String selectedRecipeName = scnr.nextLine();
                    myRecipeBox.printAllRecipeDetails(selectedRecipeName);
                    break;

                case 4:
                    quit = true;
                    System.out.println("Exiting Recipe Box. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select from 1 to 4.");
            }
        }

        scnr.close();

    }
}
