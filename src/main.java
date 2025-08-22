import java.util.ArrayList;
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
            System.out.println("2. Add steps to a recipe");
            System.out.println("3. Add tags to a recipe");
            System.out.println("4. Remove steps from a recipe");
            System.out.println("5. Remove tags from a recipe");
            System.out.println("6. List all recipe names");
            System.out.println("7. View a recipe");
            System.out.println("8. Seach recipes by tag");
            System.out.println("9. Scale a recipe"); // Custom method to scale recipe ingredients
            System.out.println("10. Quit");
            System.out.print("Enter choice: ");

            // Read user input for menu choice
            // It expects an integer input corresponding to the menu options
            int choice;

            // Validate input is an integer and within the range of menu options
            while (!scnr.hasNextInt()) {
                System.out.print("Invalid input. Enter a number between 1 and 8: ");
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
                    // Add steps to a recipe using the addSteps() method from Recipe class
                    System.out.print("Enter the name of the recipe to add steps to: ");
                    String recipeToAddSteps = scnr.nextLine();
                    System.out.print("Enter steps (comma-separated): ");
                    String stepsInput = scnr.nextLine();
                    String[] stepsArray = stepsInput.split(",");
                    ArrayList<String> stepsList = new ArrayList<>();
                    for (String step : stepsArray) {
                        stepsList.add(step.trim());
                    }
                    myRecipeBox.addStepsToRecipe(recipeToAddSteps, stepsList);
                    break;

                case 3:
                    // Add tags to a recipe using the addTags() method from Recipe class
                    System.out.print("Enter the name of the recipe to add tags to: ");
                    String recipeToAddTags = scnr.nextLine();
                    System.out.print("Enter tags (comma-separated): ");
                    String tagsInput = scnr.nextLine();
                    String[] tagsArray = tagsInput.split(",");
                    ArrayList<String> tagsList = new ArrayList<>();
                    for (String tag : tagsArray) {
                        tagsList.add(tag.trim());
                    }
                    myRecipeBox.addTagsToRecipe(recipeToAddTags, tagsList);
                    break;

                case 4:
                    // Remove steps from a recipe using the removeSteps() method from Recipe class
                    System.out.print("Enter the name of the recipe to remove steps from: ");
                    String recipeToRemoveSteps = scnr.nextLine();
                    System.out.print("Enter the step to remove: ");
                    String stepToRemove = scnr.nextLine();
                    ArrayList<String> stepsToRemove = new ArrayList<>();
                    stepsToRemove.add(stepToRemove);
                    myRecipeBox.removeStepsFromRecipe(recipeToRemoveSteps, stepsToRemove);
                    break;

                case 5:
                    // Remove tags from a recipe using the removeTags() method from Recipe class
                    System.out.print("Enter the name of the recipe to remove tags from: ");
                    String recipeToRemoveTags = scnr.nextLine();
                    System.out.print("Enter the tag to remove: ");
                    String tagToRemove = scnr.nextLine();
                    ArrayList<String> tagsToRemove = new ArrayList<>();
                    tagsToRemove.add(tagToRemove);
                    myRecipeBox.removeTagsFromRecipe(recipeToRemoveTags, tagsToRemove);
                    break;

                case 6:
                    // Print all recipe names using the printAllRecipeNames() method from RecipeBox
                    // class
                    myRecipeBox.printAllRecipeNames();
                    break;

                case 7:
                    // Print details of a specific recipe using the printAllRecipeDetails() method
                    // from RecipeBox class
                    System.out.print("Enter the name of the recipe to view: ");
                    String selectedRecipeName = scnr.nextLine();
                    myRecipeBox.printAllRecipeDetails(selectedRecipeName);
                    break;

                case 8:
                    // Search recipes by tag using the searchByTag() method from RecipeBox class
                    System.out.print("Enter the tag to search for: ");
                    String tagToSearch = scnr.nextLine();   
                    myRecipeBox.searchRecipesByTag(tagToSearch);
                    break;

                case 9:
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

                case 10:
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
