package com.adiyusuf.foxidea.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewmodel extends ViewModel {
    private MutableLiveData<String> mText;

    public MainActivityViewmodel() {
    }

    public void setText(String title) {
        mText = new MutableLiveData<>();
        mText.setValue(title);
    }

    public LiveData<String> getText() {
        return mText;
    }
}
