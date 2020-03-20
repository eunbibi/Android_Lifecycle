package com.example.exercise03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextViewMenu txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,
                "On Create", Toast.LENGTH_LONG).show();

        String creat = getString(R.string.create);
        txt=  (TextViewMenu)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change(creat);

    }
    /** Lifecycle method: Called when the activity is becoming visible to user. */
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(MainActivity.this,
                "On Start", Toast.LENGTH_LONG).show();

        String start = getString(R.string.start);

        txt.change("\n"+ start);
    }

    /** Lifecycle method: Called when the activity is becoming visible to user. */
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(MainActivity.this,
                "On Resume", Toast.LENGTH_LONG).show();

        String start = getString(R.string.start);

        txt.change("\n"+ start);
    }


    /** Lifecycle method: Called when the activity is no longer visible to the user. */
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(MainActivity.this,
                "On Stop", Toast.LENGTH_LONG).show();

        String stop = getString(R.string.stop);

        TextViewMenu txt = (TextViewMenu)getFragmentManager().findFragmentById(R.id.fragment2);
       // txt.change(stop);
    }

    /** Lifecycle method: The final call received before the activity is destroyed. */
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(MainActivity.this,
                "On Destroy", Toast.LENGTH_LONG).show();

        String destroy = getString(R.string.destroy);

        TextViewMenu txt = (TextViewMenu)getFragmentManager().findFragmentById(R.id.fragment2);
     //   txt.change(destroy);
    }
}
