package com.pn.pagedemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Student.class,version = 1)
public abstract class StudentDataBase extends RoomDatabase {
    private static StudentDataBase INSTANCE;
    public static synchronized StudentDataBase getDatabase(Context context){
        if (INSTANCE==null){
            /**
             * 这里getApplicationContext()是为了配合View-Model继承Andriod-View-Model中的哪个Application
             */
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),StudentDataBase.class,"WordDataBase")
                    .build();
        }
        return INSTANCE;
    }
    public abstract StudentDao getStudentDao();
}
