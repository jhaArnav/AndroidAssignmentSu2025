package com.example.android_assignment_summer_2025.viewmodel;

import com.example.android_assignment_summer_2025.model.CounterModel;





//manage the data (greeting message and a counter) and provide methods to update this data
public class MainViewModel extends ViewModel {
    //we will use mutableLiveData to hold the data that can be observed by the view
    //greetingmessage will hold the greeting text and counter will hold the counter value
    private MutableLiveData<String> greetingMessage;
    private MutableLiveData<Integer> counter;
    //An instance of CounterModel to handle the counter logic
    private CounterModel counterModel;

    //constructor
    public MainViewModel(){
        greetingMessage = new MutableLiveData<>();
        counter = new MutableLiveData<>();
        counterModel = new CounterModel();
        greetingMessage.setValue("Hello World from ViewModel");
        counter.setValue(counterModel.getCounter());
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
    }
} 