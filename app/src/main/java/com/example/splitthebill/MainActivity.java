package com.example.splitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //declare variables
    double costOfBill;
    int numberOfPeople;
    double billTip;
    double costWithTip;
    //double billTip = (costOfBill * numberOfPeople) / 0.18;
   // double costWithTip = (costOfBill * numberOfPeople) - billTip;
    double splitCost;
    String serviceChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add edittext, spinner and button
        final EditText bill = (EditText) findViewById(R.id.txtBill);
        final EditText people = (EditText) findViewById(R.id.txtPeople);
        final Spinner service = (Spinner) findViewById(R.id.txtService);
        Button cost = (Button) findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener(){
            final TextView result = ((TextView) findViewById(R.id.txtResult));
            @Override
            public void onClick(View v) {
                numberOfPeople = Integer.parseInt(people.getText().toString());
                costOfBill = Integer.parseInt(bill.getText().toString());
                billTip = (costOfBill * numberOfPeople) * 0.18;
                costWithTip = (costOfBill * numberOfPeople) + billTip;
                splitCost = costWithTip / numberOfPeople;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                serviceChoice = service.getSelectedItem().toString();
                result.setText("Bill is " + currency.format(splitCost) + " each and service was " + serviceChoice);
            }
        });
    }
}
