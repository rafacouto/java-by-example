package es.cntg.cursoandroid.servicios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ClientExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_example);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.startSharing:
                startSharing(view);
                break;
            case R.id.stopSharing:
                stopSharing(view);
                break;
        }
    }

    public void startSharing(View view) {
        //TODO
    }

    public void stopSharing(View v) {

        //TODO
    }
}
