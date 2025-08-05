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


    
}
