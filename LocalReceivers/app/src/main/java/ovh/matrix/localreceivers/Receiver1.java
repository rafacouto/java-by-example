package ovh.matrix.localreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver1 extends BroadcastReceiver {
    public Receiver1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Receiver2", Toast.LENGTH_LONG);

    }
}
