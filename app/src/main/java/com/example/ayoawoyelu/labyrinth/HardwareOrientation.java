package com.example.ayoawoyelu.labyrinth;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by Ayoawoyelu on 2017-02-13.
 */

public class HardwareOrientation implements SensorEventListener {
    private SensorManager sensormanager;
    private Sensor accelerometer;
    private Sensor magnometer;

    private float [] accelOutput;
    private float [] magOutput;

    private float [] orientation = new float[3];
    public float [] getOrientation(){
        return orientation;
    }

    private float [] startOrientation = null;
    public float [] getStartOrientation(){
        return startOrientation;
    }

    public void newGame(){
        startOrientation = null;
    }
    public HardwareOrientation(){
        sensormanager = (SensorManager)Constants.CURRENT_CONTEXT.getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnometer = sensormanager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    public void register(){
        sensormanager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        sensormanager.registerListener(this, magnometer, SensorManager.SENSOR_DELAY_GAME);
    }


    public void pause(){
        sensormanager.unregisterListener(this);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            accelOutput = event.values;
        }
        else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            magOutput = event.values;
        }
        if(accelOutput != null && magOutput != null){
            float [] R = new float[9];
            float [] i  = new float[9];
            boolean success = SensorManager.getRotationMatrix(R,i,accelOutput, magOutput);
            if(success){
                SensorManager.getOrientation(R, orientation);
                if (startOrientation == null){
                    startOrientation = new float[orientation.length];

                    System.arraycopy(orientation,0, startOrientation,0, orientation.length);
                }
            }
        }
}
}
