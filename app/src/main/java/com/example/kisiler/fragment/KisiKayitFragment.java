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
import com.example.kisiler.databinding.FragmentAnasayfaBinding;
import com.example.kisiler.databinding.FragmentKisiKayitBinding;
import com.example.kisiler.ui.viewmodel.AnasayfaViewModel;
import com.example.kisiler.ui.viewmodel.KisiKayıtViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiKayitFragment extends Fragment {


    private FragmentKisiKayitBinding binding;

    private KisiKayıtViewModel viewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =FragmentKisiKayitBinding.inflate(inflater,container,false);

        binding.toolbarkisikayit.setTitle("Kisi Kayıt ");

        binding.kaydet.setOnClickListener(view -> {
            String kisi_ad=binding.editTextKisiAd.getText().toString();
            String kisi_tel=binding.editTextKisiTel.getText().toString();

           viewModel.kaydet(kisi_ad,kisi_tel);




        });
        return binding.getRoot();



    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel=new ViewModelProvider(this).get(KisiKayıtViewModel.class);

    }
}