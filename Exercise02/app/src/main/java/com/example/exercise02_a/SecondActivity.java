package com.example.exercise02_a;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    String deliveryText="";
    TextView passedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //value from Main Activity
        deliveryText = getIntent().getStringExtra("deliver");

        //set to TextView
        passedText = (TextView) findViewById(R.id.textViewSecond);
        passedText.setText(deliveryText);

        Toast.makeText(getApplicationContext(), "We are moved to second Activity", Toast.LENGTH_LONG).show();
    }
}
