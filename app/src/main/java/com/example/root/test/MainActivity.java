package com.example.root.test;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FragmentB a;
    FragmentB b;
    FragmentB c;
    FragmentB d;

    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = getFragmentB("Fragment A", Color.RED);
        b = getFragmentB("Fragment B", Color.GREEN);
        c = getFragmentB("Fragment C", Color.BLUE);
        setContentView(R.layout.activity_main);


    }

    public void refresh(){
                FragmentB frag = (FragmentB)getFragmentManager().findFragmentById(R.id.container);
                frag.method();

    }
    public ArrayList<String> getArrFromFragment(String r){
        FragmentWithArray frag = (FragmentWithArray) getFragmentManager().findFragmentById(R.id.witharray);
        switch(r){
            case "a" :
                return frag.getArrOne();
            case "b":
                return frag.getArrTwo();
            case "c":
                return frag.getArrThree();
            case "t":
            return frag.getArr();}
        return frag.getArr();
    }

    public FragmentB getFragmentB(String text, int color){
        FragmentB frag = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        bundle.putInt("color", color);
        frag.setArguments(bundle);
        return frag;
    }


    public void setFragment(int i){

    }


}
