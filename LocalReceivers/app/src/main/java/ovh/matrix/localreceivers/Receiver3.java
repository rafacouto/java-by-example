package ovh.matrix.localreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver3 extends BroadcastReceiver {
    public Receiver3() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Receiver3", Toast.LENGTH_LONG);
    }
}
