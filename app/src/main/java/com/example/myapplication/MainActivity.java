package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
    }

    public void handleText(View v){
        // Pass information from an edittext to a textview
        EditText t = findViewById(R.id.source);
        String input = t.getText().toString();
        ((TextView)findViewById(R.id.output)).setText(input);

        // Show an alert
        Toast.makeText(this, "Alert", Toast.LENGTH_LONG).show();
    }

    public void disable(View v){
        // Enable and disable button
        Button enter = (Button) v;
        View myView = findViewById(R.id.button);
        Button disable = (Button) myView;

        if(disable.isEnabled()){
            disable.setText("Disabled");
            disable.setEnabled(false);
            enter.setText("Enable");
            Log.d("success", "Button disabled");
        } else{
            disable.setText("Enter");
            disable.setEnabled(true);
            enter.setText("Disable");
            Log.d("success", "Button enabled");
        }
    }

    public void launchSettings(View v){
        // Launch a new activity
        Intent i = new Intent(this, SettingsActivity.class);
        String message = ((EditText)findViewById(R.id.source)).getText().toString();
        i.putExtra("MSSG", message);
        startActivity(i);
    }
}