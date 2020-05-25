package com.example.gmcodingchallenge.ui.main.models;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface Lib {
    Observable<Element> getElementsObservable();
    Single<List<Item>> queryElementForItems(Element e);
}
