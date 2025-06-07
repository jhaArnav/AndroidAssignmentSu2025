package com.example.android_assignment_summer_2025.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android_assignment_summer_2025.model.CounterModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


//manage the data (greeting message and a counter) and provide methods to update this data
public class MainViewModel extends ViewModel {
    //we will use mutableLiveData to hold the data that can be observed by the view
    //greetingmessage will hold the greeting text and counter will hold the counter value
    private MutableLiveData<String> greetingMessage;
    private MutableLiveData<Integer> counter;
    //An instance of CounterModel to handle the counter logic
    private CounterModel counterModel;

    private DatabaseReference databaseReference;

    //constructor
    public MainViewModel(){
        greetingMessage = new MutableLiveData<>();
        counter = new MutableLiveData<>();
        counterModel = new CounterModel();
        greetingMessage.setValue("Hello World from ViewModel");
        counter.setValue(counterModel.getCounter());

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("counter").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Integer fireBaseCounter = dataSnapshot.getValue(Integer.class);

                    if (fireBaseCounter != null) {
                        counter.setValue(fireBaseCounter);
                        counterModel.setCounter(fireBaseCounter);
                    }
                } else {
                    counter.setValue(0);
                    counterModel.setCounter(0);
                    databaseReference.child("counter").setValue(0);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //handle errors: blank for now
            }
        });
    }

    //provide access to the livedata objects
    public LiveData<String> getGreetingMessage(){
        return greetingMessage;
    }

    public LiveData<Integer> getCounter(){
        return counter;
    }

    //Behavior Methods - update message and incrementing counter
    public void updateMessage(){
        greetingMessage.setValue("Hello from MainViewModel!");
    }

    public void incrementCounter(){
        counterModel.incrementCounter();
        counter.setValue(counterModel.getCounter());

        //write to firebase

        databaseReference.child("counter").setValue(counterModel.getCounter());
    }
} 