package com.example.exercise03;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity  extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent1);

        String creat = getString(R.string.create);
        txt= (TextView) findViewById(R.id.textView2);
        txt.append(creat);

    }

    @Override
    protected void onStart(){
        super.onStart();

        String start = getString(R.string.start);
        txt.append("\n"+ start);
    }

    @Override
    protected void onStop(){
        super.onStop();

        String stop = getString(R.string.stop);
        txt.append("\n"+ stop);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        String destroy = getString(R.string.destroy);
        txt.append("\n"+ destroy);
    }
}
