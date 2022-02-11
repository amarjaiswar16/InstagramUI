package com.example.instagramclone.ui.bottom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.instagramclone.R;
import com.example.instagramclone.databinding.FragmentHomeBinding;
import com.example.instagramclone.ui.home.HomeViewModel;

public class SearchFragment extends Fragment {
    private SearchViewModel searchViewModel;
    private FragmentHomeBinding binding;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.search,container,false);
//        return view;
        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
