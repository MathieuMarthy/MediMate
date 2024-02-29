package com.example.mms.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mms.model.Doctor

@Dao
interface DoctorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(doctor: Doctor)

    @Query("DELETE FROM doctor")
    fun delete()

    @Query("SELECT * FROM doctor LIMIT 1")
    fun get(): Doctor?
}
