package com.example.simplecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import android.app.DatePickerDialog;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editTextAmount;
    Button buttonCal;
    TextView textViewResult;
    EditText txtDate;
    Button buttonDate;

    double interest = 0;
    double result = 0;
    int duration = 0;
    double amount = 0;

    //For spinner
    String[] users1 = { "1", "2", "3", "4", "5" };

    RadioButton interest1, interest2, interest3;

    //For date picker
    private int mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinner setting
        Spinner spin = (Spinner) findViewById(R.id.spinner1);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // spin.setSelection(adapter.getPosition("1"));
        // Apply the adapter to the spinner
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

        //Radio button
        interest1 = (RadioButton) findViewById(R.id.radioBtn_id1);
        interest2= (RadioButton) findViewById(R.id.radioBtn_id2);
        interest3 = (RadioButton) findViewById(R.id.radioBtn_id3);

        editTextAmount = (EditText) findViewById(R.id.editTextAmount);

        buttonCal = (Button) findViewById(R.id.buttonCal);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

        //date Picker
        txtDate = (EditText)findViewById(R.id.editTextDate);
        buttonDate = (Button)findViewById(R.id.buttonDate);

        //print total
        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDate.setOnClickListener(this);

                boolean emptyChk = (editTextAmount.getText().toString().isEmpty());

                if( emptyChk == true) {
                    Toast.makeText(MainActivity.this,
                            "There is no amount", Toast.LENGTH_LONG).show();
                }
                else{
                    amount = Double.parseDouble(editTextAmount.getText().toString());

                    if (amount !=0)
                    {
                        amount = Double.parseDouble(editTextAmount.getText().toString());
                        if(interest1.isChecked()){
                            interest = 2.0;
                        }
                        else if(interest2.isChecked()){
                            interest = 2.5;
                        }
                        else if(interest3.isChecked()){
                            interest = 3.0;
                        }

                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Display total loan amount?")
                                .setMessage("Are you sure, you want to continue ?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(MainActivity.this,"Loan Amount: " + amount + "\nInterest: " + interest,Toast.LENGTH_SHORT).show();
                                        // amount+((amount * duration * rate)/100);
                                        result =  amount+((amount * duration * interest)/100);
                                        textViewResult.setText(String.valueOf(result));
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(MainActivity.this,"Selected: No",Toast.LENGTH_SHORT).show();
                                        textViewResult.setText(String.valueOf(0));
                                    }
                                });

                        AlertDialog dialog  = builder.create();
                        dialog.show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,
                                "Amount should not be 0", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    public void onRadioButtonClicked1(View view) {

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str="";

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioBtn_id1:
                if(checked)
                    str = "Interest: 2.0%";
                break;
            case R.id.radioBtn_id2:
                if(checked)
                    str = "Interest: 2.5%";
                break;
            case R.id.radioBtn_id3:
                if(checked)
                    str = "Interest: 3.0%";
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
      //  Toast.makeText(getApplicationContext(), "Selected : "+users1[position] ,Toast.LENGTH_SHORT).show();
        duration = Integer.parseInt(users1[position]);
    }

   @Override
    public void onNothingSelected(AdapterView<?> arg0) {
       android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
       builder.setTitle("Display total loan amount?")
               .setMessage("Are you sure, you want to continue ?");
    }
}
