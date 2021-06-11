package com.example.depissebedflat.models;

/*
    A class depicting a plant of a certain type and size, and the color of the pot it is in.
*/
public class Pissebed {

    private String name;
    private String species;
    private String color;
    private int size;

    public Pissebed(String name, String species, String color, int size) {
        this.name = name;
        this.species = species;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}