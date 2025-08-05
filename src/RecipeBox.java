import java.util.ArrayList;

public class RecipeBox {

    private ArrayList<Recipe> listOfRecipes;

    //Accessor method to get the list of recipes
    public ArrayList<Recipe> getListOfRecipes() {
		return listOfRecipes;
	}

    // Mutator method to set the list of recipes
	public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	}

    // Constructor to initialize the list of recipes
    public RecipeBox() {    
        this.listOfRecipes = new ArrayList<Recipe>();
    }


    // This method prints the details of a recipe based on its name
	public void printAllRecipeDetails(String recipeName) {
		for (Recipe recipe : listOfRecipes) {
			if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
				recipe.printRecipe();
				return;
			}
		}
		System.out.println("Recipe not found.");
	}

    // This method prints the names of all recipes in the list
	public void printAllRecipeNames() {
		if (listOfRecipes.isEmpty()) {
			System.out.println("No recipes available.");
			return;
		}
		for (int i = 0; i < listOfRecipes.size(); i++) {
			System.out.println((i + 1) + ": " + listOfRecipes.get(i).getRecipeName());
		}
	}

    // This method adds a new recipe to the listOfRecipes ArrayList
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
