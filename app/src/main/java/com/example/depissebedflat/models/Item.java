package com.example.depissebedflat.models;

import com.example.depissebedflat.models.Pissebed;

import java.util.ArrayList;

public class Item {

    private String name;
    private String description;
    private int drawableId;
    private int price;

    public Item(String name, String description, int drawableId, int price) {
        this.name = name;
        this.description = description;
        this.drawableId = drawableId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
