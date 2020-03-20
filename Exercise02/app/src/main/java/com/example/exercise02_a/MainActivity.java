package com.example.exercise02_a;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button send_btn;
    EditText text1;
    EditText text2;
    String deliveryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_btn = (Button)findViewById(R.id.sendBtn);
        text1 =(EditText)findViewById(R.id.textViewFirst);
        text2 =(EditText)findViewById(R.id.textViewSecond);

        //implement Onclick event for Explicit Intent
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = text1.getText().toString() + " " + text2.getText().toString();
                deliveryText = fullName;

                if(TextUtils.isEmpty(deliveryText)){

                    Toast.makeText(MainActivity.this,
                            "Type any sentences", Toast.LENGTH_LONG).show();
                }
                else {
                    // pass value tp second activity
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("deliver", deliveryText);
                    startActivity(intent);
                }
            }
        });
    }
}
