package com.example.android_assignment_summer_2025;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;




public class MainActivity extends AppCompatActivity {

    private List<Media> content;
    private LinearLayout mediaContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // TODO 1: Set content view to activity_watchlist.xml file
        setContentView(R.layout.activity_watchlist);


        // DO NOT MODIFY
        content = MediaManagerSingleton.getInstance().getContent();
        mediaContainer = findViewById(R.id.mediaContainer);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FloatingActionButton btnAddMedia = findViewById(R.id.fab);

        // TODO 3: Program the btnAddMedia to trigger an intent
        //  Intent should switch the activity on screen to AddMediaActivity when btnAddMedia is clicked
        btnAddMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message", "hello from main activity");
                startActivity(intent);
            }
        });

        // TODO 5: Iterate over all the media content in the list and use the addMediaToUI helper method to add the description to the UI
        for (Media media : content) {
            addMedia(media);
        }
    }

    // DO NOT MODIFY METHOD
    // This method takes a SINGULAR content and automatically propagates it to the UI with a corresponding checkbox
    private void addMedia(Media content) {
        LinearLayout contentItemLayout = new LinearLayout(this);
        contentItemLayout.setOrientation(LinearLayout.HORIZONTAL);
        contentItemLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        CheckBox checkBox = new CheckBox(this);
        checkBox.setChecked(content.isCompleted());
        // Set listener to update the content's isCompleted field
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            content.setCompletionStatus(isChecked);
        });

        checkBox.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView mediaView = new TextView(this);
        mediaView.setText(content.getDescription());
        mediaView.setTextSize(16);
        mediaView.setPadding(20, 20, 20, 20);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f);
        mediaView.setLayoutParams(textParams);

        contentItemLayout.addView(checkBox);
        contentItemLayout.addView(mediaView);

        mediaContainer.addView(contentItemLayout);
    }


}