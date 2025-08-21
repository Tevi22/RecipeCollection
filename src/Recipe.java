import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a recipe that contains a name, number of servings,
 * and a list of ingredients.
 * Provides methods to add ingredients, calculate total calories,
 * and print the recipe details.
 */

public class Recipe {

    /** The name of the recipe. */
    private String recipeName;

    /** The number of servings this recipe makes. */
    private int servings = 0;

    /** The list of ingredients in the recipe. */
    private ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient>();

    /** The steps to prepare the recipe. */
    private ArrayList<String> recipeSteps = new ArrayList<>();

    /** The tags associated with the recipe, such as "vegan", "gluten-free", etc. */
    private ArrayList<String> recipeTags = new ArrayList<>();

    /** The variable to hold the total calories for the recipe */
    private double totalRecipeCalories = 0.0;

    /**
     * Getter and setter methods for each class attribute.
     */

    /**
     * Sets the name of the recipe.
     *
     * @param recipeName the new name of the recipe
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * Gets the name of the recipe.
     *
     * @return the recipe name
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Sets the number of servings for this recipe.
     *
     * @param servings the new number of servings
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * Gets the number of servings for this recipe.
     *
     * @return the number of servings
     */
    public int getServings() {
        return servings;
    }

    /**
     * Sets the list of ingredients for this recipe.
     *
     * @param ingredients the new list of ingredients
     */
    public void setRecipeIngredients(ArrayList<Ingredient> ingredients) {
        this.recipeIngredients = ingredients;
    }

    // Getter method for recipeIngredients
    /**
     * Gets the list of ingredients for this recipe.
     *
     * @return the list of ingredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * Sets the steps for preparing this recipe.
     *
     * @param steps the new steps for the recipe
     */
    // Setter method for recipeSteps
    public void setRecipeSteps(ArrayList<String> steps) {
        this.recipeSteps = steps;
    }

    /**
     * Gets the steps for preparing this recipe.
     *
     * @return the list of steps
     */
    // Getter method for recipeSteps
    public ArrayList<String> getRecipeSteps() {
        return recipeSteps;
    }

    /**
     * Sets the tags for this recipe.
     *
     * @param tags the new tags for the recipe
     */
    // Getter method for recipeTags
    public void setRecipeTags(ArrayList<String> tags) {
        this.recipeTags = tags;
    }

    /**
     * Gets the tags for this recipe.
     *
     * @return the list of tags
     */
    // Getter method for recipeTags
    public ArrayList<String> getRecipeTags() {
        return recipeTags;
    }

    // Setter method for totalRecipeCalories
    /**
     * Sets the total calories for this recipe.
     *
     * @param TotalCalories the new total calories for the recipe
     */
    // Setter method for totalRecipeCalories
    public void setTotalRecipeCalories(double TotalCalories) {
        totalRecipeCalories = TotalCalories;
    }

    // Getter method for totalRecipeCalories
    /**
     * Gets the total calories for this recipe.
     *
     * @return the total calories for the recipe
     */
    // Getter method for totalRecipeCalories
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    /**
     * Default constructor that creates an empty recipe with no name or ingredients.
     */
    public Recipe() {
        this.recipeName = "";
        this.servings = 0; // <--- assignment value with appropriate data type
        this.recipeIngredients = new ArrayList<Ingredient>(); // <-- assignment value for empty ArrayList
        this.recipeSteps = new ArrayList<String>();
        this.recipeTags = new ArrayList<String>();
        this.totalRecipeCalories = 0;

    }

    /**
     * Parameterized constructor that creates a recipe with the given name and
     * servings.
     *
     * @param recipeName          the name of the recipe
     * @param servings            the number of servings this recipe makes
     * @param recipeIngredients   the list of ingredients in the recipe
     * @param totalRecipeCalories the total calories for the recipe
     */
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients,
            double totalRecipeCalories, ArrayList<String> recipeSteps, ArrayList<String> recipeTags) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
        this.recipeSteps = recipeSteps;
        this.recipeTags = recipeTags;
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

    // Method to scale the recipe by a given factor
    /**
     * Scales the recipe by a given factor, adjusting the ingredient amounts and
     * total calories accordingly.
     * 
     * @param scaleFactor the factor by which to scale the recipe
     */
    public void scaleRecipe(double scaleFactor) {
        // Check if scaleFactor is valid
        if (scaleFactor <= 0) {
            System.out.println("Scale factor must be greater than 0.");
            return;
        }

        // Scale the servings
        this.servings = (int) Math.round(this.servings * scaleFactor);

        // Reset total calories for the scaled recipe
        this.totalRecipeCalories = 0.0;

        // Print confirmation of scaling
        System.out.println("Recipe scaled by a factor of " + scaleFactor + ".");
        System.out.println("");
        System.out.println("Recipe:" + this.recipeName);
        System.out.println("New servings: " + this.servings);

        // Scale each ingredient's amount and update total calories
        int count = 1;
        System.out.println("Number of ingredients: " + recipeIngredients.size());

        // Loop through each ingredient in the recipe
        for (Ingredient ingredient : recipeIngredients) {
            // Scale the amount of each ingredient
            float newAmount = ingredient.getIngredientAmount() * (float) scaleFactor;
            ingredient.setAmount(newAmount);

            // Calculate calories for this ingredient after scaling
            double ingredientCalories = newAmount * ingredient.getCaloriesPerUnit();

            // Add to total recipe calories
            this.totalRecipeCalories += ingredientCalories;

            // Print the scaled ingredient details
            System.out.println(count + ": " + ingredient.getIngredientName() +
                    " scaled to " + newAmount + " " + ingredient.getUnitMeasurement());

            // Increment the counter for the next ingredient
            count++;
        }

        // Print the total calories for the scaled recipe
        System.out.println("Total recipe calories: " + this.totalRecipeCalories);
        System.out.println();

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

        // Checks that recipe name is not blank
        while (inputName.isEmpty()) {
            System.out.print("Recipe name cannot be blank. Please enter a valid name: ");
            inputName = scrn.nextLine();
        }

        // Set the recipe name
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

        // Set the number of servings
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

            // Check if the next input is an integer
            if (scrn.hasNextInt()) {
                numIngredients = scrn.nextInt();
                scrn.nextLine(); // Consume newline

                // Check if the number of ingredients is within the valid range
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

            // Read the amount as a float
            float amount = scrn.nextFloat();

            // Checks that amount entered is greater than 0 and prompt users to enter float
            // again
            while (amount <= 0) {
                System.out.print("Amount must be greater than 0 Try again: ");
                while (!scrn.hasNextFloat()) {
                    System.out.print("Invalid input. Please enter a number: ");
                    scrn.next();
                }

                // Read the amount again
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

        // Prompt for recipe steps
        System.out.println("Enter the steps to prepare the recipe (type 'done' when finished):");
        ArrayList<String> stepsList = new ArrayList<>();
        while (true) {
            String step = scrn.nextLine();
            if (step.equalsIgnoreCase("done")) {
                break; // Exit loop when user types 'done'
            }
            // Add the step to the list
            stepsList.add(step);
        }
        // Set the recipe steps
        this.recipeSteps = stepsList;

        //Prompt for recipe tags
        System.out.println("Enter tags for the recipe (comma-separated, e.g., vegan, gluten-free):");
        String tagsInput = scrn.nextLine();
        // Split the input by commas and trim whitespace
        String[] tagsArray = tagsInput.split(",");
        ArrayList<String> tagsList = new ArrayList<>();
        for (String tag : tagsArray) {
            // Trim whitespace and add to the list if not empty
            String trimmedTag = tag.trim();
            if (!trimmedTag.isEmpty()) {
                tagsList.add(trimmedTag);
            }
        }
        // Set the recipe tags
        this.recipeTags = tagsList;


        System.out.println("Recipe created successfully!");
        System.out.println("");

    }

    // Method to print the recipe details
    /**
     * Prints the recipe name, number of servings, ingredients, and calories per
     * serving.
     */
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

        // Print recipe steps if available
        if (!recipeSteps.isEmpty()) {
            System.out.println("Steps to prepare:");
            for (int i = 0; i < recipeSteps.size(); i++) {
                System.out.println((i + 1) + ": " + recipeSteps.get(i));
            }
        } else {
            System.out.println("No preparation steps provided.");
        }

        // Print recipe tags if available
        if (!recipeTags.isEmpty()) {
            System.out.println("Tags: " + String.join(", ", recipeTags));
        } else {
            System.out.println("No tags provided.");
        }

        // Print calories per serving
        System.out.println("Each serving has " + singleServingCalories + " Calories");
        System.out.println("");
    }

}
