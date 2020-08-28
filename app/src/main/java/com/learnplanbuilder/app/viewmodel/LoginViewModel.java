package com.learnplanbuilder.app.viewmodel;
/**
 * Created by Sunil gowroji
 */

import androidx.lifecycle.MutableLiveData ;
import androidx.lifecycle.ViewModel;

import android.view.View;

import com.learnplanbuilder.app.model.LoginUser;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    private MutableLiveData<LoginUser> userMutableLiveData;

    public MutableLiveData<LoginUser> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void onClick(View view) {

        LoginUser loginUser = new LoginUser(EmailAddress.getValue(), Password.getValue());

        userMutableLiveData.setValue(loginUser);



    }

}
