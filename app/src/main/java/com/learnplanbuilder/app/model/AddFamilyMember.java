package com.learnplanbuilder.app.model;

import android.util.Patterns;

public class AddFamilyMember {

    private String firstName;
    private String lastName;
    private String emailID;
    private String phoneNumber;
    private String gender;
    private String relationWithHOF;

    public AddFamilyMember(String firstName, String lastName, String gender, String phoneNumber, String emailID, String relationWithHOF) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.relationWithHOF = relationWithHOF;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getRelationWithHOF() {
        return relationWithHOF;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmailID()).matches();
    }

}
