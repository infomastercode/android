package com.example.test_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MenuItem> menuItem = new ArrayList<MenuItem>();


//    String[] gridViewString = {
//            "Alram", "Android", "Mobile", "Website", "Profile", "WordPress",
//            "Alram", "Android", "Mobile", "Website", "Profile", "WordPress",
//            "Alram", "Android", "Mobile", "Website", "Profile", "WordPress",
//
//    } ;
//    int[] gridViewImageId = {
//            R.drawable.button, R.drawable.settings, R.drawable.box, R.drawable.home, R.drawable.ic_action_name, R.drawable.ic_action_name,
//            R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name,
//            R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name,
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuItem.add(new MenuItem("list", "show list", R.drawable.menu_list_64));
        menuItem.add(new MenuItem("hello", "show hello", R.drawable.menu_list_64));

        GridView gridView = findViewById(R.id.gridView);
        CustomGridViewAdapter adapter = new CustomGridViewAdapter(this, menuItem);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (menuItem.get(position).getCode() == "list") {
                    Intent i = new Intent(MainActivity.this, ListProduct.class);
                    startActivity(i);
                }
//                Intent i = new Intent(MainActivity.this, ListProduct.class);
//                startActivity(i);
            }
        });


    }

    public class MenuItem {
        private String code;
        private String label;
        private int ImageId;

        public MenuItem(String code, String label, int imageId) {
            this.code = code;
            this.label = label;
            ImageId = imageId;
        }

        public String getCode() {
            return code;
        }

        public String getLabel() {
            return label;
        }

        public int getImageId() {
            return ImageId;
        }
    }
}
