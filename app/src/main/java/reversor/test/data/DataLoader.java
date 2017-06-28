package reversor.test.data;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import reversor.test.data.entity.Company;
import reversor.test.data.entity.JsonObject;

public class DataLoader extends AsyncTask<Void, Void, Company> {

    @Override
    protected Company doInBackground(Void... voids) {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://www.mocky.io/v2/56fa31e0110000f920a72134");
            urlConnection = ((HttpURLConnection) url.openConnection());
            Reader reader = new InputStreamReader(urlConnection.getInputStream());

            Gson gson = new GsonBuilder().create();
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            Log.i(this.getClass().getName(), "Something created from: " + jsonObject.toString());

            return jsonObject.getCompany();
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
