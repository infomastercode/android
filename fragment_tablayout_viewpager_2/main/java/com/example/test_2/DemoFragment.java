package com.example.test_2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends Fragment {

    private View view;
    private Boolean isDataList_0 = false;
    private Boolean isDataList_1 = false;
    private Boolean isDataList_2 = false;
    private Boolean isDataList_3 = false;
    private Boolean isDataList_4 = false;
    private ListView listRed;
    private ListView listBlue;
    private ListView listGreen;
    private ListView listYellow;
    private ListView listBlack;

    public DemoFragment() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isResumed()) { // fragment is visible and have created
            loadData("A");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_demo, container, false);

        ((ListView) view.findViewById(R.id.listRed)).setVisibility(View.GONE);
        ((ListView) view.findViewById(R.id.listBlue)).setVisibility(View.GONE);
        ((ListView) view.findViewById(R.id.listGreen)).setVisibility(View.GONE);
        ((ListView) view.findViewById(R.id.listYellow)).setVisibility(View.GONE);
        ((ListView) view.findViewById(R.id.listBlack)).setVisibility(View.GONE);

        if (getUserVisibleHint()) {
            loadData("B");
        }

        return view;
    }

    public void loadData(String s) {
        int position = getArguments().getInt("position");
        String data = getArguments().getString("data");
        Log.d("check", "loadData position : " + position + " : " + data);

        listRed = view.findViewById(R.id.listRed);
        listBlue = view.findViewById(R.id.listBlue);
        listGreen = view.findViewById(R.id.listGreen);
        listYellow = view.findViewById(R.id.listYellow);
        listBlack = view.findViewById(R.id.listBlack);

        if (position == 0) {
            listRed.setVisibility(View.VISIBLE);
        } else if (position == 1) {
            listBlue.setVisibility(View.VISIBLE);
        } else if (position == 2) {
            listGreen.setVisibility(View.VISIBLE);
        } else if (position == 3) {
            listYellow.setVisibility(View.VISIBLE);
        } else if (position == 4) {
            listBlack.setVisibility(View.VISIBLE);
        }

        String[] type = data
                .replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .split(",");

        if (position == 0 && !isDataList_0) {
            Log.d("check", "just one : " + position + " : " + data.toString());
            isDataList_0 = true;
            String red[] = {"RAA", "RBB", "RCC"};
            ArrayAdapter<String> adapterR = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, type);
            listRed.setAdapter(adapterR);
        }
        if (position == 1 && !isDataList_1) {
            Log.d("check", "just one : " + position + " : " + data.toString());
            isDataList_1 = true;
            String blue[] = {"BAA", "BBB", "BCC"};
            ArrayAdapter<String> adapterB = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, type);
            listBlue.setAdapter(adapterB);
        }
        if (position == 2 && !isDataList_2) {
            Log.d("check", "just one : " + position + " : " + data.toString());
            isDataList_2 = true;
            String green[] = {"GAA", "GBB", "GCC"};
            ArrayAdapter<String> adapterG = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, green);
            listGreen.setAdapter(adapterG);
        }
        if (position == 3 && !isDataList_3) {
            isDataList_3 = true;
            Log.d("check", "just one : " + position + " : " + data.toString());
            String yellow[] = {"YAA", "YBB", "YCC"};
            ArrayAdapter<String> adapterY = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, yellow);
            listYellow.setAdapter(adapterY);
        }
        if (position == 4 && !isDataList_4) {
            Log.d("check", "just one : " + position + " : " + data.toString());
            isDataList_4 = true;
            String black[] = {"AAA", "BBB", "CCC"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, black);
            listBlack.setAdapter(adapter);
        }

//        if (position == 0 && !isDataList_0) {
//
//            Log.d("check", "just one : " + position);
//            isDataList_0 = true;
//
//            String red[] = {"RAA", "RBB", "RCC"};
//            ArrayAdapter<String> adapterR = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, red);
//            listRed.setAdapter(adapterR);
//
//            String blue[] = {"BAA", "BBB", "BCC"};
//            ArrayAdapter<String> adapterB = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, blue);
//            listBlue.setAdapter(adapterB);
//
//            String green[] = {"GAA", "GBB", "GCC"};
//            ArrayAdapter<String> adapterG = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, green);
//            listGreen.setAdapter(adapterG);
//
//            String yellow[] = {"YAA", "YBB", "YCC"};
//            ArrayAdapter<String> adapterY = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, yellow);
//            listYellow.setAdapter(adapterY);
//
//            String black[] = {"AAA", "BBB", "CCC"};
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, black);
//            listBlack.setAdapter(adapter);
//        }
    }

}
