package foodfindder.jacob.food_finder.Recipe;

import java.util.Map;

import foodfindder.jacob.food_finder.Ingredient;

/**
 * Created by jacob on 7/10/18.
 */

public class Recipe {
    private Map<Ingredient, String> instructions;
    private String name;
    private String id;
    private int time;
    private String category;

    public Recipe(String name, String id, String category) {
        this.name = name;
        this.id = id;
        this.category = category;
    }

    public Map<Ingredient, String> getInstructions() {
        return instructions;
    }

    public void setInstructions(Map<Ingredient, String> instructions) {
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
