package com.example.gmcodingchallenge.ui.main.models;

import java.util.ArrayList;
import java.util.List;

public class Element {
    public Integer id;
    private List<Item> items = new ArrayList<Item>();

    public Element(Integer id) {
        this.id = id;
        items.add(new Item());
        items.add(new Item());
        items.add(new Item());
        items.add(new Item());
        items.add(new Item());
    }

    public List<Item> getItems() {
        return items;
    }
}
