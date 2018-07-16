package foodfindder.jacob.food_finder.Recipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import foodfindder.jacob.food_finder.Ingredients_Activity;
import foodfindder.jacob.food_finder.MainActivity;
import foodfindder.jacob.food_finder.R;

/**
 * Created by jacob on 6/30/18.
 */

public class Recipe_Act extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Recipe's");
        setContentView(R.layout.activity_recipe);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }else if(id == R.id.action_ingredients)
        {
            Intent intent = new Intent(this, Ingredients_Activity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_main)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
