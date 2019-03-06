package com.example.kbfcalculators;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TempCalculator extends AppCompatActivity {

    EditText inputF;
    EditText inputC;
    Button calculateTemps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_calculator);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputF = findViewById(R.id.editFarhenheit);
        inputC = findViewById(R.id.editCelcius);

        calculateTemps = findViewById(R.id.calTemp);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View v) {

        String f = inputF.getText().toString();
        String c = inputC.getText().toString();

        // Is Fahrenheit field empty?  If so, convert from Celsius

        if (f.isEmpty()) {

            // Check Celsius field first; if it is not empty, convert to Fahrenheit

            if (!c.isEmpty()) {

                double celsius = Double.parseDouble(c);
                double fahrenheit = ((celsius * 9 / 5) + 32);

                ((EditText) findViewById(R.id.editFarhenheit)).setText(Double.toString(fahrenheit));

            }

        } else {

            double fahrenheit = Double.parseDouble(f);
            double celsius = ((fahrenheit - 32) * 5 / 9);

            ((EditText) findViewById(R.id.editCelcius)).setText(Double.toString(celsius));

        }
    }
}
