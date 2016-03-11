package ovh.matrix.localreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private LocalBroadcastManager broadcastManager;
    public static final String INTENT_LOCAL_BROADCAST = "ovh.matrix.INTENT_LOCAL_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                broadcastManager.sendBroadcast(new Intent(INTENT_LOCAL_BROADCAST));
            }
        });
    }
}
