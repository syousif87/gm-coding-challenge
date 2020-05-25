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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Context context = this;
        LinearLayout layout = findViewById(R.id.linearLayout);
        itemProcessor = new ItemProcessor();
        itemProcessor.getProcessedObservable().subscribe( val -> {
            try {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView textView = new TextView(context);
                        textView.setText(val);
                        layout.addView(textView);
                    }
                });


            } catch (Exception e) {
                // TODO: Handle exception
            }
        });

        itemProcessor.start();


        Lib libImpl = new LibImpl();
        libImpl.getElementsObservable().subscribe(ele -> {
            itemProcessor.processElement(ele, libImpl.queryElementForItems(ele));
        });
    }
}
