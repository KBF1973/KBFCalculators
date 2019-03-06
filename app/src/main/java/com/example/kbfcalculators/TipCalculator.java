package com.example.kbfcalculators;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import java.text.DecimalFormat;
import java.lang.Math;

public class TipCalculator extends AppCompatActivity {

    EditText textTotal;
    EditText tipTotal;
    EditText peopleTotal;
    TextView totalPer;
    Button   calTotal;
    DecimalFormat decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textTotal = findViewById(R.id.totalText);
        tipTotal = findViewById(R.id.tipText);
        peopleTotal = findViewById(R.id.peopleText);
        calTotal = findViewById(R.id.Calculate2);
        totalPer = findViewById(R.id.totalPerPerson);
        decimal = new DecimalFormat("#.##");

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

    public void onClick(View v){

        String totalString = textTotal.getText().toString();
        String tipString = tipTotal.getText().toString();
        String peopleString = peopleTotal.getText().toString();
        double total = Double.parseDouble(totalString);
        double tip = Double.parseDouble(tipString);
        double people = Double.parseDouble(peopleString);

        double grandTotal = Math.ceil(total + (total * tip)) / people;

        totalPer.setText("$" + decimal.format(grandTotal));



    }


}
