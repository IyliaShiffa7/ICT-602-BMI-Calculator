package com.example.bmicalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends Activity {
    private Button buttonprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        setupHyperlink();

        buttonprofile = (Button) findViewById(R.id.buttonprofile);
        buttonprofile.setOnClickListener (new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calculateProfile();
            }
        });
    }

    public void calculateProfile() {
        Intent intent = new Intent(this, CalculateBMI.class);
        startActivity(intent);
    }

    private void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.hyperlink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}