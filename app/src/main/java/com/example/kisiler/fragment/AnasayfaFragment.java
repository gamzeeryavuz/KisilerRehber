package com.example.kisiler.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.kisiler.R;
import com.example.kisiler.adapter.KisilerAdapter;
import com.example.kisiler.data.Kisiler;
import com.example.kisiler.databinding.FragmentAnasayfaBinding;
import com.example.kisiler.ui.viewmodel.AnasayfaViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel  viewModel;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =FragmentAnasayfaBinding.inflate(inflater,container,false);

        binding.toolbar.setTitle("Kisiler");

        binding.rv.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.kisilerListesi.observe(getViewLifecycleOwner(),kisilerListesi ->{
            KisilerAdapter kisilerAdapter=new KisilerAdapter(requireContext(),kisilerListesi);
            binding.rv.setAdapter(kisilerAdapter);
        });


        binding.fab.setOnClickListener(view ->{
            Navigation.findNavController(view).navigate(R.id.kisikayitgecis);

        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // klavye arama butonunda çalışan metot
                viewModel.ara(s);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                viewModel.ara(s);

                return true;
            }
        });
        return binding.getRoot();





    }
    // anasayfada live data işlemi olucak


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel=new ViewModelProvider(this).get(AnasayfaViewModel.class);

    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.kisileriYukle();

    }
}