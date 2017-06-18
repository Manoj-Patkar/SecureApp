package com.example.myfirst.secureapp;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText datetext=(EditText)findViewById(R.id.expiryDate);
        final EditText cardnumber=(EditText)findViewById(R.id.creditCardDetails);
        if(datetext!=null){
            datetext.addTextChangedListener(new TextWatcher() {
                int count=0;
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                if(count<=datetext.getText().toString().length() && datetext.getText().length()==2) {
                    datetext.setText(datetext.getText() + "/");
                    int pos = datetext.getText().length();
                    datetext.setSelection(pos);
                }else if(count >datetext.getText().toString().length() && datetext.getText().length()==2){
                    datetext.setText(datetext.getText().toString().substring(0,datetext.getText().toString().length()-1));
                    int pos = datetext.getText().length();
                    datetext.setSelection(pos);
                }
                    count = datetext.getText().toString().length();
                }
            });
        }
        if (cardnumber != null) {
            cardnumber.addTextChangedListener(new TextWatcher() {
                int count=0;
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (count <= cardnumber.getText().toString().length()
                            &&(cardnumber.getText().toString().length()==4
                            ||cardnumber.getText().toString().length()==9
                            ||cardnumber.getText().toString().length()==14)){
                        cardnumber.setText(cardnumber.getText().toString()+" ");
                        int pos = cardnumber.getText().length();
                        cardnumber.setSelection(pos);
                    }else if (count >= cardnumber.getText().toString().length()
                            &&(cardnumber.getText().toString().length()==4
                            ||cardnumber.getText().toString().length()==9
                            ||cardnumber.getText().toString().length()==14)){
                        cardnumber.setText(cardnumber.getText().toString().substring(0,cardnumber.getText().toString().length()-1));
                        int pos = cardnumber.getText().length();
                        cardnumber.setSelection(pos);
                    }
                    count = cardnumber.getText().toString().length();
                }

            });
        }


        final  Button proceedMain2Act=(Button)findViewById(R.id.save_button);
        final EditText cvv=(EditText)findViewById(R.id.cvv);
        final EditText cardName=(EditText) findViewById(R.id.creditCardName);
        if (proceedMain2Act != null) {
            proceedMain2Act.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(datetext.getText().toString().equals("01/25") && cardnumber.getText().toString().equals("5555 5555 5555 5555") &&
                            cvv.getText().toString().equals("555") && cardName.getText().toString().equalsIgnoreCase("manish")){
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        MainActivity.this.finish();
                    }
                    else{
                        Toast toast=Toast.makeText(getApplicationContext(),"Please Enter Valid Card Details",Toast.LENGTH_LONG);
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
