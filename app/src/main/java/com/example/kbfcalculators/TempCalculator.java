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
import java.text.DecimalFormat;

public class TempCalculator extends AppCompatActivity {

    EditText inputF;
    EditText inputC;
    Button calculateTemps;
    DecimalFormat decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_calculator);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputF = findViewById(R.id.editFahrenheit);
        inputC = findViewById(R.id.editCelsius);

        calculateTemps = findViewById(R.id.calTemp);
        decimal = new DecimalFormat("#.###");

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

                ((EditText) findViewById(R.id.editFahrenheit)).setText(decimal.format(fahrenheit));

            }

        } else {

            double fahrenheit = Double.parseDouble(f);
            double celsius = ((fahrenheit - 32) * 5 / 9);

            ((EditText) findViewById(R.id.editCelsius)).setText(decimal.format(celsius));

        }
    }
}
