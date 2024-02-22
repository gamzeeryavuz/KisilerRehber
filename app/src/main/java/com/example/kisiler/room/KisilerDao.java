package com.example.kisiler.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kisiler.data.Kisiler;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface KisilerDao {
    @Query("SELECT *FROM kisiler")
    Single<List<Kisiler>> kisileriYukle(); // bu yükle sayesinde verileri asenkron bir şekilde okumuş olacagız.


    @Insert
    Completable kaydet(Kisiler kisi);

    @Update
    Completable guncelle(Kisiler kisi);

    @Delete
    Completable  sil(Kisiler kisi);


    @Query("SELECT *FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%' ")
    Single<List<Kisiler>> ara(String aramaKelimesi);



}
