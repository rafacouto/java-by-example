package es.pue.notificacionesandroid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.RadioGroup;

public class NotificationActivity extends Activity {

    private RadioGroup mOptionsGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mOptionsGroup = (RadioGroup) findViewById(R.id.options_group);
    }

    public void onPostClick(View v) {
        final int noteId = mOptionsGroup.getCheckedRadioButtonId();
        final Notification note;
        switch (noteId) {
            case R.id.option_basic:
            case R.id.option_bigtext:
            case R.id.option_bigpicture:
            case R.id.option_inbox:
                note = buildStyledNotification(noteId);
                break;
            case R.id.option_headsup:
                note = buildSecuredNotification(noteId);
                break;
            default:
                throw new IllegalArgumentException("Tipo desconocido");
        }

        //TODO:lanzar notificacion
    }
    
    private Notification buildStyledNotification(int type) {
        //TODO: intent



        //TODO: creacion de builder
        

        //TODO: creacion notificacion a partir de builder
        switch (type) {
            case R.id.option_basic:

            case R.id.option_bigtext:

            case R.id.option_bigpicture:

            case R.id.option_inbox:

            default:
                throw new IllegalArgumentException("Tipo desconocido");
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    //These properties can be overridden by the user's notification settings
    private Notification buildSecuredNotification(int type) {
        Intent launchIntent =
                new Intent(this, NotificationActivity.class);
        PendingIntent contentIntent =
                PendingIntent.getActivity(this, 0, launchIntent, 0);

        //Construct the base notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Account Balance Update")
                .setContentText("Your account balance is -$250.00")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Your account balance is -$250.00; pay us please "
                                + "or we will be forced to take legal action!"))
                .setContentIntent(contentIntent);

        switch (type) {
            case R.id.option_headsup:

            default:
                throw new IllegalArgumentException("Tipo desconocido");
        }
    }
}