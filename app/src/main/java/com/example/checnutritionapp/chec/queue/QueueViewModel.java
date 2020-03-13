package com.example.checnutritionapp.chec.queue;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QueueViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QueueViewModel() {
       // android:text="\n Monday 02/03/2020                                           Total: $10.00\n\n [meal]: 2                                              Pickup:\n\n [meal]: 0                                             Time:" />

      //  mText = new MutableLiveData<>();
        //mText.setValue("This is queue fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}