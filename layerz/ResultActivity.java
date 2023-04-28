package com.example.layerz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

// Author: Drake Jerez
// CNIT 25501
public class ResultActivity extends AppCompatActivity {
    // These are the text boxes to display the greetings/recommendations for the day
    private TextView greetingText;
    private TextView recText1;
    private TextView textView5;
    private Button button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        // Getting the variables
        String recClothes = intent.getStringExtra("recs");
        String name = intent.getStringExtra("name");
        String city = intent.getStringExtra("city");
        String state = intent.getStringExtra("state");
        String country = intent.getStringExtra("country");

        Date currentTime = Calendar.getInstance().getTime();
        String customLocale = "Today is " + currentTime + " in " + city + ", " + state + ", " + country + ", ";

        greetingText = findViewById(R.id.greetingText);
        greetingText.setText("Hello " + name + "!\n" + customLocale);


        System.out.println(customLocale);


        recText1 = findViewById(R.id.recText1);
        recText1.setText(recClothes);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(MainActivity);
            }
        });

    }
}