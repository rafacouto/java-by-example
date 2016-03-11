package test.matrix.ovh.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        vibrator.vibrate(500);

        Toast.makeText(context, "Vibrando...", Toast.LENGTH_LONG).show();
        Log.i("MyReceiver", "Vibrando...");
    }
}
