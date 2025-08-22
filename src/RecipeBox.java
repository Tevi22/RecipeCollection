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


	//Add steps to a recipe
	/**
	 * Adds steps to an existing recipe by its name.
	 * 
	 * @param recipeName the name of the recipe to add steps to
	 * @param steps      the list of steps to add
	 */
	public void addStepsToRecipe(String recipeName, ArrayList<String> steps) {
		for (Recipe recipe : listOfRecipes) {
			if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
				recipe.setRecipeSteps(steps);
				System.out.println("Steps added to recipe: " + recipeName);
				return;
			}
		}
		System.out.println("Recipe not found.");
	}

	//Add tags to a recipe
	/**
	 * Adds tags to an existing recipe by its name.
	 * 
	 * @param recipeName the name of the recipe to add tags to
	 * @param tags       the list of tags to add
	 */
	public void addTagsToRecipe(String recipeName, ArrayList<String> tags) {
		for (Recipe recipe : listOfRecipes) {
			if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
				recipe.setRecipeTags(tags);
				System.out.println("Tags added to recipe: " + recipeName);
				return;
			}
		}	
		System.out.println("Recipe not found.");
	}

	//Remove a recipe step
	/**
	 * Removes a specific step from a recipe by its name.
	 * 
	 * @param recipeName the name of the recipe to remove a step from
	 * @param step       the step to remove
	 */	
	public void removeStepFromRecipe(String recipeName, String step) {
		for (Recipe recipe : listOfRecipes) {
			if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
				ArrayList<String> steps = recipe.getRecipeSteps();
				if (steps.remove(step)) {
					System.out.println("Step removed from recipe: " + recipeName);
				} else {
					System.out.println("Step not found in recipe: " + recipeName);
				}
				return;
			}
		}
		System.out.println("Recipe not found.");
	}

	//Remove a recipe tag
	/**	 * Removes a specific tag from a recipe by its name.
	 * 
	 * @param recipeName the name of the recipe to remove a tag from
	 * @param tag        the tag to remove
	 */
	public void removeTagFromRecipe(String recipeName, String tag) {
		for (Recipe recipe : listOfRecipes) {
			if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
				ArrayList<String> tags = recipe.getRecipeTags();
				if (tags.remove(tag)) {
					System.out.println("Tag removed from recipe: " + recipeName);
				} else {
					System.out.println("Tag not found in recipe: " + recipeName);
				}
				return;
			}
		}			
		System.out.println("Recipe not found.");
	}

	//Seach by tag
	/**
	 * Searches for recipes by a specific tag.
	 * 
	 * @param tag the tag to search for
	 */
	public void searchRecipesByTag(String tag) {
		boolean found = false;
		for (Recipe recipe : listOfRecipes) {
			if (recipe.getRecipeTags().contains(tag)) {
				System.out.println("Found recipe with tag '" + tag + "': " + recipe.getRecipeName());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No recipes found with tag: " + tag);
		}
	}

	//Remove steps from a recipe
	/**
	 * Removes multiple steps from a recipe by its name.
	 * 
	 * @param recipeName the name of the recipe to remove steps from
	 * @param steps      the list of steps to remove
	 */
	public void removeStepsFromRecipe(String recipeName, ArrayList<String> steps) {
		for (Recipe recipe : listOfRecipes) {
			if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
				ArrayList<String> currentSteps = recipe.getRecipeSteps();
				boolean anyRemoved = false;
				for (String step : steps) {
					if (currentSteps.remove(step)) {
						anyRemoved = true;
					}
				}
				if (anyRemoved) {
					System.out.println("Steps removed from recipe: " + recipeName);
				} else {
					System.out.println("No matching steps found in recipe: " + recipeName);
				}
				return;
			}
		}
		System.out.println("Recipe not found.");
	}

	//Remove tags from a recipe
	/**
	 * Removes multiple tags from a recipe by its name.
	 * 
	 * @param recipeName the name of the recipe to remove tags from
	 * @param tags       the list of tags to remove
	 */
	public void removeTagsFromRecipe(String recipeName, ArrayList<String> tags) {
		for (Recipe recipe : listOfRecipes) {
			if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
				ArrayList<String> currentTags = recipe.getRecipeTags();
				boolean anyRemoved = false;
				for (String tag : tags) {
					if (currentTags.remove(tag)) {
						anyRemoved = true;
					}
				}
				if (anyRemoved) {
					System.out.println("Tags removed from recipe: " + recipeName);
				} else {
					System.out.println("No matching tags found in recipe: " + recipeName);
				}
				return;
			}
		}	
		System.out.println("Recipe not found.");
	}

	//Search for recipes by calorie range
	/**
	 * Search recipes by calorie range.
	 * 
	 * @param minCalorieRange the minimum calorie range
	 * @param maxCalorieRange the maximum calorie range
	 */
	public void searchRecipesByCalorieRange(double minCalorieRange, double maxCalorieRange) {
		boolean found = false;
		for (Recipe recipe : listOfRecipes) {
			if (recipe.getTotalRecipeCalories() >= minCalorieRange && recipe.getTotalRecipeCalories() <= maxCalorieRange) {
				System.out.println("Found recipe in calorie range: " + recipe.getRecipeName());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No recipes found in the specified calorie range.");
		}
	}

}
