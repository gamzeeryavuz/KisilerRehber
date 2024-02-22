package com.example.kisiler.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisiler.R;
import com.example.kisiler.data.Kisiler;
import com.example.kisiler.databinding.FragmentAnasayfaBinding;
import com.example.kisiler.databinding.FragmentKisiDetayBinding;
import com.example.kisiler.ui.viewmodel.AnasayfaViewModel;
import com.example.kisiler.ui.viewmodel.KisiDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiDetayFragment extends Fragment {

    private FragmentKisiDetayBinding binding;
    private KisiDetayViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding =FragmentKisiDetayBinding.inflate(inflater,container,false);

        binding.toolbarkisidetay.setTitle("Kisi Detay");

        KisiDetayFragmentArgs bundle =KisiDetayFragmentArgs.fromBundle(getArguments());
        Kisiler gelenKisi=bundle.getKisi();

        binding.editTextKisiAd.setText(gelenKisi.getKisi_ad());
        binding.editTextKisiTel.setText(gelenKisi.getKisi_tel());


        binding.butongNcelle.setOnClickListener(view -> {
            String kisi_ad=binding.editTextKisiAd.getText().toString();
            String kisi_tel=binding.editTextKisiTel.getText().toString();

            guncellle(gelenKisi.getKisi_id(),kisi_ad,kisi_tel);



        });


        return binding.getRoot();



    }

    public void guncellle(int kisi_id,String kisi_ad,String kisi_tel){
        Log.e("Kisi güncelle",kisi_id+" - "+"kisi_ad" +" - "+"kisi_tel");

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel=new ViewModelProvider(this).get(KisiDetayViewModel.class);

    }
}