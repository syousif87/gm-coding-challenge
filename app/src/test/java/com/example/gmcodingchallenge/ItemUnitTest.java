package com.example.gmcodingchallenge;

import com.example.gmcodingchallenge.ui.main.models.Item;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemUnitTest {
    @Test
    public void init_isCorrect() {
        Item item = new Item(1);
        assertEquals(1, item.getId());
        Assert.assertTrue(item.handle() <= 30);
        Assert.assertTrue(item.handle() >= 10);
    }
}
