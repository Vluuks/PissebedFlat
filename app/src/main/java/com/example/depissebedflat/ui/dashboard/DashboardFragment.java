package com.example.depissebedflat.ui.dashboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.depissebedflat.R;
import com.example.depissebedflat.databinding.FragmentDashboardBinding;
import com.example.depissebedflat.models.Item;
import com.example.depissebedflat.ui.notifications.PissebeddenAdapter;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private ItemAdapter ia;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<Item> items = Item.getAllItems();

        // Set ownership
        SharedPreferences prefs = getContext().getSharedPreferences("settings", MODE_PRIVATE);

        for(Item i : items) {
            boolean isOwned = prefs.getBoolean(i.getName(), false);
            i.setOwned(isOwned);
        }

        GridView gv = root.findViewById(R.id.gridView);


        ia = new ItemAdapter(this.getContext(), R.layout.grid_item_item, items);
        gv.setAdapter(ia);

        AdapterView.OnItemClickListener listener = new OnItemClickListenerGrid();
        gv.setOnItemClickListener(listener);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private class OnItemClickListenerGrid implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Item currentItem = (Item) adapterView.getItemAtPosition(i);
            currentItem.setOwned(true);

            SharedPreferences prefs = getContext().getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(currentItem.getName(), true);
            editor.apply();

            ia.notifyDataSetChanged();
        }
    }
}