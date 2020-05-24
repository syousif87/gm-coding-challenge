package com.example.gmcodingchallenge.ui.main.models;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class LibImpl implements Lib {

    public LibImpl() {

    }

    public Observable<Element> getElementsObservable() {
        List<Element> elements= new ArrayList<Element>();
        for (int i = 1; i <= 10; i++) {
            elements.add(new Element(i));
        }

        return Observable.fromIterable(elements);
    }

    public Single<List<Item>> queryElementForItems(Element e) {
        return Single.just(e.getItems());
    }
}
