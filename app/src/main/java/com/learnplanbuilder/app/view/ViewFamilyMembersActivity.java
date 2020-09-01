package com.learnplanbuilder.app.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.toptas.fancyshowcase.FancyShowCaseView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.learnplanbuilder.app.R;
import com.learnplanbuilder.app.adapter.FamilyMembersViewAdapter;
import com.learnplanbuilder.app.room.FamilyMemberModel;
import com.learnplanbuilder.app.viewmodel.AddFamilyViewModel;

import java.util.List;

public class ViewFamilyMembersActivity extends AppCompatActivity {
    private static boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family_members);

        if (!flag) {
            flag = true;
            new FancyShowCaseView.Builder(this)
                    .focusOn(findViewById(R.id.floatingActionButton2))
                    .title(getResources().getString(R.string.add))
                    .titleStyle(R.style.MyTitleStyle, Gravity.BOTTOM)
                    .focusBorderColor(Color.GREEN)
                    .focusBorderSize(5)
                    .build()
                    .show();
        }
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewFamilyMembersActivity.this, AddFamilyMemberActivity.class);
                startActivity(intent);
                finish();
            }
        });

        final RecyclerView familyMembersRCV = findViewById(R.id.family_members_RCV);
        AddFamilyViewModel familyMemberModel = new AddFamilyViewModel(this.getApplication());
        final FamilyMembersViewAdapter familyMembersViewAdapter = new FamilyMembersViewAdapter(ViewFamilyMembersActivity.this);
        familyMemberModel.getFamilyMembers().observe(this, new Observer<List<FamilyMemberModel>>() {
            @Override
            public void onChanged(@Nullable final List<FamilyMemberModel> words) {
                familyMembersRCV.setAdapter(familyMembersViewAdapter);
                familyMembersRCV.setLayoutManager(new LinearLayoutManager(ViewFamilyMembersActivity.this));
                familyMembersViewAdapter.setData(words);
            }
        });
    }
}
