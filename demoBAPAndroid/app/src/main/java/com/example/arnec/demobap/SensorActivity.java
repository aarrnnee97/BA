package com.example.arnec.demobap;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;

    TextView accelero;
    TextView magneto;
    TextView gyroscop;
    TextView temp;
    TextView baro;
    TextView vochtig;
    TextView licht;
    TextView nabij;
    TextView stappen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
        }catch(CameraAccessException e){

        }


        accelero = (TextView) findViewById(R.id.accelero);
        magneto = (TextView) findViewById(R.id.magneto);
        gyroscop = (TextView) findViewById(R.id.gyroscope);
        temp = (TextView) findViewById(R.id.temperatuur);
        baro = (TextView) findViewById(R.id.barometer);
        vochtig = (TextView) findViewById(R.id.vochtig);
        licht = (TextView) findViewById(R.id.licht);
        nabij = (TextView) findViewById(R.id.nabij);
        stappen = (TextView) findViewById(R.id.stappen);

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(500);


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Sensor mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);

        Sensor mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        Sensor mMagnetoMeter = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mSensorManager.registerListener(this, mMagnetoMeter, SensorManager.SENSOR_DELAY_NORMAL);

        Sensor mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);

        Sensor mTemperatuur = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mSensorManager.registerListener(this, mTemperatuur, SensorManager.SENSOR_DELAY_NORMAL);

        Sensor mBarometer = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mSensorManager.registerListener(this, mBarometer, SensorManager.SENSOR_DELAY_NORMAL);

        Sensor mVochtigheidsmeter = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        mSensorManager.registerListener(this, mVochtigheidsmeter, SensorManager.SENSOR_DELAY_NORMAL);

        Sensor mLicht = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(this, mLicht, SensorManager.SENSOR_DELAY_NORMAL);

        Sensor mNabij = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorManager.registerListener(this, mNabij, SensorManager.SENSOR_DELAY_NORMAL);

        Sensor mStappen = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mSensorManager.registerListener(this, mStappen, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor theSensor = event.sensor;

        if(theSensor.getType() == Sensor.TYPE_ACCELEROMETER){
            accelero.setText("Accelerometer: x: " + event.values[0] + " y: " + event.values[1] + " z: " + event.values[2]);
        }
        if(theSensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            magneto.setText("Magnetometer: x: " + event.values[0] + " y: " + event.values[1] + " z: " + event.values[2]);
        }

        if(theSensor.getType() == Sensor.TYPE_GYROSCOPE){
            gyroscop.setText("Gyroscope: x: " + event.values[0] + " y: " + event.values[1] + " z: " + event.values[2]);
        }

        if(theSensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
            temp.setText("Temperatuur: " + event.values[0]);
        }

        if(theSensor.getType() == Sensor.TYPE_PRESSURE){
            baro.setText("Barometer hPa: " + event.values[0]);
        }

        if(theSensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY){
            vochtig.setText("Vochtigheid: " + event.values[0]);
        }

        if(theSensor.getType() == Sensor.TYPE_LIGHT){
            licht.setText("Licht lx: " + event.values[0]);
        }

        if(theSensor.getType() == Sensor.TYPE_PROXIMITY){
            nabij.setText("Nabijheid: " + event.values[0]);
        }

        if(theSensor.getType() == Sensor.TYPE_STEP_COUNTER){
            nabij.setText("Stappen: " + event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
