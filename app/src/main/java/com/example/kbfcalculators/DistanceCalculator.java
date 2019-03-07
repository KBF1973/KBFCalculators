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

public class DistanceCalculator extends AppCompatActivity {

    EditText inputM;
    EditText inputK;
    Button calculateDistance;
    DecimalFormat decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_calculator);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputM = findViewById(R.id.editMiles);
        inputK = findViewById(R.id.editKilometers);

        calculateDistance = findViewById(R.id.calDistance);
        decimal = new DecimalFormat("#.###");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View v){

        String miles = inputM.getText().toString();
        String kilometers = inputK.getText().toString();

        // Is miles field empty?  If so, convert from kilometers

        if (miles.isEmpty()) {

            // Check kilometers field first; if it is not empty, convert to miles

            if (!kilometers.isEmpty()) {

                double kilo = Double.parseDouble(kilometers);
                double mil = (kilo * 0.621370);

                ((EditText) findViewById(R.id.editMiles)).setText(decimal.format(mil));

            }

        } else {

            double miles2 = Double.parseDouble(miles);
            double kilometers2 = (miles2 * 1.609344);

            ((EditText) findViewById(R.id.editKilometers)).setText(decimal.format(kilometers2));

        }

    }

}
