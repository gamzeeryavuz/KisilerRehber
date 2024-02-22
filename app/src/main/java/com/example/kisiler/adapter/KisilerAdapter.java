package com.example.kisiler.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisiler.data.Kisiler;
import com.example.kisiler.databinding.CardTasarimBinding;
import com.example.kisiler.fragment.AnasayfaFragmentDirections;
import com.example.kisiler.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>{

    private Context mContext;
    private List<Kisiler> kisilerListesi;

    private  AnasayfaViewModel viewModel;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerListesi) {
        this.mContext = mContext;
        this.kisilerListesi = kisilerListesi;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {   
        
        CardTasarimBinding binding=CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardTasarimTutucu(binding);
        
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) { 
        Kisiler kisi=kisilerListesi.get(position);
        CardTasarimBinding t=holder.tasarim;
        
        t.kisiad.setText(kisi.getKisi_ad());
        t.kisitel.setText(kisi.getKisi_tel()); 
        
        t.cardviewsatir.setOnClickListener(view -> {
            AnasayfaFragmentDirections.Kisidetaygecis gecis=AnasayfaFragmentDirections.kisidetaygecis(kisi);
            Navigation.findNavController(view).navigate(gecis);

            
        }); 
        
        t.imageViewSil.setOnClickListener(view ->{
            Snackbar.make(view,kisi.getKisi_ad()+"Silinsin mi ?" ,Snackbar.LENGTH_SHORT).setAction("EVET",view1 -> {

                sil(kisi.getKisi_id());

            }).show();


            
        });

    }

    @Override
    public int getItemCount() {
        return kisilerListesi.size();
        
    }

    public void sil(int kisi_id){
        Log.e("Kişi Sil " , String.valueOf(kisi_id));

    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu( CardTasarimBinding tasarim) {
          super(tasarim.getRoot());

            this.tasarim = tasarim;
        }
    }

}
