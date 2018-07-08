package foodfindder.jacob.food_finder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 6/27/18.
 */

public class IngredientsList {
    List<Ingredient> ingredientList;

    public IngredientsList(){
        ingredientList = new ArrayList<>();
    }

    public IngredientsList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public void add(Ingredient ingredient){
        ingredientList.add(ingredient);
    }

    public Ingredient get(int index){
        return ingredientList.get(index);
    }

    public Ingredient remove(int index){
        Ingredient ingredient = ingredientList.remove(index);
        return ingredient;
    }

    //only to be called when you want to parse meal db api data from ingredients collect
    public void readLine(String data)
    {
        JsonParser jsonParser = new JsonParser();
        JsonObject objectFromString = jsonParser.parse(data).getAsJsonObject();
        JsonArray arr = objectFromString.getAsJsonArray("meals");
        for(int i = 0; i < arr.size(); i++)
        {
            JsonObject temp = arr.get(i).getAsJsonObject();
            String id = temp.get("idIngredient").toString();
            String name = temp.get("strIngredient").toString();
            String description = temp.get("strDescription").toString();
            String type = temp.get("strType").toString();
            Ingredient ingredient = new Ingredient(id, name,description, type);
            ingredientList.add(ingredient);
        }
    }
}
