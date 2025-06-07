package com.example.android_assignment_summer_2025.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



public class SecondActivity extends AppCompatActivity {

    private final String TAG = "SecondActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate called");

        //Retrieve the intent that started this activity
        Intent intent = getIntent();
        String message = intent.getStringExtra("KEY");

        //Find the textview UI Element by ID and set the text to the message received
        TextView textView = findViewById(R.id.text_second_activity);
        textView.setText(message);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }
} 