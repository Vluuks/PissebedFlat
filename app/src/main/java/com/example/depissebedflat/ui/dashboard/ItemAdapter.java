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

        ImageView image = convertView.findViewById(R.id.picture_list);
        TextView text = convertView.findViewById(R.id.name_list);

        Item currentItem = itemList.get(position);
        image.setImageResource(currentItem.getDrawableId());
        text.setText(currentItem.getName());

        return convertView;
    }
}
