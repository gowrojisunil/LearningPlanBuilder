package com.learnplanbuilder.app.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FamilyMemberRoomDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FamilyMemberModel familyMemberModel);

//    @Query("SELECT * FROM family_members ORDER BY uid ASC")
//    LiveData<List<FamilyMemberModel>> getAllFamilyMembers();

    @Query("SELECT * FROM family_members")
    LiveData<List<FamilyMemberModel>> getAllFamilyMembers();

    @Query("DELETE FROM family_members")
    void deleteAll();
}