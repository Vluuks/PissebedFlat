package com.example.depissebedflat.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.depissebedflat.R;
import com.example.depissebedflat.databinding.FragmentNotificationsBinding;
import com.example.depissebedflat.models.Pissebed;

import java.util.ArrayList;
import java.util.Arrays;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<Pissebed> pissebedden = this.initAllPissebedden();

        ListView lv = root.findViewById(R.id.listView);
        lv.setAdapter(new PissebeddenAdapter(this.getContext(), R.layout.row_item_pissebed, pissebedden));

        return root;
    }

    protected ArrayList<Pissebed> initAllPissebedden() {
        ArrayList<Pissebed> pissebedden = new ArrayList<>(Arrays.asList(
                new Pissebed("Schors", "Armadillidium Vulgare", "gray", 40),
                new Pissebed("Prissie", "Armadillidium Maculatum", "black and white", 8),
                new Pissebed("Joenko", "Porcello Scaber Lava", "red", 45),
                new Pissebed("Isobel", "Armadillidum Vulgare", "gray", 25),
                new Pissebed("Per", "Armadillidum Vulgare", "gray", 15)
                // blauw mr snuggles
        ));
        return pissebedden;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}