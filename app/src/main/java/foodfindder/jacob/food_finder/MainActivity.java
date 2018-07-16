package foodfindder.jacob.food_finder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import foodfindder.jacob.food_finder.ConnectTOSpring.IngredientsCollect;
import foodfindder.jacob.food_finder.Recipe.Recipe_Act;
import foodfindder.jacob.food_finder.Recipt.Recipt_Act;

public class MainActivity extends AppCompatActivity {
    private String jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
        if (id == R.id.action_settings)
        {
            return true;
        }else if(id == R.id.action_ingredients)
        {
            Intent intent = new Intent(this, Ingredients_Activity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_recipt)
        {
            Intent intent = new Intent(this, Recipt_Act.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
