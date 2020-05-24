package com.example.gmcodingchallenge.ui.main.models;

import java.util.concurrent.ThreadLocalRandom;

public class Item {

    public Item() {

    }

    public int handle() {
        int processTime = ThreadLocalRandom.current().nextInt(10, 31);
        return processTime;
    }
}
