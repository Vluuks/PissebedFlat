package com.example.depissebedflat.models;

import com.example.depissebedflat.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Item {

    private static ArrayList<Item> items;
    private String name;
    private String description;
    private int drawableId;
    private int price;
    private boolean owned;
    private int imageViewId;

    public Item(String name, String description, int drawableId, int imageViewId, int price, boolean owned) {
        this.name = name;
        this.description = description;
        this.drawableId = drawableId;
        this.imageViewId = imageViewId;
        this.price = price;
        this.owned = owned;
    }

    public static ArrayList<Item> getAllItems() {
        if (items == null) {
            items = new ArrayList<>(Arrays.asList(
                    // Drawable id here is the drawable for listview, not main view
                    new Item("Bank", "Handig als je ergens lekker wil chillen", R.drawable.bank, R.id.bankImage, 1000, true),
                    new Item("Kleed", "Voor pissebedden die graag op de grond zitten", R.drawable.rug, R.id.rugImage, 200, false),
                    new Item("Plant", "Ook handig om onder te schuilen", R.drawable.plant, R.id.plantImage, 80, false),
                    new Item("Voetbal", "Sommige pissebedden zijn dol op voetbal", R.drawable.voetbal, R.id.ballImage, 50, false),
                    new Item("Gewicht", "Voor de gains!!!!", R.drawable.dumbbell, R.id.dumbbellImage, 160, false),
                    new Item("Chips", "Krokante blaadjes", R.drawable.chips, R.id.chipsImage, 20, false),
                    new Item("Appel", "Voor de gezonde trek", R.drawable.appel, R.id.appelImage, 10, false)
            ));
        }
        return items;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public int getPrice() {
        return price;
    }

    public int getImageViewId() {
        return imageViewId;
    }

    public boolean isOwned() {
        return owned;
    }
}
