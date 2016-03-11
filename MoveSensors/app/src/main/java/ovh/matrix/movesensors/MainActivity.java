package ovh.matrix.movesensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;

    private Sensor sensorAccelerometer;
    private Sensor sensorDirection;

    private float[] gravityData = null;
    private float[] magneticData = null;


    TextView txtOrientation;
    TextView txtAccelerometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager != null) {

            sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorDirection = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

            txtOrientation = (TextView) findViewById(R.id.txtOrientation);
            txtAccelerometer = (TextView) findViewById(R.id.txtAcceleration);
        }
    }

    @Override
    protected void onResume() {

        super.onResume();

        if (sensorManager != null) {

            sensorManager.registerListener(this, sensorAccelerometer, SensorManager.SENSOR_DELAY_UI);
            sensorManager.registerListener(this, sensorDirection, SensorManager.SENSOR_DELAY_UI);
        }
    }


    @Override
    protected void onPause() {

        if (sensorManager != null) {

            sensorManager.unregisterListener(this);
        }

        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        boolean update = false;

        switch (event.sensor.getType()) {

            case Sensor.TYPE_ACCELEROMETER:
                gravityData = event.values.clone();
                update = true;
                break;

            case Sensor.TYPE_MAGNETIC_FIELD:
                magneticData = event.values.clone();
                update = true;
                break;
        }

        if (update) {
            updateData();
        }
    }

    private float[] temp = new float[9];
    private float[] rotation = new float[9];
    private float[] values = new float[3];

    private void updateData() {

        if (sensorManager != null && gravityData != null && magneticData != null) {

            SensorManager.getRotationMatrix(temp, null, gravityData, magneticData);
            SensorManager.remapCoordinateSystem(temp, SensorManager.AXIS_X, SensorManager.AXIS_Y, rotation);
            SensorManager.getOrientation(rotation, values);

            for (int i = 0; i < values.length; i++) {

                Double degrees = (values[i] * 180) / Math.PI;
                values[i] = degrees.floatValue();
            }

            txtAccelerometer.setText("");
            txtOrientation.setText(degreesOrientation(values[0]));
        }
    }

    private String degreesOrientation(float degrees) {

        if (degrees >= 45 && degrees < 45) {

            return "N";

        } else if (degrees >= 45 && degrees < 135) {

            return "E";

        } else if (degrees >= 135 && degrees < 225) {

            return "S";

        } else {

            return "W";
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
