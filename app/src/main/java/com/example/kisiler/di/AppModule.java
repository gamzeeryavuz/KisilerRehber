package com.example.kisiler.di;

import android.content.Context;

import androidx.room.Room;

import com.example.kisiler.data.repo.KisilerDaoRepository;
import com.example.kisiler.room.KisilerDao;
import com.example.kisiler.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public KisilerDaoRepository provideKisilerDaoRepository(KisilerDao kdao){

        return new KisilerDaoRepository(kdao);

    }
    @Provides
    @Singleton
    public KisilerDao provideKisilerKisilerDao(@ApplicationContext Context context){
        Veritabani vt= Room.databaseBuilder(context,Veritabani.class,"rehber.sqlite").createFromAsset("rehber.sqlite").build();
        // hem kopyalama hem erişim yapıcak

        return vt.getKisilerDao();

    }

}
