package com.example.myfirst.secureapp;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements  SensorEventListener{

    private SensorManager sm;

    private float accelVal;
    private float accelLast;
    private float shake;
    private static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        count=0;

        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor accelorometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener( this,accelorometer,SensorManager.SENSOR_DELAY_NORMAL);

        accelVal=SensorManager.GRAVITY_EARTH;
        accelLast=SensorManager.GRAVITY_EARTH;
        shake=0.00f;
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("msg","on start ");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("msg","onrestart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("msg","on Resume");
    }



    @Override
    public void onSensorChanged(SensorEvent event) {

        float x=event.values[0];
        float y=event.values[1];
        float z=event.values[2];
        accelLast=accelVal;
        accelVal=(float)Math.sqrt((double)x*x+y*y+z*z);
        float delta=accelVal-accelLast;

        shake=shake*0.9f+delta;

        if(shake>=50){
            count++;
            Log.d("manish","count "+count);
            if(count<3) {
                Toast toast = Toast.makeText(getApplicationContext(), (3 - count) + " times to go", Toast.LENGTH_SHORT);
                toast.show();

            }
           else if(count==3){
                Intent intent=new Intent(Main3Activity.this,Main4Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                count=3;
                startActivity(intent);
                sm.unregisterListener(this);
                Main3Activity.this.finish();
            }

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onBackPressed() {

    }
}
