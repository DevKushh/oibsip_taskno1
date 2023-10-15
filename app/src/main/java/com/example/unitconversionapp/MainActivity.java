package com.example.unitconversionapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView result;
    Button convert;
    Spinner choice;
    EditText value;
    String[] ChoiceList = {"Select Conversion Choice ","Kilograms to Grams", "Grams to Kilograms", "Meters to Kilometers", "Kilometers to meters", "Feet to Inches", "Inches to Feet"};
    String selectedChoice;
    Double ans;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.ResultBox);
        convert = findViewById(R.id.ConvertBtn);
        choice = findViewById(R.id.ChoiceBox);
        value = findViewById(R.id.NumberBox);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.mystyle, ChoiceList);
        adapter.setDropDownViewResource(R.layout.dropdownmenu);
        choice.setAdapter(adapter);
        choice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                selectedChoice = ChoiceList[i]; // Update selectedChoice here
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        convert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String inputText = value.getText().toString();
                if (!inputText.isEmpty())
                {
                    double input = Double.parseDouble(inputText);
                    if (selectedChoice.equals("Kilograms to Grams"))
                    {
                        ans = input * 1000;
                        String str = " Result is : " + ans + " Grams";
                        result.setText(str);
                    }
                    else if (selectedChoice.equals("Grams to Kilograms"))
                    {
                        ans = input / 1000;
                        String str = " Result is : " + ans + " Kilograms";
                        result.setText(str);
                    }
                    else if (selectedChoice.equals("Meters to Kilometers"))
                    {
                        ans = input / 1000;
                        String str = " Result is : " + ans + " Kilometers";
                        result.setText(str);
                    }
                    else if (selectedChoice.equals("Kilometers to meters"))
                    {
                        ans = input * 1000;
                        String str = " Result is : " + ans + " Meters";
                        result.setText(str);
                    }
                    else if (selectedChoice.equals("Feet to Inches"))
                    {
                        ans = input * 12;
                        String str = " Result is : " + ans + " Inches";
                        result.setText(str);
                    }
                    else if (selectedChoice.equals("Inches to Feet"))
                    {
                        ans = input / 12;
                        String str = " Result is : " + ans + " Feet";
                        result.setText(str);
                    }
                    else
                    {
                        result.setText("Sorry, Unable to Convert \nChoose Correct Choice");
                    }
                }
                else
                {
                    result.setText("Please enter a value to convert.");
                }
            }
        });
    }
}
