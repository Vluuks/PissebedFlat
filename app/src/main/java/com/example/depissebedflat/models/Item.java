package com.example.depissebedflat.models;

public class Item {

    private String name;
    private String description;
    private int drawableId;
    private int price;
    private boolean owned;

    public Item(String name, String description, int drawableId, int price, boolean owned) {
        this.name = name;
        this.description = description;
        this.drawableId = drawableId;
        this.price = price;
        this.owned = owned;
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

    public int getPrice() {
        return price;
    }

    public boolean isOwned() {
        return owned;
    }
}
