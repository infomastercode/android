package com.example.test_3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListProduct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_product_layout);

        ListView listProduct = findViewById(R.id.listProduct);
        ListProductAdapter adapter = new ListProductAdapter(ListProduct.this);
        listProduct.setAdapter(adapter);
    }
}
