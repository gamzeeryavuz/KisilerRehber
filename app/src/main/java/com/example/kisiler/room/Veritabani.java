package com.example.kisiler.room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.kisiler.data.Kisiler;

@Database(entities = {Kisiler.class},version = 1)// kaç tane tablo varsa her tabloya bir tane class oluşturmanız gerekiyor.

public abstract  class Veritabani  extends RoomDatabase {

    public abstract KisilerDao getKisilerDao();




}
