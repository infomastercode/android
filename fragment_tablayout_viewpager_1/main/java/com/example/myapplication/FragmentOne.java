package com.example.myapplication;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class FragmentOne extends Fragment {

    private View view;
    private Boolean isDataList = false;

    public static FragmentOne newInstance(int position, String type) {
        //Log.d("check", "FragmentOne newInstance: " + position + " : " + type);

        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putString("type", type);

        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isResumed()) { // fragment is visible and have created
            loadData("A");
        }
//        if (isVisibleToUser) {
//            Log.d("MyFragment", "Fragment is visible. : " + getArguments().getString("type"));
//        } else {
//            Log.d("MyFragment", "Fragment is not visible. : " + getArguments().getString("type"));
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        ((TextView) view.findViewById(R.id.textViewRed)).setVisibility(View.INVISIBLE);
        ((TextView) view.findViewById(R.id.textViewBlue)).setVisibility(View.INVISIBLE);
        ((TextView) view.findViewById(R.id.textViewGreen)).setVisibility(View.INVISIBLE);
        ((TextView) view.findViewById(R.id.textViewYellow)).setVisibility(View.INVISIBLE);
        ((TextView) view.findViewById(R.id.textViewBlack)).setVisibility(View.INVISIBLE);

        if (getUserVisibleHint()) {
            loadData("B");
        }

        // Inflate the layout for this fragment
        return view;
    }


    public void loadData(String s) {
        int position = getArguments().getInt("position");
        String type = getArguments().getString("type");
        Log.d("MyFragment", "loadData. : " + position + " : " + type + " : " + s);
        if (type == "red") {
            ((TextView) view.findViewById(R.id.textViewRed)).setVisibility(View.VISIBLE);
        } else if (type == "blue") {
            ((TextView) view.findViewById(R.id.textViewBlue)).setVisibility(View.VISIBLE);
        } else if (type == "green") {
            ((TextView) view.findViewById(R.id.textViewGreen)).setVisibility(View.VISIBLE);
        } else if (type == "yellow") {
            ((TextView) view.findViewById(R.id.textViewYellow)).setVisibility(View.VISIBLE);
        } else if (type == "black") {
            ((TextView) view.findViewById(R.id.textViewBlack)).setVisibility(View.VISIBLE);
        }

        if(position == 0 && !isDataList){
            isDataList = true;
            Log.d("MyFragment", "just once for load data");
            new App().execute();
        }
    }

    class App extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://jsonplaceholder.typicode.com/users")
                        .build();

                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("MyFragment", "response : " + s);
        }
    }

}
