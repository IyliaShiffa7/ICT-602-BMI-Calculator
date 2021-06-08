package com.example.bmicalculator;

//Import necessary package and file
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//Main activity class start here
public class CalculateBMI extends AppCompatActivity {

    //Define layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculatebmi);
        setupHyperlink();

// Get the references to the widgets
        final EditText w = (EditText) findViewById(R.id.tfweight);
        final EditText h = (EditText) findViewById(R.id.tfheight);
        final TextView output = (TextView) findViewById(R.id.output);

        findViewById(R.id.buttoncalc).setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be empty
            @Override
            public void onClick(View v) {

                String str1 = w.getText().toString();
                String str2 = h.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    w.setError("Please enter your weight");
                    w.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    h.setError("Please enter your height");
                    h.requestFocus();
                    return;
                }

//Get the user values from the widget reference
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;

//Calculate BMI value
                float bmiValue = calculateBMI(weight, height);

//Define the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);
                String risk = riskBMI(bmiValue);

                output.setText(String.valueOf("BMI : " + bmiValue + "\nCategory : " + bmiInterpretation + "\nHealth Risk : " + risk));
            }
        });

    }

    //Calculate BMI
    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }

    private void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.hyperlink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 18.5) {
            return "Underweight";
        }
        else if (bmiValue < 25) {
            return "Normal weight";
        }
        else if (bmiValue < 30) {
            return "Overweight";
        }
        else if (bmiValue < 35) {
            return "Moderately obese";
        }
        else if (bmiValue < 40) {
            return "Severely obese";
        }
        else {
            return "Very severely obese";
        }
    }
    private String riskBMI(float bmiValue) {

        if (bmiValue < 18.5) {
            return "Malnutrition risk";
        }
        else if (bmiValue < 25) {
            return "Low risk";
        }
        else if (bmiValue < 30) {
            return "Enhanced risk";
        }
        else if (bmiValue < 35) {
            return "Medium risk";
        }
        else if (bmiValue < 40) {
            return "High risk";
        }
        else {
            return "Very high risk";
        }
    }
}

