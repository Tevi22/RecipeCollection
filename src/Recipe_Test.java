import java.util.ArrayList;

/**
 * This class tests the Recipe class by:
 * - Creating a hardcoded recipe using the parameterized constructor.
 * - Allowing the user to create a recipe through console input.
 * - Displaying the recipes using the printRecipe() method.
 */
public class Recipe_Test {

    /**
     * Main method to test Recipe creation and display.
     * Demonstrates both hardcoded and user-input-based recipe generation.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Testing started");

        // Create a hardcoded ingredient list
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("Flour", 2.0f, "cups", 110));
        ingredients.add(new Ingredient("Eggs", 2.0f, "units", 70));

        // Create a Recipe with hardcoded data
        Recipe testRecipe = new Recipe("Pancakes", 4, ingredients, 360);

        // Assertion tests
        assert testRecipe.getRecipeName().equals("Pancakes") : "Recipe name is incorrect";
        assert testRecipe.getServings() == 4 : "Serving count should be 4";
        assert testRecipe.getTotalRecipeCalories() == 360 : "Total calories should be 360";

        // Check ingredients list
        ArrayList<Ingredient> ing = testRecipe.getRecipeIngredients();
        assert ing.size() == 2 : "There should be 2 ingredients";
        assert ing.get(0).getIngredientName().equals("Flour") : "First ingredient should be Flour";
        assert ing.get(0).getCaloriesPerUnit() == 110 : "Flour should have 110 calories";
        assert ing.get(1).getIngredientName().equals("Eggs") : "Second ingredient should be Eggs";
        assert ing.get(1).getCaloriesPerUnit() == 70 : "Eggs should have 70 calories";

        //Check Scaling
        testRecipe.scaleRecipe(0.5f);
        assert testRecipe.getServings() == 2 : "Serving count should be 2 after scaling";
        assert testRecipe.getTotalRecipeCalories() == 180 : "Total calories should be 180 after scaling";
        ing = testRecipe.getRecipeIngredients();
        assert ing.get(0).getIngredientAmount() == 1.0f : "Flour amount should be 1.0 after scaling";
        assert ing.get(1).getIngredientAmount() == 1.0f : "Eggs amount should be 1.0 after scaling";

        // Print for manual inspection
        testRecipe.printRecipe();


        // Instantiate empty Recipe and fill via user input
        System.out.println("Please enter a new recipe below:");
        Recipe userRecipe = new Recipe();
        userRecipe.createNewRecipe();
        userRecipe.printRecipe();

        // Assertion tests
        assert !userRecipe.getRecipeName().isEmpty() : "Recipe name should not be empty";
        assert userRecipe.getServings() > 0 : "Servings should be greater than 0";

        System.out.println("All assertions passed.\n");
    }
}
