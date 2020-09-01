package com.learnplanbuilder.app.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.learnplanbuilder.app.R;
import com.learnplanbuilder.app.databinding.AddFamilyMemberBinding;
import com.learnplanbuilder.app.model.AddFamilyMember;
import com.learnplanbuilder.app.viewmodel.AddFamilyViewModel;

import java.util.Objects;

public class AddFamilyMemberActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final AddFamilyViewModel addFamilyViewModel = ViewModelProviders.of(this).get(AddFamilyViewModel.class);

        final AddFamilyMemberBinding binding = DataBindingUtil.setContentView(AddFamilyMemberActivity.this, R.layout.add_family_member);

        binding.setLifecycleOwner(this);

        binding.setAddFamilyViewModel(addFamilyViewModel);

        addFamilyViewModel.getFamilyMember().observe(this, new Observer<AddFamilyMember>() {
            @Override
            public void onChanged(@Nullable AddFamilyMember addFamilyMember) {

                assert addFamilyMember != null;
                if (TextUtils.isEmpty(Objects.requireNonNull(addFamilyMember).getFirstName())) {
                    binding.firstNameTV.requestFocus();
                    showToast("Enter First Name");
                } else if (TextUtils.isEmpty(Objects.requireNonNull(addFamilyMember).getLastName())) {
                    binding.lastNameTV.requestFocus();
                    showToast("Enter Last Name");
                } else if (TextUtils.isEmpty(Objects.requireNonNull(addFamilyMember).getPhoneNumber())) {
                    binding.phoneNumberTV.requestFocus();
                    showToast("Enter Phone Number");
                } else if (addFamilyMember.getPhoneNumber().length() != 10) {
                    binding.phoneNumberTV.requestFocus();
                    showToast("Enter Phone Number");
                } else if (TextUtils.isEmpty(Objects.requireNonNull(addFamilyMember).getEmailID())) {
                    binding.emailIDTV.requestFocus();
                    showToast("Enter Valid E-mail Address");
                } else if (!addFamilyMember.isEmailValid()) {
                    binding.emailIDTV.requestFocus();
                    showToast("Enter Valid E-mail Address");
                } else {
                    addFamilyViewModel.saveFamilyMember(addFamilyMember);
                    Intent intent = new Intent(AddFamilyMemberActivity.this, ViewFamilyMembersActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void saveFamilyMember(AddFamilyMember addFamilyMember) {

    }

    private void showToast(String toastMessage) {
        Toast toast = Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG);
        TextView v = toast.getView().findViewById(android.R.id.message);
        toast.getView().setBackgroundColor(getResources().getColor(R.color.black_overlay));
        v.setTextColor(Color.WHITE);
        v.setTextSize(20);
        toast.show();
    }
}
