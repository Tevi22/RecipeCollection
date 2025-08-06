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
