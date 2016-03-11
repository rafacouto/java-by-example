package es.cntg.cursoandroid.servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    private static final String EXTRA_DOCUMENT = "ovh.matrix.EXTRA_DOCUMENT";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        startSharing();

        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {

        stopSharing();

        super.onDestroy();
    }

    private void stopSharing() {

        stopService(new Intent(this, MyService.class));
    }

    private void startSharing() {

        Intent intent = new Intent(this, MyService.class);
        intent.putExtra(MyService.EXTRA_DOCUMENT, "contenido...");
        startService(intent);
    }
}
