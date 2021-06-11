package com.example.depissebedflat.models;

import com.example.depissebedflat.R;

import java.util.ArrayList;
import java.util.Arrays;

/*
    A class depicting a plant of a certain type and size, and the color of the pot it is in.
*/
public class Pissebed {

    private static ArrayList<Pissebed> pissebedden;

    private String name;
    private String species;
    private String color;
    private int size;

    private int drawableId;
    private int imageViewId;

    // Determine what items are liked by this pissebed
    // Construct happiness bar based on amount of liked items
    // There is also a required item you need before they come at all!

    private ArrayList<Item> likedItems;
    private Item requiredItem;

    public Pissebed(String name, String species, String color, int size, Item requiredItem, int drawableId, int imageViewId) {
        this.name = name;
        this.species = species;
        this.color = color;
        this.size = size;
        this.requiredItem = requiredItem;

        this.drawableId = drawableId;
        this.imageViewId = imageViewId;
    }

    public static ArrayList<Pissebed> getAllPissebedden() {
        if (pissebedden == null) {
            ArrayList<Item> allItems = Item.getAllItems();
            pissebedden = new ArrayList<>(Arrays.asList(
                    new Pissebed("Schors", "Armadillidium Vulgare", "gray", 40, allItems.get(1), R.drawable.schors, R.id.schorsImage),
                    new Pissebed("Prissie", "Armadillidium Maculatum", "black and white", 8, allItems.get(3), R.drawable.prissie, R.id.prissieImage),
                    new Pissebed("Joenko", "Porcello Scaber Lava", "red", 45, allItems.get(6), R.drawable.joenko, R.id.joenkoImage),
                    new Pissebed("Isobel", "Armadillidum Vulgare", "gray", 25, allItems.get(4), R.drawable.isobel, R.id.isobelImage),
                    new Pissebed("Per", "Armadillidum Vulgare", "gray", 15, allItems.get(5), R.drawable.per, R.id.perImage),
                    new Pissebed("Barkie", "Cubaris", "green", 40, allItems.get(2), R.drawable.barkie, R.id.barkieImage),
                    new Pissebed("Amber", "Cubaris Amber", "yellow", 40, allItems.get(0), R.drawable.amber, R.id.amberImage)
            ));
        }
        return pissebedden;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Item> getLikedItems() {
        return likedItems;
    }

    public Item getRequiredItem() {
        return requiredItem;
    }

    public Boolean likesItem(Item item) {
        return this.likedItems.contains(item);
    }

    public Boolean requirementsMet(ArrayList<Item> itemsPresent) {
        if (this.requiredItem != null) {
            return itemsPresent.contains(this.requiredItem);
        }
        // We require nothing so requirement is met
        return true;
    }
}