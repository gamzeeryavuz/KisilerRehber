package com.example.kisiler.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisiler.data.Kisiler;
import com.example.kisiler.room.KisilerDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class KisilerDaoRepository {
    public MutableLiveData<List<Kisiler>> kisilerListesi=new MutableLiveData<>();
    private KisilerDao kdao;

    public KisilerDaoRepository(KisilerDao kdao){
        this.kdao=kdao;


    }



    public void kaydet(String kisi_ad,String kisi_tel){
        Kisiler yeniKisi=new Kisiler(0,kisi_ad,kisi_tel);
        kdao.kaydet(yeniKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onComplete() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }

    public void guncellle(int kisi_id,String kisi_ad,String kisi_tel){
       Kisiler guncellenenKisi=new Kisiler(0,kisi_ad,kisi_tel);
       kdao.guncelle(guncellenenKisi).subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new CompletableObserver() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onComplete() {

                   }

                   @Override
                   public void onError(Throwable e) {

                   }
               });

    }

    public void ara(String aramaKelimesi){
        kdao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        // success olunca çalışan yapı
                        kisilerListesi.setValue(kisilers);
                    }
                    @Override
                    public void onError(Throwable e) { // hata olduğunda çalışan yapı


                    }
                });


    }
    public void sil(int kisi_id){

        Kisiler silinenKisi=new Kisiler(0,"","");
        kdao.sil(silinenKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        kisileriYukle();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
    public void kisileriYukle(){
      kdao.kisileriYukle().subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new SingleObserver<List<Kisiler>>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }
                  @Override
                  public void onSuccess(List<Kisiler> kisilers) {
                      // success olunca çalışan yapı
                     kisilerListesi.setValue(kisilers);
                  }
                  @Override
                  public void onError(Throwable e) { // hata olduğunda çalışan yapı


                  }
              });

    }



}
