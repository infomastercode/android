package com.example.test_4;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private boolean loadingMore = false;
    View ftView;
    private ListView listView;
    private ProductListAdapter adapter;
    private List<Product> mProductList;
    private Handler mHandler;
    private int currentId = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ftView = li.inflate(R.layout.footer_view, null);

        mHandler = new MyHandle();
        mProductList = new ArrayList<>();

        mProductList.add(new Product(1, "AAA"));
        mProductList.add(new Product(2, "BBB"));
        mProductList.add(new Product(3, "CCC"));
        mProductList.add(new Product(4, "DDD"));
        mProductList.add(new Product(5, "EEE"));
        mProductList.add(new Product(6, "EEE"));
        mProductList.add(new Product(7, "EEE"));
        mProductList.add(new Product(8, "EEE"));
        mProductList.add(new Product(9, "EEE"));
        mProductList.add(new Product(10, "EEE"));
        mProductList.add(new Product(11, "ZZZ"));

        adapter = new ProductListAdapter(getApplicationContext(), mProductList);
        listView.setAdapter(adapter);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int firstVisibleItem, visibleItemCount, totalItemCount, scrollState, expand;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (view.getLastVisiblePosition() == totalItemCount - 1 && listView.getCount() >= 10 && loadingMore == false) {
                    Log.d("check", "load more");
                    loadingMore = true;
                    Thread thread = new ThreadGetMoreData();
                    thread.start();
                }
            }
        });
    }

    private class MyHandle extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    listView.addFooterView(ftView);
                    break;
                case 1:
                    adapter.addListItemToAdapter((List<Product>) msg.obj);
                    listView.removeFooterView(ftView);
                    loadingMore = false;
                    break;
                default:
                    break;
            }
        }
    }

    private ArrayList<Product> getMoreData() {
        // replace code to get real data
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(++currentId, "FFF"));
        list.add(new Product(++currentId, "GGG"));
        list.add(new Product(++currentId, "HHH"));
        list.add(new Product(++currentId, "III"));
        list.add(new Product(++currentId, "JJJ"));
        list.add(new Product(++currentId, "KKK"));
        list.add(new Product(++currentId, "LLL"));
        list.add(new Product(++currentId, "MMM"));
        return list;
    }

    private class ThreadGetMoreData extends Thread {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            ArrayList<Product> list = getMoreData();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message msg = mHandler.obtainMessage(1, list);
            mHandler.sendMessage(msg);
        }
    }
}
