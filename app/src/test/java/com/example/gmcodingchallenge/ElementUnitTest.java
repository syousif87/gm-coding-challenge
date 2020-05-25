package com.example.gmcodingchallenge;

import com.example.gmcodingchallenge.ui.main.models.Element;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementUnitTest {
    @Test
    public void init_isCorrect() {
        Element ele = new Element(1);
        assertEquals(1, ele.getId());
        assertEquals(5, ele.getItems().size());
    }
}
