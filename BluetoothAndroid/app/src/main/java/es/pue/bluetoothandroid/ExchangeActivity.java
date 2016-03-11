/**
 * Created on May 19, 2010 by Dave Smith
 * Wireless Designs, LLC
 * 
 */
package es.pue.bluetoothandroid;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class ExchangeActivity extends Activity {

    // Unique UUID for this application (generated from the web)
	private static final UUID MY_UUID = UUID.randomUUID();
	//Friendly name to match while discovering
	private static final String SEARCH_NAME = "bluetooth.recipe";
	
	BluetoothAdapter btAdapter;
	BluetoothSocket btSocket;

	Button listenButton, scanButton;
	EditText emailField;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Activity");
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.main);
		
		// si no esta salimos, si esta deshabilitado llevamos hasta la pantalla de settings
		btAdapter = BluetoothAdapter.getDefaultAdapter();
		if (btAdapter == null) {
			Toast.makeText(this, "BT no disponible.", Toast.LENGTH_LONG).show();
			finish();
			return;
		}
		if (!btAdapter.isEnabled()) {
			Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableIntent, REQUEST_ENABLE);
		}

		
		emailField = (EditText)findViewById(R.id.emailField);
		listenButton = (Button)findViewById(R.id.listenButton);
		listenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

				if (btAdapter.getScanMode() != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {

					// TODO
				}

                startListening();
            }
        });
		scanButton = (Button)findViewById(R.id.scanButton);
		scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
	}
	
	@Override
	public void onResume() {
	    super.onResume();
	    //Register the activity for broadcast intents
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(mReceiver, filter);
	}
	
	@Override
	public void onPause() {
	    super.onPause();
	    unregisterReceiver(mReceiver);
	}
	
	@Override
	public void onDestroy() {
	    super.onDestroy();
		//TODO
	}
	
	private static final int REQUEST_ENABLE = 1;
	private static final int REQUEST_DISCOVERABLE = 2;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == REQUEST_ENABLE) {

		  if (resultCode != Activity.RESULT_OK) {
			  Toast.makeText(this, "BT no fue activado.", Toast.LENGTH_LONG).show();
			  finish();
		  }
		}
	}

	private void startListening() {

		AcceptTask task = new AcceptTask();
		task.execute(MY_UUID);
		setProgressBarVisibility(true);
	}
	
	//Tarea de aceptación de llamadas entrantes
	private class AcceptTask extends AsyncTask<UUID,Void,BluetoothSocket> {

        @Override
        protected BluetoothSocket doInBackground(UUID... params) {

			return null;
        };
	    
        @Override
        protected void onPostExecute(BluetoothSocket socket) {

			if (socket != null) {
				Toast.makeText(ExchangeActivity.this, "BT no conectado", Toast.LENGTH_LONG).show();
				return;
			}

			btSocket = socket;

			ConnectedTask task = new ConnectedTask();
			task.execute(socket);
        }
        
	}
	
	//AsyncTask to receive a single line of data and post
	private class ConnectedTask extends AsyncTask<BluetoothSocket,Void,String> {

		@Override
		protected String doInBackground(BluetoothSocket... params) {
			InputStream in = null;
			OutputStream out = null;
			try {
			    //Send your data
			    out = params[0].getOutputStream();
			    out.write("Testing...".getBytes());
			    //Receive the other's data
				in = params[0].getInputStream();
				byte[] buffer = new byte[1024];
				in.read(buffer);
				//Create a clean string from results
				String result = new String(buffer);
				//Close the connection
				btSocket.close();
				return result.trim();
			} catch (Exception exc) {
				return null;
			}
		}
		
		@Override
		protected void onPostExecute(String result) {
		    
			Toast.makeText(ExchangeActivity.this, result, Toast.LENGTH_SHORT).show();
			setProgressBarIndeterminateVisibility(false);
		}
		
	}

    // The BroadcastReceiver that listens for discovered devices
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
        }
    };
}
