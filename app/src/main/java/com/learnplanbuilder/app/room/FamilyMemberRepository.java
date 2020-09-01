package com.learnplanbuilder.app.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FamilyMemberRepository {
    private FamilyMemberRoomDAO mFamilyMemberDao;
    private LiveData<List<FamilyMemberModel>> mAllFamilyMembers;

    public FamilyMemberRepository(Application application) {
        FamilyMemberRoomDataBase db = FamilyMemberRoomDataBase.getDatabase(application);
        mFamilyMemberDao = db.familyMemberRoomDAO();
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(final FamilyMemberModel familyMemberModel) {
        FamilyMemberRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mFamilyMemberDao.insert(familyMemberModel);
            }
        });
    }

    public LiveData<List<FamilyMemberModel>> getFamilyMembersFromDB() {
//        FamilyMemberRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
        mAllFamilyMembers = mFamilyMemberDao.getAllFamilyMembers();
//            }
//        });
        return mAllFamilyMembers;
    }
}
