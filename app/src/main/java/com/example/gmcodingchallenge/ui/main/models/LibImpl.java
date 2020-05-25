package com.example.gmcodingchallenge.ui.main.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class LibImpl implements Lib {
    private List<Element> elements= new ArrayList<Element>();

    public LibImpl() {
        // mock 10 elements with 5 items each having between 10-30 seconds of handle time
        for (int i = 1; i <= 10; i++) {
            elements.add(new Element(i));
        }
    }

    public Observable<Element> getElementsObservable() {
        Stream<Element> stream = elements.stream();

        return Observable.fromIterable(() -> stream.iterator())
                .zipWith(Observable.interval(
                        0,
                        90000,
                        TimeUnit.MILLISECONDS), (item, interval) -> item);

    }

    public Single<List<Item>> queryElementForItems(Element ele) {
        return Single.just(ele.getItems());
    }
}
