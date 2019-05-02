package com.example.test_4;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private boolean loadingMore = false;
    View ftView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ftView = li.inflate(R.layout.footer_view, null);
        
        //listView.addFooterView(ftView);
        //listView.removeFooterView(ftView);

        String arr[] = {"AA", "BB", "CC", "DD", "BB", "CC", "DD", "BB", "CC", "DD", "BB", "CC", "DD", "BB", "CC", "DD", "BB", "CC", "DD"};
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr));
        
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int firstVisibleItem, visibleItemCount, totalItemCount, scrollState, expand;
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                int lastItem = this.firstVisibleItem + this.visibleItemCount;
                if (lastItem == this.totalItemCount && scrollState == SCROLL_STATE_IDLE) {
                    // scroll at bottom
                    this.expand++;
                    if (!loadingMore) {
                        loadingMore = true;
                        new Task(MainActivity.this).execute();
                        Log.d("check", "loadingMore: " + loadingMore);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                this.firstVisibleItem = firstVisibleItem;
                this.visibleItemCount = visibleItemCount;
                this.totalItemCount = totalItemCount;
//                Log.d("check", "firstVisibleItem: " + firstVisibleItem);
//                Log.d("check", "visibleItemCount: " + visibleItemCount);
//                Log.d("check", "totalItemCount: " + totalItemCount);
            }
        });
    }

    private class Task extends AsyncTask<Void, Void, String> {
        Context context;

        public Task(Context context) {
            this.context = context;
            loadingMore = true;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listView.addFooterView(ftView);
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            loadingMore = false;
            listView.removeFooterView(ftView);
            super.onPostExecute(s);
        }
    }
}
