package com.example.android_assignment_summer_2025.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.android_assignment_summer_2025.BR;
import com.example.android_assignment_summer_2025.R;
import com.example.android_assignment_summer_2025.databinding.ActivityMainBinding;
import com.example.android_assignment_summer_2025.viewmodel.MainViewModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;
import java.util.List;





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

        Button countGraph = findViewById(R.id.button_countergraph);
        countGraph.setOnClickListener((l) -> drawGraph(viewModel));
    }

    public void drawGraph(MainViewModel viewModel) {
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, viewModel.getCounter().getValue()));

        BarDataSet dataSet = new BarDataSet(entries, "Counter Data");
        BarChart barChart = findViewById(R.id.barChart);
        barChart.setData(new BarData(dataSet));

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setEnabled(false);
        barChart.getDescription().setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawLabels(false);
        xAxis.setDrawGridLines(false);
        barChart.invalidate();
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