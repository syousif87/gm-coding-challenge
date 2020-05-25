package com.example.gmcodingchallenge;

import com.example.gmcodingchallenge.ui.main.models.Element;
import com.example.gmcodingchallenge.ui.main.models.LibImpl;
import com.example.gmcodingchallenge.ui.main.util.ItemProcessor;

import org.junit.Assert;
import org.junit.Test;

public class ItemProcessorTest {

    @Test
    public void init_isCorrect() {
        ItemProcessor processor = new ItemProcessor();
        LibImpl lib = new LibImpl();
        Element ele = new Element(1);
        processor.processElement(ele, lib.queryElementForItems(ele));
        Assert.assertNotNull(processor.getProcessedObservable());
    }
}