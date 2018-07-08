package foodfindder.jacob.food_finder.ConnectTOSpring;

import android.os.AsyncTask;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import foodfindder.jacob.food_finder.Ingredient;
import foodfindder.jacob.food_finder.IngredientsList;

/**
 * Created by jacob on 7/4/18.
 */

public class IngredientsCollect extends AsyncTask<URL, String, String> {


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(URL... params) {
        StringBuilder sb = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) params[0].openConnection();
            connection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));
            String output;
            while((output = br.readLine()) != null)
            {
                sb.append(output);
            }
            connection.disconnect();
            br.close();
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
