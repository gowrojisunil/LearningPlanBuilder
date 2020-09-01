package com.learnplanbuilder.app.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {FamilyMemberModel.class}, version = 1)
public abstract class FamilyMemberRoomDataBase extends RoomDatabase {
    public abstract FamilyMemberRoomDAO familyMemberRoomDAO();

    private static FamilyMemberRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static FamilyMemberRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FamilyMemberRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FamilyMemberRoomDataBase.class, "learning_plan_builder_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback =
            new Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    databaseWriteExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            // Populate the database in the background.
                            // If you want to start with more words, just add them.
//                            FamilyMemberRoomDAO dao = INSTANCE.familyMemberRoomDAO();
//                            dao.deleteAll();
                        }
                    });
                }
            };

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
