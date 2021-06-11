package com.example.depissebedflat.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.depissebedflat.R;
import com.example.depissebedflat.databinding.FragmentHomeBinding;
import com.example.depissebedflat.models.Item;
import com.example.depissebedflat.models.Pissebed;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private ArrayList<Item> itemsOwned;
    private ArrayList<Pissebed> pissebeddenPresent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public ArrayList<Pissebed> getPresentPissebedden(ArrayList<Item> items) {
        ArrayList<Pissebed> pissebedden = Pissebed.getAllPissebedden();
        ArrayList<Pissebed> presentPissebedden = new ArrayList<Pissebed>();

        for (Pissebed p : pissebedden) {
            if (p.requirementsMet(items)) {
                presentPissebedden.add(p);
            }
        }
        return presentPissebedden;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}