package com.example.gmcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gmcodingchallenge.ui.main.MainFragment;
import com.example.gmcodingchallenge.ui.main.models.Item;
import com.example.gmcodingchallenge.ui.main.models.Lib;
import com.example.gmcodingchallenge.ui.main.models.LibImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Item> queue = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, MainFragment.newInstance())
//                    .commitNow();
//        }

        LinearLayout l = findViewById(R.id.linearLayout);

        Lib libImpl = new LibImpl();
        libImpl.getElementsObservable().subscribe(ele -> {
            libImpl.queryElementForItems(ele).subscribe(items -> {
                for (int i = 0; i < items.size(); i++) {
                    TextView textView = new TextView(this);
                    textView.setText(ele.id + " " + items.get(i).handle());
                    l.addView(textView);
                }
            });
        });
    }
}
