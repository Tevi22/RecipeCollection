import java.util.Scanner;

/**
 * * Main class to run the RecipeBox application.
 * It provides a menu for users to interact with the recipe box.
 */

public class Main {
    /** * Main method to start the RecipeBox application.
     * It initializes the RecipeBox and provides a menu for user interaction.
     * 
     * @param args command line arguments (not used)
     */
    // Main method to run the RecipeBox application
    public static void main(String[] args) {

        // Initialize the RecipeBox and Scanner for user input
        System.out.println("Welcome to the Recipe Box!");
        Scanner scnr = new Scanner(System.in);

        // Create a new RecipeBox instance
        // This will hold all the recipes added by the user
        RecipeBox myRecipeBox = new RecipeBox();

        // Main loop for the menu
        // It will continue until the user chooses to quit
        boolean quit = false;

        // Loop to display the menu and handle user choices
        // The loop will run until the user selects the option to quit
        while (!quit) {

            // Display the menu options to the user
            System.out.println("\nMenu:");
            System.out.println("1. Add a new recipe");
            System.out.println("2. List all recipe names");
            System.out.println("3. View a recipe");
            System.out.println("4. Scale a recipe"); // Custom method to scale recipe ingredients
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");

            // Read user input for menu choice
            // It expects an integer input corresponding to the menu options
            int choice;

            // Validate input is an integer and within the range of menu options
            while (!scnr.hasNextInt()) {
                System.out.print("Invalid input. Enter a number between 1 and 4: ");
                scnr.next();
            }

            // Read the choice from the user
            choice = scnr.nextInt();
            scnr.nextLine(); // consume newline

            // Handle the user's choice using a switch statement
            // Each case corresponds to a menu option
            switch (choice) {
                case 1:
                    // Create new recipe using the createNewRecipe() method from Recipe class
                    myRecipeBox.addNewRecipe();
                    break;

                case 2:
                    // Print all recipe names using the printAllRecipeNames() method from RecipeBox
                    // class
                    myRecipeBox.printAllRecipeNames();
                    break;

                case 3:
                    // Print details of a specific recipe using the printAllRecipeDetails() method
                    // from RecipeBox class
                    System.out.print("Enter the name of the recipe to view: ");
                    String selectedRecipeName = scnr.nextLine();
                    myRecipeBox.printAllRecipeDetails(selectedRecipeName);
                    break;

                case 4:
                    // Scale a recipe using the scaleRecipe() method from Recipe class
                    System.out.print("Enter the name of the recipe to view: ");
                    String recipeToScale = scnr.nextLine();
                    Recipe recipe = null;
                    for (Recipe r : myRecipeBox.getListOfRecipes()) {
                        if (r.getRecipeName().equalsIgnoreCase(recipeToScale)) {
                            recipe = r;
                            break;
                        }
                    }
                    if (recipe != null) {
                        System.out.print("Enter the scale factor (e.g., 2 for double, 0.5 for half): ");
                        double scaleFactor;
                        while (!scnr.hasNextDouble()) {

                            System.out.print("Invalid input. Enter a valid scale factor: ");
                            scnr.next();
                        }
                        scaleFactor = scnr.nextDouble();
                        scnr.nextLine(); // consume newline
                        recipe.scaleRecipe(scaleFactor);
                        System.out.println("Recipe scaled successfully.");
                    } else {
                        System.out.println("Recipe not found.");
                    }
                    break;

                case 5:
                    // Set quit to true to exit the loop and end the program
                    quit = true;
                    System.out.println("Exiting Recipe Box. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select from 1 to 4.");
            }
        }

    }
}
