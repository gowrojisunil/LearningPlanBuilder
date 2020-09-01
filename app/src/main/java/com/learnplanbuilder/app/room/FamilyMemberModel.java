package com.learnplanbuilder.app.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

//@Entity(tableName = "family_members")
@Entity(tableName = "family_members", indices = {@Index(value = {"firstName", "lastName"},
        unique = true)})
public class FamilyMemberModel {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "firstName")
    private String firstName;

    @ColumnInfo(name = "lastName")
    private String lastName;

    @ColumnInfo(name = "emailID")
    private String emailID;

    @ColumnInfo(name = "phoneNumber")
    private String phoneNumber;

    @ColumnInfo(name = "gender")
    private String gender;

    @ColumnInfo(name = "relationWHOF")
    private String relationWHOF;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationWHOF() {
        return relationWHOF;
    }

    public void setRelationWHOF(String relationWHOF) {
        this.relationWHOF = relationWHOF;
    }

}
