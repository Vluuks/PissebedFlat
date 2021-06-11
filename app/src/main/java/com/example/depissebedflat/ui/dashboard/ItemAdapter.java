package com.example.depissebedflat.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.depissebedflat.R;
import com.example.depissebedflat.models.Item;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter {

    ArrayList<Item> itemList;

    public ItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item> objects) {
        super(context, resource, objects);
        itemList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item_item, parent, false);
        }

        ImageView image = convertView.findViewById(R.id.itemPicture);
        TextView text = convertView.findViewById(R.id.nameText);
        TextView description = convertView.findViewById(R.id.descriptionText);
        TextView owned = convertView.findViewById(R.id.ownedText);

        Item currentItem = itemList.get(position);
        image.setImageResource(currentItem.getDrawableId());
        text.setText(currentItem.getName());
        description.setText(currentItem.getDescription());

        if (currentItem.isOwned()) {
            owned.setText("Dit item heb je!");
        }
        else {
            owned.setText("Je hebt dit item nog niet");
        }
        return convertView;
    }
}
