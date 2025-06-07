package com.example.android_assignment_summer_2025.view;

import android.os.Bundle;
import android.widget.Button;
import com.example.android_assignment_summer_2025.viewmodel.MainViewModel;



public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //use data binding to inflate the layout
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d(TAG, "onCreate called");

        //create viewmodel
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //bind viewmodel to layout
        binding.setVariable(BR.viewModel, viewModel);
        binding.setLifecycleOwner(this);

        //find button by id
        Button openButton = findViewById(R.id.button_open);

        //Set an onClickListener to the button
        openButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //create an intent to start secondactivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                //Add extra data to the intent
                intent.putExtra("KEY", "Hello from Main Activity!");

                //start the second activity
                startActivity(intent);
            }
        });
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