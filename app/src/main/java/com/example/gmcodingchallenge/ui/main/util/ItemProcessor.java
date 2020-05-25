package com.example.gmcodingchallenge.ui.main.util;

import com.example.gmcodingchallenge.ui.main.models.Element;
import com.example.gmcodingchallenge.ui.main.models.Item;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class ItemProcessor extends Thread {
    private PublishSubject<String> processed = PublishSubject.create();
    private List<Item> queue = new ArrayList<>();
    private int currentElementId;

    public ItemProcessor() {

    }

    public Observable<String> getProcessedObservable() {
        return processed;
    }

    public void processElement(Element ele, Single<List<Item>> itemsObservable) {
        this.queue.clear();
        this.currentElementId = ele.getId();

        itemsObservable.subscribe(items -> {
            this.queue.addAll(items);
        });
    }

    @Override
    public void run() {
        while(true) {
            while (queue.size() > 0) {
                Item item = queue.remove(0);
                int processTime = item.handle();

                try {
                    Thread.sleep(processTime * 1);
                } catch (InterruptedException ie) {
                    // TODO: Handle error
                }

                processed.onNext(currentElementId + " " + processTime);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie){
                // TODO: Handle error
            }
        }

    }
}
