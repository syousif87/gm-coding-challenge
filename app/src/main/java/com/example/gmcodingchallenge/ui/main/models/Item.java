package com.example.gmcodingchallenge.ui.main.models;

import java.util.concurrent.ThreadLocalRandom;

public class Item {
    private int id;
    private int processTime;

    public Item(int id) {
        this.id = id;
        processTime = ThreadLocalRandom.current().nextInt(10, 31);
    }

    public int getId() {
        return id;
    }

    public int handle() {
        return processTime;
    }
}
