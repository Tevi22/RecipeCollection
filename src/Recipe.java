import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {
    // Class variable to store the recipe name
    private String recipeName;

    // Variable to store how many servings the recipe makes
    private int servings = 0;

    // ArrayList to hold the list of ingredient names
    private ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient>();

    // Variable to hold the total calories for the recipe
    private double totalRecipeCalories = 0.0;

    /**
     * Getter and setter methods for each class attribute.
     */

    // Setter method for recipeName
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    // Getter method for recipeName
    public String getRecipeName() {
        return recipeName;
    }

    // Setter method for servings
    public void setServings(int servings) {
        this.servings = servings;
    }

    // Getter method for servings
    public int getServings() {
        return servings;
    }

    // Setter method for recipeIngredient
    public void setRecipeIngredients(ArrayList<Ingredient> ingredients) {
        this.recipeIngredients = ingredients;
    }

    // Getter method for recipeIngredients
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    // Setter method for totalRecipeCalories
    public void setTotalRecipeCalories(double TotalCalories) {
        totalRecipeCalories = TotalCalories;
    }

    // Getter method for totalRecipeCalories
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    // Default constructor initializes with default values
    public Recipe() {
        this.recipeName = "";
        this.servings = 0; // <--- assignment value with appropriate data type
        this.recipeIngredients = new ArrayList<Ingredient>(); // <-- assignment value for empty ArrayList
        this.totalRecipeCalories = 0;

    }

    // Overloaded constructor to initialize all attributes at once
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients,
            double totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
    }

    // Pseudocode for custom method: scaleRecipe(double scaleFactor)
    /*
     * Method: scaleRecipe
     * Input: scaleFactor (e.g., 2.0 to double the recipe, 0.5 to halve it)
     * Steps:
     * 1. Loop through each ingredient in recipeIngredients.
     * 2. Multiply each ingredient's amount by the scaleFactor.
     * 3. Adjust totalRecipeCalories accordingly.
     * 4. Optionally update servings to reflect scaled size.
     */

    public void scaleRecipe(double scaleFactor) {
        // Check if scaleFactor is valid
        if (scaleFactor <= 0) {
            System.out.println("Scale factor must be greater than 0.");
            return;
        }
        // Scale the servings

        this.servings = (int) Math.round(this.servings * scaleFactor);

        // Scale each ingredient's amount and update total calories
        for (Ingredient ingredient : recipeIngredients) {
            // Scale the amount of each ingredient
            ingredient.setAmount(ingredient.getIngredientAmount() * (float) scaleFactor);
            // Update total calories for the recipe
            this.totalRecipeCalories += ingredient.getCaloriesPerUnit() * ingredient.getIngredientAmount();
        }
        // Print confirmation of scaling
        System.out.println("Recipe scaled by a factor of " + scaleFactor + ".");
        System.out.println("New servings: " + this.servings);
        System.out.println("Total recipe calories: " + this.totalRecipeCalories);
    }

    /**
     * Prompts the user for input to create a new recipe, including the name,
     * number of servings, and a list of ingredients. It constructs Ingredient
     * objects for each input and calculates the total recipe calories.
     * 
     * This method uses input validation to ensure correct data types are entered.
     * It stores the result in the instance variables: recipeName, servings,
     * recipeIngredients, and totalRecipeCalories.
     */
    public void createNewRecipe() {
        Scanner scrn = new Scanner(System.in);

        // Prompt for recipe name
        System.out.print("Enter the name of the recipe: ");
        String inputName = scrn.nextLine();
        while (inputName.isEmpty()) {
            System.out.print("Recipe name cannot be blank. Please enter a valid name: ");
            inputName = scrn.nextLine();
        }
        this.recipeName = inputName;

        // Prompt for number of servings
        System.out.print("Enter the number of servings: ");
        // Checks that input is a integer
        while (!scrn.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scrn.next();
        }
        int inputServings = scrn.nextInt();
        // Checks that number of serving are greater than 0 and prompt users to enter
        // integer again
        while (inputServings <= 0) {
            System.out.print("Number of servings must be greater than 0. Try again: ");
            while (!scrn.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scrn.next();
            }
            inputServings = scrn.nextInt();
        }
        this.servings = inputServings;
        scrn.nextLine(); // Consume newline

        // Define minimum and maximum allowed number of ingredients
        final int MIN_INGREDIENTS = 1;
        final int MAX_INGREDIENTS = 50;

        // Prompt for number of ingredients
        System.out.print("Enter the number of ingredients (Must be between: " + MIN_INGREDIENTS + " and "
                + MAX_INGREDIENTS + "): ");
        int numIngredients = 0;

        // Validate input is an integer and greater than 0
        while (true) {
            if (scrn.hasNextInt()) {
                numIngredients = scrn.nextInt();
                scrn.nextLine(); // Consume newline
                if (numIngredients >= MIN_INGREDIENTS && numIngredients < MAX_INGREDIENTS) {
                    break; // Valid input
                } else {
                    System.out.print("Number of ingredients must be greater than " + MIN_INGREDIENTS + " and less than "
                            + MAX_INGREDIENTS + " Try again: ");
                }
            } else {
                System.out.print("Invalid input. Please enter a whole number: ");
                scrn.next(); // Clear invalid input
            }

        }

        // Initialize ingredient list and total calories
        ArrayList<Ingredient> ingredientsList = new ArrayList<>();
        double totalCalories = 0;

        // Collect each ingredient
        for (int i = 1; i <= numIngredients; i++) {
            System.out.println("Enter details for ingredient #" + i + ":");

            // Gather input for a new Ingredient
            System.out.print("Ingredient name: ");
            String name = scrn.nextLine();
            // Checks that ingredient name is not blank
            while (name.isEmpty()) {
                System.out.print("Ingredient name cannot be blank. Try again: ");
                name = scrn.nextLine();
            }

            // Gather input for amount of new Ingredient
            System.out.print("Amount: ");
            while (!scrn.hasNextFloat()) {
                System.out.print("Invalid input. Please enter a number: ");
                scrn.next();
            }
            float amount = scrn.nextFloat();

            // Checks that amount entered is greater than 0 and prompt users to enter float
            // again
            while (amount <= 0) {
                System.out.print("Amount must be greater than 0 Try again: ");
                while (!scrn.hasNextFloat()) {
                    System.out.print("Invalid input. Please enter a number: ");
                    scrn.next();
                }
                amount = scrn.nextFloat();
            }
            scrn.nextLine(); // Consume newline

            // Gather unit of measurement for amount of new Ingredient
            System.out.print("Unit of measurement (e.g., cups, tsp): ");
            String unit = scrn.nextLine();
            // Check to make sure unit of measurement is not empty
            while (unit.isEmpty()) {
                System.out.print("Unit of measurement cannot be blank. Try again: ");
                unit = scrn.nextLine();
            }

            // Gather calorie count for the unit of new Ingredient
            System.out.print("Please enter calories per " + unit + ": ");

            // Checks that valid interger is entered
            while (!scrn.hasNextInt()) {
                System.out.print("Invalid input. Please enter a whole number: ");
                scrn.next();
            }
            int calPerUnit = scrn.nextInt();

            // Check that calories entered is not negative
            while (calPerUnit < 0) {
                System.out.print("Calories cannot be negative. Try again: ");
                while (!scrn.hasNextInt()) {
                    System.out.print("Invalid input. Please enter a whole number: ");
                    scrn.next();
                }
                calPerUnit = scrn.nextInt();
            }
            scrn.nextLine(); // Consume newline

            // Calculate total calories for this ingredient
            float ingredientTotalCalories = amount * calPerUnit;

            // Create new Ingredient object
            Ingredient ingredient = new Ingredient(name, amount, unit, calPerUnit);

            // Add to list and update total recipe calories
            ingredientsList.add(ingredient);
            totalCalories += ingredientTotalCalories;
        }

        // Set the instance variables
        this.recipeIngredients = ingredientsList;
        this.totalRecipeCalories = totalCalories;

        System.out.println("Recipe created successfully!");
        System.out.println("");

        //Close the scanner
        scrn.close();
    }

    // Method to print the recipe details
    public void printRecipe() {
        int singleServingCalories = (servings != 0) ? (int) (totalRecipeCalories / servings) : 0;

        // Print recipe name and servings
        System.out.println("Recipe: " + recipeName);
        System.out.println("Serves: " + servings);
        System.out.println("Ingredients:");

        // Initialize a counter starting from 1 to display human-friendly numbering
        int count = 1;
        // Loop through each ingredient in the list and print it
        for (int i = 0; i < recipeIngredients.size(); i++) {

            // Print the ingredient with a user-friendly number instead of 0-based index
            System.out.println(count + ": " + recipeIngredients.get(i));

            // Increment the counter for the next ingredient
            count++;
        }

        // Print calories per serving
        System.out.println("Each serving has " + singleServingCalories + " Calories");
        System.out.println("");
    }

}
