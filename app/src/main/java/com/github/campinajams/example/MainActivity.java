package com.github.campinajams.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView noSavedItemsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noSavedItemsView = (TextView) findViewById(R.id.no_saved_items);
        noSavedItemsView.setSelected(true);
    }

}
