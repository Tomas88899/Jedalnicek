package Utilities;


/**
 * Class represents each recepie consist of name, num of calories and recepie
 */
public class FoodRecipe
{
    private String foodName;
    private int calories;
    private String recipe;


    /**
     * creating new object of recepie
     * @param foodName name of recipe
     * @param calories number of kalories
     * @param recipe  steb by step cooking instruction
     */
    public FoodRecipe(String foodName, int calories, String recipe)
    {
        this.foodName = foodName;
        this.calories = calories;
        this.recipe = recipe;
    }


    /**
     * return name of recipe
     * @return name of recipe
     */
    public String getFoodName()
    {
        return foodName;
    }
    /**
     * return how many calories are in the this meal
     * @return how many calories are in the this meal
     */
    public int getCalories()
    {
        return calories;
    }

    /**
     * return steb by step cooking instruction
     * @return steb by step cooking instruction
     */
    public String getRecipe()
    {
        return recipe;
    }

    @Override
    public String toString() {
        return foodName + " " + calories;
    }
}
