package com.example.root.test;

/**
 * Created by root on 2/7/17.
 */

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zhakenov on 2/4/2017.
 */

public class FragmentB extends Fragment

{
    String loc;
    String text;
    int color;
    ArrayList<String> data;
    ArrayAdapter<String> arrayAdapter;
    ListView lv;
    static View view = null;
    public FragmentB(){
        text = "";
        color = Color.WHITE;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("My", text+":onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("My", text+":onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_b, container, false);

        TextView tv = (TextView) view.findViewById(R.id.tv);
        RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.rl);
        lv = (ListView)view.findViewById(R.id.listv);


        //d = getFragmentB("Fragment D", Color.YELLOW);

//        ((FragmentWithArray)(getActivity().
//                getFragmentManager().findFragmentById(R.id.witharray))).getArr();

        ArrayList<String> arr = ((MainActivity)getActivity()).getArrFromFragment("t");
        text="";
        Bundle args = getArguments();
        if(args.getString("text")!=null){
            text+= args.getString("text");

        }
        if(args.getInt("color")!=0){
            rl.setBackgroundColor(args.getInt("color"));
        }
        tv.setText(text);
        //loc = ((MainActivity)getActivity()).getLocation();
        switch (text){
            case "Fragment A":
                data = ((MainActivity)getActivity()).getArrFromFragment("a");
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.item,data);
                lv.setAdapter(arrayAdapter);
                break;
            case "Fragment B":
                data = ((MainActivity)getActivity()).getArrFromFragment("b");
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.item,data);
                lv.setAdapter(arrayAdapter);
                break;
            case "Fragment C":
                data = ((MainActivity)getActivity()).getArrFromFragment("c");
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.item,data);
                lv.setAdapter(arrayAdapter);
                break;
        }
        Log.d("My", text+":onCreateView");
        return view;
    }

    public void method(){

        switch (text){
            case "Fragment A":
                data = ((MainActivity)getActivity()).getArrFromFragment("a");
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.item,data);
                lv.setAdapter(arrayAdapter);
                break;
            case "Fragment B":
                data = ((MainActivity)getActivity()).getArrFromFragment("b");
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.item,data);
                lv.setAdapter(arrayAdapter);
                break;
            case "Fragment C":
                data = ((MainActivity)getActivity()).getArrFromFragment("c");
                arrayAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.item,data);
                lv.setAdapter(arrayAdapter);
                break;
    }}
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("My", text+":onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("My", text+":onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("My", text+":onresume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("My", text+":onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("My", text+":onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("My", text+":onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("My", text+":onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("My", text+":onDetach");
    }
}
