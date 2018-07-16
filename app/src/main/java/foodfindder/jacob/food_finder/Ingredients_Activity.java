package foodfindder.jacob.food_finder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import foodfindder.jacob.food_finder.ConnectTOSpring.IngredientsCollect;
import foodfindder.jacob.food_finder.Recipe.Recipe_Act;
import foodfindder.jacob.food_finder.Recipt.Recipt_Act;

/**
 * Created by jacob on 6/27/18.
 */

public class Ingredients_Activity extends AppCompatActivity {
    private RelativeLayout ingredientPos;
    private IngredientsList ingredientsList;
    private ArrayAdapter<Ingredient> itemsAdapter;

    public IngredientsList getIngredientsList() {
        return ingredientsList;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        ingredientsList = new IngredientsList();
        setTitle("Ingredient");
        ingredientPos = findViewById(R.id.position_ingredients_list);
        IngredientsCollect collect = new IngredientsCollect();
        String content;
        try {
            URL url = new URL(load());
            content = collect.execute(url).get();
            ingredientsList.readLine(content);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("FUCKED UP ASYNC INGREDIENTS");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        populateIngredientsList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_ingredients) {
            Intent intent = new Intent(this, Ingredients_Activity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_recipt) {
            Intent intent = new Intent(this, Recipt_Act.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public String load() {
        return "https://www.themealdb.com/api/json/v1/1/list.php?i=list";
    }

    public String loadEdaman() {
        return "https://api.edamam.com/api/food-database/parser?ingr=red%20apple&app_id={be8dc5d6}&app_key={6a060f3ea51f3f790a7a9c1ec110865c}&page=0";
    }

    private void populateIngredientsList() {
        Ingredient_List_Adapter adapter = new Ingredient_List_Adapter(this, getIngredientsList());
        ListView listView = (ListView) findViewById(R.id.ingredients_list);
        listView.setAdapter(adapter);
    }
}





