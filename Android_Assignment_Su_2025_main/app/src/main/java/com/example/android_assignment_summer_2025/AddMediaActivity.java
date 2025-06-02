package com.example.android_assignment_summer_2025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddMediaActivity extends AppCompatActivity {
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
                    Intent intent = new Intent(AddMediaActivity.this, WatchListActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
