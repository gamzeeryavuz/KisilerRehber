package com.example.kisiler.ui.viewmodel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.kisiler.data.repo.KisilerDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KisiKayıtViewModel  extends ViewModel {

    public KisilerDaoRepository krepo;

    @Inject
    public KisiKayıtViewModel(KisilerDaoRepository krepo){
        this.krepo=krepo;
    }

     public void kaydet(String kisi_ad,String kisi_tel){
         krepo.kaydet(kisi_ad,kisi_tel);

     }





}
