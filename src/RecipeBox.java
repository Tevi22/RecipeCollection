import java.util.ArrayList;

/**
 * RecipeBox class manages a collection of recipes.
 * It allows adding new recipes, printing recipe details, scaling recipes, and listing all recipe names.
 */

public class RecipeBox {

	/** ArrayList to hold the recipes */
    private ArrayList<Recipe> listOfRecipes;

    /**
	 * Gets the list of recipes.
	 * 
	 * @return the list of recipes
	 */
    public ArrayList<Recipe> getListOfRecipes() {
		return listOfRecipes;
	}

	/**
	 * Sets the list of recipes.
	 * 
	 * @param listOfRecipes the new list of recipes
	 */
	public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	}

    /**
	 * Constructor initializes the listOfRecipes ArrayList.
	 */
    public RecipeBox() {    
        this.listOfRecipes = new ArrayList<Recipe>();
    }

	/**
	 * Prints the details of a specific recipe by its name.
	 * 
	 * @param recipeName the name of the recipe to print
	 */
	public void printAllRecipeDetails(String recipeName) {
		for (Recipe recipe : listOfRecipes) {
			if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
				recipe.printRecipe();
				return;
			}
		}
		System.out.println("Recipe not found.");
	}


	/**
	 * Prints the names of all recipes in the recipe box.
	 */
	public void printAllRecipeNames() {
		if (listOfRecipes.isEmpty()) {
			System.out.println("No recipes available.");
			return;
		}
		for (int i = 0; i < listOfRecipes.size(); i++) {
			System.out.println((i + 1) + ": " + listOfRecipes.get(i).getRecipeName());
		}
	}

	/**
	 * Adds a new recipe to the recipe box.
	 * It prompts the user to create a new recipe and adds it to the list if valid.
	 */
	public void addNewRecipe() {
		Recipe newRecipe = new Recipe();
		newRecipe.createNewRecipe();
		if (newRecipe.getRecipeName() != null && !newRecipe.getRecipeName().isEmpty()) {
			listOfRecipes.add(newRecipe);
			System.out.println("Recipe added: " + newRecipe.getRecipeName());
		} else {
			System.out.println("Invalid recipe.");
		}
	}
}
