package com.example.android_assignment_summer_2025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView messageTextView = findViewById(R.id.messageTextView);
        
        // Get the message from MainActivity
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        
        if (message != null) {
            messageTextView.setText(message);
        } else {
            messageTextView.setText("hello from main activity");
        }
    }
}
