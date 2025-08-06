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
            System.out.println("4. Scale a recipe"); //Custom method to scale recipe ingredients
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");

            int choice;
            while (!scnr.hasNextInt()) {
                System.out.print("Invalid input. Enter a number between 1 and 4: ");
                scnr.next();
            }
            choice = scnr.nextInt();
            scnr.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Create new recipe using the createNewRecipe() method from Recipe class
                    myRecipeBox.addNewRecipe();
                    break;

                case 2:
                    // Print all recipe names using the printAllRecipeNames() method from RecipeBox class
                    myRecipeBox.printAllRecipeNames();
                    break;

                case 3:
                    // Print details of a specific recipe using the printAllRecipeDetails() method from RecipeBox class
                    System.out.print("Enter the name of the recipe to view: ");
                    String selectedRecipeName = scnr.nextLine();
                    myRecipeBox.printAllRecipeDetails(selectedRecipeName);
                    break;

                case 4:
                    // Show all recipes so the user can choose
                    System.out.println("Select a recipe to scale:");
                    for (int i = 0; i < listOfRecipes.size(); i++) {
                        System.out.println((i + 1) + ". " + listOfRecipes.get(i).getRecipeName());
                    }

                    // Get user's choice
                    int recipeIndex = -1;
                    while (recipeIndex < 1 || recipeIndex > listOfRecipes.size()) {
                        System.out.print("Enter recipe number: ");
                            if (scnr.hasNextInt()) {
                            recipeIndex = scnr.nextInt();
                        } else {
                        System.out.println("Invalid input. Please enter a number.");
                        scnr.next(); // clear invalid input
                        }
                    }

                    // Ask for scale factor
                    double scaleFactor = 0;
                    while (scaleFactor <= 0) {
                        System.out.print("Enter scale factor (e.g., 2.0 for double, 0.5 for half): ");
                        if (scnr.hasNextDouble()) {
                            scaleFactor = scnr.nextDouble();
                            if (scaleFactor <= 0) {
                                System.out.println("Scale factor must be greater than zero.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scnr.next(); // clear invalid input
                        }
                    }

                    // Scale the selected recipe
                    listOfRecipes.get(recipeIndex - 1).scaleRecipe(scaleFactor);
                    break;

                case 5:
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
