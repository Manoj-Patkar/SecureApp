package com.example.myfirst.secureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText pin=(EditText)findViewById(R.id.pintext);
        final Button button=(Button)findViewById(R.id.proceedAftrPinBtn);

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(pin.getText().toString().equals("576111")) {
                        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        Main2Activity.this.finish();
                    }else{
                        Toast toast= Toast.makeText(getApplicationContext(),"Please Enter A valid Pin",Toast.LENGTH_LONG);
                        toast.show();
                    }

                }
            });
        }


    }

    @Override
    public void onBackPressed() {

    }
}
