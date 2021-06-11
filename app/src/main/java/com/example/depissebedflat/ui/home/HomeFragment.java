package com.example.depissebedflat.ui.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        SharedPreferences prefs = getContext().getSharedPreferences("settings", MODE_PRIVATE);
//        prefs.edit().clear().commit();


        ArrayList<Item> currentItems = getPresentItems();
        ArrayList<Pissebed> currentPissebedden = getPresentPissebedden(currentItems);

        for (Item i : currentItems) {
            if (i.isOwned()) {
                ((ImageView) root.findViewById(i.getImageViewId())).setVisibility(View.VISIBLE);
            }
        }

        for (Pissebed p : currentPissebedden) {
            ((ImageView) root.findViewById(p.getImageViewId())).setVisibility(View.VISIBLE);
        }

        return root;
    }

    public ArrayList<Item> getPresentItems() {

        SharedPreferences prefs = getContext().getSharedPreferences("settings", MODE_PRIVATE);
        ArrayList<Item> items = Item.getAllItems();
        ArrayList<Item> presentItems = new ArrayList<Item>();


        for(Item i : items) {
            boolean isOwned = prefs.getBoolean(i.getName(), false);
            i.setOwned(isOwned);

            if (isOwned) {
                presentItems.add(i);
            }
        }

        return presentItems;
    }

    public ArrayList<Pissebed> getPresentPissebedden(ArrayList<Item> items) {
        ArrayList<Pissebed> pissebedden = Pissebed.getAllPissebedden();
        ArrayList<Pissebed> presentPissebedden = new ArrayList<Pissebed>();

        for (Pissebed p : pissebedden) {
            if (p.requirementsMet(items)) {
                Log.d("pissebed--true", "true");
                presentPissebedden.add(p);
            }
        }

        Log.d("pissebed--true", presentPissebedden.toString());
        return presentPissebedden;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}