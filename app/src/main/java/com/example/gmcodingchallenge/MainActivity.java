package com.example.gmcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gmcodingchallenge.ui.main.models.Lib;
import com.example.gmcodingchallenge.ui.main.models.LibImpl;
import com.example.gmcodingchallenge.ui.main.util.ItemProcessor;

public class MainActivity extends AppCompatActivity {
    private ItemProcessor itemProcessor;
    private Context context;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        context = this;
        layout = findViewById(R.id.linearLayout);

        initItemProcessor();
        initLibrary();
    }

    private void initItemProcessor() {
        itemProcessor = new ItemProcessor();
        itemProcessor.getProcessedObservable().subscribe( val -> {
            addItemToLayout(val);
        });

        itemProcessor.start();
    }

    private void initLibrary() {
        Lib libImpl = new LibImpl();
        libImpl.getElementsObservable().subscribe(ele -> {
            addItemToLayout("Element ID " + ele.getId() + " received");
            itemProcessor.processElement(ele, libImpl.queryElementForItems(ele));
        });
    }

    private void addItemToLayout(String message) {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView textView = new TextView(context);
                    textView.setText(message);
                    layout.addView(textView);
                }
            });


        } catch (Exception e) {
            // TODO: Handle exception
        }
    }
}
