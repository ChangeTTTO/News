package com.pn.pagedemo;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface StudentDao {
    @Insert
    void insertStudent(Student...students);
    @Query("DELETE FROM Student")
    void deleteAllStudent();
    @Query("SELECT * FROM student ORDER BY id")
    DataSource.Factory<Integer,Student> getAllStudents();

}
