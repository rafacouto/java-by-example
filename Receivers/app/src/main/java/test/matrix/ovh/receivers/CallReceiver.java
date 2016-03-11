package test.matrix.ovh.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallReceiver extends BroadcastReceiver {

    public CallReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle data = intent.getExtras();

        if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            Log.i("[BroadcastReceiver]", "Screen ON");
        }
        else if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            Log.i("[BroadcastReceiver]", "Screen OFF");
        }
        else if (intent.getAction().equals((Intent.ACTION_CALL))) {
            Log.i("[BroadcastReceiver]", "Call");
            if (data != null) {

                String state = data.getString(TelephonyManager.EXTRA_STATE);

                if (state.equals((TelephonyManager.EXTRA_STATE_RINGING))) {

                    String number = data.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

                    Log.i("TEST", "CallReceiver.onReceive: " + number);
                }
            }
        }

    }
}
