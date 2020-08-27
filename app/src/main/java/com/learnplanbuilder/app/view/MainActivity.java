package com.learnplanbuilder.app.view;
/**
 * Created by Sunil gowroji
 */

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;

import com.learnplanbuilder.app.model.LoginUser;
import com.learnplanbuilder.app.R;
import com.learnplanbuilder.app.databinding.ActivityMainBinding;
import com.learnplanbuilder.app.viewmodel.LoginViewModel;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        binding.setLifecycleOwner(this);

        binding.setLoginViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(@Nullable LoginUser loginUser) {

                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmailAddress())) {
                    binding.txtEmailAddress.setError("Enter an E-Mail Address");
                    binding.txtEmailAddress.requestFocus();
                } else if (!loginUser.isEmailValid()) {
                    binding.txtEmailAddress.setError("Enter a Valid E-mail Address");
                    binding.txtEmailAddress.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())) {
                    binding.txtPassword.setError("Enter a Password");
                    binding.txtPassword.requestFocus();
                } else if (!loginUser.isPasswordLengthGreaterThan5()) {
                    binding.txtPassword.setError("Enter at least 6 Digit password");
                    binding.txtPassword.requestFocus();
                } else {
                    //   binding.lblEmailAnswer.setText(loginUser.getStrEmailAddress());
                    //  binding.lblPasswordAnswer.setText(loginUser.getStrPassword());
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }

            }
        });

    }


}
