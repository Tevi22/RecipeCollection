/**
 * The Ingredient class represents a single ingredient used in a recipe.
 * It stores information such as the name, amount, unit of measurement,
 * and calories per unit. It also provides a method to calculate the total
 * calories based on the amount and calories per unit.
 */

public class Ingredient {
    // String is used for ingredient name and unit, which are textual values
    String nameOfIngredient = "";
    String unitMeasurement = "";

    // float for decimal values such as 1.5 cups
    float ingredientAmount = 0.00f;

    // int is used since calories per unit are whole numbers
    int numberCaloriesPerUnit = 0;

    // float to store the result of amount * calories per unit
    float totalCalories = 0.00f;

    /*
     * Default constructor initializes with default values
     * * @param ingredientName the name of the ingredient
     * 
     * @param ingredientAmount the amount of the ingredient
     * 
     * @param unitMeasurement the unit of measurement (e.g., cups, tsp)
     * 
     * @param caloriesPerUnit the number of calories per unit
     */
    public Ingredient() {
        this.nameOfIngredient = "";
        this.ingredientAmount = 0;
        this.unitMeasurement = "";
        this.numberCaloriesPerUnit = 0;
    }

    /**
     * Constructs a new Ingredient with the given properties.
     * 
     * @param ingredientName   the name of the ingredient
     * @param ingredientAmount the amount of the ingredient
     * @param unitMeasurement  the unit of measurement (e.g., cups, tsp)
     * @param caloriesPerUnit  the number of calories per unit
     */
    public Ingredient(String nameOfIngredient, float ingredientAmount, String unitMeasurement,
            int numberCaloriesPerUnit) {
        this.nameOfIngredient = nameOfIngredient;
        this.ingredientAmount = ingredientAmount;
        this.unitMeasurement = unitMeasurement;
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
    }

    // Getters (Accessors)

    /**
     * Gets the name of the ingredient.
     * 
     * @return the ingredient name
     */
    public String getIngredientName() {
        return nameOfIngredient;
    }

    /**
     * Gets the amount of the ingredient.
     * 
     * @return the ingredient amount
     */
    public float getIngredientAmount() {
        return ingredientAmount;
    }

    public void setAmount(float ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }
    /**
     * Gets the unit of measurement.
     * 
     * @return the unit of measurement (e.g., "cups")
     */
    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    /**
     * Gets the number of calories per unit.
     * 
     * @return the calories per unit
     */
    public int getCaloriesPerUnit() {
        return numberCaloriesPerUnit;
    }

    public void setCaloriesPerUnit(int numberCaloriesPerUnit) {
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
    }

    /**
     * Calculates and returns the total calories of the ingredient.
     * 
     * @return the total calories (amount * calories per unit)
     */
    public float getTotalCalories() {
        return ingredientAmount * numberCaloriesPerUnit;
    }

    /**
     * Returns a formatted string representing the ingredient.
     * 
     * @return a string in the format "{amount} {unit} of {name} ({total calories}
     *         cal)"
     */
    @Override
    public String toString() {
        return ingredientAmount + " " + unitMeasurement + " of " + nameOfIngredient + " (" + getTotalCalories()
                + " cal)";
    }
}
