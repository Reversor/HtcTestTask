package reversor.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.concurrent.ExecutionException;

import reversor.test.adapter.EmployeeAdapter;
import reversor.test.data.DataLoader;
import reversor.test.data.entity.Company;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.listView);
        DataLoader loader = new DataLoader();
        Company company = null;
        try {
            company = loader.execute().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            loader.cancel(true);
        }

        list.setAdapter(new EmployeeAdapter(this, company));
    }
}
