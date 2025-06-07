package com.example.android_assignment_summer_2025.model;

public class CounterModel {
    private int counter;

    //add a constructor and initialize this variable to 0
    public CounterModel(){
        this.counter = 0;
    }

    //getCounter() returns the correct value of counter
    public int getCounter(){
        return counter;
    }

    //method that increments the value of counter by 1
    public void incrementCounter(){
        counter++;
    }
} 