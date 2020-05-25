package com.example.gmcodingchallenge;

import com.example.gmcodingchallenge.ui.main.models.Element;
import com.example.gmcodingchallenge.ui.main.models.LibImpl;

import org.junit.Assert;
import org.junit.Test;

public class LibImplTest {
    @Test
    public void init_isCorrect() {
        LibImpl lib = new LibImpl();
        Assert.assertNotNull(lib.getElementsObservable());
        Assert.assertNotNull(lib.queryElementForItems(new Element(1)));
    }
}