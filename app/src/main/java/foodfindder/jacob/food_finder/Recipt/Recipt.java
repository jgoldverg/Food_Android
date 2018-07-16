package foodfindder.jacob.food_finder.Recipt;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jacob on 7/11/18.
 */

public class Recipt {
    Bitmap factory;

    public Recipt(String location){
        factory = new BitmapFactory().decodeFile(location);

    }

    public void writeImageToSpring() throws MalformedURLException {
        if(factory != null){
            String location = "http://localhost:8080/recipt_img";
            URL url = new URL(location);
            String jsonText = "";
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("PUT");
                httpURLConnection.connect();
            //    httpURLConnection.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
