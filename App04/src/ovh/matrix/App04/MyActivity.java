package ovh.matrix.App04;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Context ctx = getApplicationContext();

        switch (id) {

            case R.id.mnuOpcion1:
                Toast.makeText(ctx, "Option with ID " + id + " selected...", LENGTH_LONG).show();
                break;

            case R.id.mnuOpcion2:
                Toast.makeText(ctx, "Option with ID " + id + " selected...", LENGTH_LONG).show();
                break;

            case R.id.mnuOpcion3:
                Toast.makeText(ctx, "Option with ID " + id + " selected...", LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
