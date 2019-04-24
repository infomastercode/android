package com.example.test_4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListProduct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_product_layout);

        ListView listView = findViewById(R.id.listView);
        ListProductAdapter adapter = new ListProductAdapter(ListProduct.this);
        listView.setAdapter(adapter);
    }
}
