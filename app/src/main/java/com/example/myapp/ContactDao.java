package com.example.myapp;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ContactDao {
    @Query("DELETE FROM contact WHERE idx = :idx")
    void delete(int idx);

    @Query("SELECT * FROM contact")
    List<ContactEntity> getAllContact();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ContactEntity contact);

    @Update
    void update(ContactEntity contact);

    // 데이터가 존재하는지 확인하는 메서드
    @Query("SELECT COUNT(*) FROM contact")
    int getContactCount();
}