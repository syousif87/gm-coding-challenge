package com.example.gmcodingchallenge.ui.main.models;

import java.util.ArrayList;
import java.util.List;

public class Element {
    private int id;
    private List<Item> items = new ArrayList<>();

    public Element(Integer id) {
        this.id = id;

        for (int i = 1; i <= 5; i++) {
            items.add(new Item(i));
        }
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }
}
