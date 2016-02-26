package ovh.matrix.App02;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity extends Activity {

    public final String APP_TAG = "BUTTON_APP";

    Button btnCall;
    Button btnTest;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnCall = (Button)findViewById(R.id.btnCall);

        btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Botón test premido!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void llamarDestinatario(View v) {

        Log.i(APP_TAG, "Foi escollida a opción de chamar.");
        btnCall.setText("Calling...");
    }


    @Override
    protected void onDestroy() {
        Log.i(APP_TAG, "onDestroy...");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(APP_TAG, "onPause...");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(APP_TAG, "onStop...");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i(APP_TAG, "onRestart...");
        super.onRestart();
    }
}
