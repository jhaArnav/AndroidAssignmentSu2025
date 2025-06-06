package com.example.android_assignment_summer_2025;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;



public class SecondActivity extends AppCompatActivity {
    private List<Media> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_media);

        // TODO 6: Assign respective EditText and button to XML bindings
        // HINT: look at the error messages below to see what you should name the different entities
        Button btnSubmitMedia = findViewById(R.id.btnSubmitMedia);
        EditText Description = findViewById(R.id.mediaDescription);
        
        // DO NOT MODIFY
        btnSubmitMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = Description.getText().toString().trim();
                if (!description.isEmpty()) {
                    Media content = new Media(description);
                    MediaManagerSingleton.getInstance().addMedia(content);
                    // Get the message from MainActivity and display it
                    Intent receivedIntent = getIntent();
                    String message = receivedIntent.getStringExtra("message");
                    Description.setText(message != null ? message : "hello from main activity");
                    
                    // Go back to MainActivity
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
