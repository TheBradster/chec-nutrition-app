package com.example.checnutritionapp.ui.your_week;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class YourWeekViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public YourWeekViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Plan your week!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}