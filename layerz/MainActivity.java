package com.example.layerz;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

// Author: Drake Jerez
// CNIT 25501 Final Project
public class MainActivity extends AppCompatActivity {
    // these are the input string text boxes
    private EditText name;
    private EditText city;
    private EditText state;
    private EditText country;

    // these are the radio button inputs for preference, plus an enter button
    private RadioGroup RadioGroup;
    private RadioButton colderButton;
    private RadioButton normalButton;
    private RadioButton warmerButton;

    private Button button;

    // This is the recommendation for clothes
    //public String recClothes;
    //private int tempPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameInput);
        city = findViewById(R.id.cityInput);
        state = findViewById(R.id.stateInput);
        country = findViewById(R.id.countryInput);

        RadioGroup = findViewById(R.id.RadioGroup);
        colderButton = findViewById(R.id.radioButton4);
        normalButton = findViewById(R.id.radioButton5);
        warmerButton = findViewById(R.id.radioButton6);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {   // DONT EVER DO THIS
                // DISABLING NETWORK CONNECTION POLICY TO ALLOW WHATEVER HTTP CONNECTION
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                int tempPref = 0;
                String recClothes = null;
                
                String nameStr = name.getText().toString();
                String cityStr = city.getText().toString();
                String stateStr = state.getText().toString();
                String countryStr = country.getText().toString();

                if (warmerButton.isChecked())
                {
                    tempPref = 1;
                }
                else if (normalButton.isChecked())
                {
                    tempPref = 2;
                }
                else if (warmerButton.isChecked())
                {
                    tempPref = 3;
                }

                person user = new person(nameStr, cityStr, stateStr, countryStr, tempPref);
                System.out.println(user.getLocation()[0] + user.getPref() + user.getName());
                try
                {
                    System.out.println("Not broken yet");
                    weatherGroup today = new weatherGroup(cityStr, stateStr, countryStr);
                    System.out.println(today.getGroup());
                    Recommendations reccy = new Recommendations();
                    recClothes = reccy.recs(user, today);
                }
                catch (IOException e)
                {
                    System.err.println("Something broke with the IO stream");
                    e.printStackTrace();
                }
                catch (InterruptedException e)
                {
                    System.err.println("Issue with connection!");
                }
                
                // show new window here
                // Passing the new activity all my variables I need to make the UI pretty
                Intent resultIntent = new Intent(getApplicationContext(), ResultActivity.class);

                resultIntent.putExtra("recs", recClothes);
                resultIntent.putExtra("name", nameStr);
                resultIntent.putExtra("city", cityStr);
                resultIntent.putExtra("state", stateStr);
                resultIntent.putExtra("country", countryStr);

                startActivity(resultIntent);

            }
        });

    }
}