package com.example.depissebedflat.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.depissebedflat.R;
import com.example.depissebedflat.models.Pissebed;

import java.util.List;

public class PissebeddenAdapter extends ArrayAdapter {

    private List pissebedden;

    public PissebeddenAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        // Make scope classwide
        pissebedden = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // A new view must be inflated
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item_pissebed, parent, false);
        }

        // Access the right object in the list
        Pissebed currentPissebed = (Pissebed) pissebedden.get(position);


        // Make changes to the convertView, such as displaying a certain text
        ((TextView) convertView.findViewById(R.id.pissebedName)).setText(currentPissebed.getName());

        // Return the altered convertview
        return convertView;
    }
}