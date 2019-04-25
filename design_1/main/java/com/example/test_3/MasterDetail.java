package com.example.test_3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class MasterDetail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_detail_layout);

        String data [] = {"AAA", "BBB", "CCC","AAA", "BBB", "CCC","AAA", "BBB", "CCC","AAA", "BBB", "CCC","AAA", "BBB", "CCC","AAA", "BBB", "CCC"};

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
    }
}
