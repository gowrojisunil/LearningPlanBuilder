package com.learnplanbuilder.app.viewmodel;

import android.app.Application;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.learnplanbuilder.app.model.AddFamilyMember;
import com.learnplanbuilder.app.room.FamilyMemberModel;
import com.learnplanbuilder.app.room.FamilyMemberRepository;

import java.util.List;

public class AddFamilyViewModel extends AndroidViewModel {

    public MutableLiveData<String> firstName = new MutableLiveData<>();
    public MutableLiveData<String> lastName = new MutableLiveData<>();
    public MutableLiveData<String> gender = new MutableLiveData<>();
    public MutableLiveData<String> emailID = new MutableLiveData<>();
    public MutableLiveData<String> phoneNumber = new MutableLiveData<>();
    public MutableLiveData<String> relationWithHOF = new MutableLiveData<>();

    private MutableLiveData<AddFamilyMember> addFamilyMemberMutableLiveData;
    private FamilyMemberRepository familyMemberRepository;
    private LiveData<List<FamilyMemberModel>> familyMembers;


    public AddFamilyViewModel(@NonNull Application application) {
        super(application);
        familyMemberRepository = new FamilyMemberRepository(application);
    }

    public MutableLiveData<AddFamilyMember> getFamilyMember() {

        if (addFamilyMemberMutableLiveData == null) {
            addFamilyMemberMutableLiveData = new MutableLiveData<>();
        }
        return addFamilyMemberMutableLiveData;

    }

    public void onMaleButtonClicked() {
        gender.setValue("male");
    }

    public void onFemaleButtonClicked() {
        gender.setValue("female");
    }

    public void onSelectItem(AdapterView<?> parent, View view, int pos, long id) {
        parent.getSelectedItem();
        relationWithHOF.setValue(parent.getSelectedItem().toString());
    }

    public void saveFamilyMember(AddFamilyMember selectedFamilyMember) {

        FamilyMemberModel familyMemberModel = new FamilyMemberModel();

        familyMemberModel.setUid(1);

        familyMemberModel.setEmailID(selectedFamilyMember.getEmailID());

        familyMemberModel.setFirstName(selectedFamilyMember.getFirstName());

        familyMemberModel.setLastName(selectedFamilyMember.getLastName());

        familyMemberModel.setPhoneNumber(selectedFamilyMember.getPhoneNumber());

        familyMemberModel.setGender(selectedFamilyMember.getGender());

        familyMemberModel.setRelationWHOF(selectedFamilyMember.getRelationWithHOF());

        familyMemberRepository.insert(familyMemberModel);
    }

    public void onClick(View view) {
        AddFamilyMember addFamilyMember = new AddFamilyMember(firstName.getValue(), lastName.getValue(), gender.getValue(), phoneNumber.getValue(), emailID.getValue(), relationWithHOF.getValue());
        addFamilyMemberMutableLiveData.setValue(addFamilyMember);
    }

    public LiveData<List<FamilyMemberModel>> getFamilyMembers() {

        return familyMemberRepository.getFamilyMembersFromDB();
    }
}
