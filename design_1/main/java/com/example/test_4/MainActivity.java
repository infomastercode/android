package com.example.test_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] gridViewString = {
            "Alram", "Android", "Mobile", "Website", "Profile", "WordPress",
            "Alram", "Android", "Mobile", "Website", "Profile", "WordPress",
            "Alram", "Android", "Mobile", "Website", "Profile", "WordPress",

    } ;
    int[] gridViewImageId = {
            R.drawable.button, R.drawable.settings, R.drawable.box, R.drawable.home, R.drawable.ic_action_name, R.drawable.ic_action_name,
            R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name,
            R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridView gridView = findViewById(R.id.gridView);
        CustomGridViewAdapter adapter = new CustomGridViewAdapter(this, gridViewString, gridViewImageId);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ListProduct.class);
                startActivity(i);
            }
        });

    }
}
