package com.example.root.test;

/**
 * Created by root on 2/7/17.
 */
import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Zhakenov on 2/4/2017.
 */

public class FragmentWithArray extends Fragment {

    ArrayList<String> arr;
    Button btnA;
    Button btnB;
    Button btnC,add;

    FragmentB a;
    FragmentB b;
    FragmentB c;

    String words;
    String location;

    FragmentTransaction transaction;
    EditText et,calendar;
    Calendar myCalendar = Calendar.getInstance();
    ArrayList<String> data1,data2,data3;
    public FragmentWithArray(){
        arr = new ArrayList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_a, container, false);

        ((TextView)view.findViewById(R.id.tvA)).setText("Fragment With array");
        a = getFragmentB("Fragment A", Color.RED);
        b = getFragmentB("Fragment B", Color.GREEN);
        c = getFragmentB("Fragment C", Color.BLUE);
        btnA=(Button)view.findViewById(R.id.btnA);
        btnB=(Button)view.findViewById(R.id.btnB);
        btnC=(Button)view.findViewById(R.id.btnC);
        add=(Button)view.findViewById(R.id.add);
        data1= new ArrayList();
        data2 = new ArrayList();
        data3 = new ArrayList();

        View.OnClickListener forBtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getActivity().getFragmentManager().beginTransaction();
                switch (view.getId()){
                    case R.id.btnA:
                        Log.d("Mylogs","btnA");
                        transaction.replace(R.id.container, a);
                        location="a";

                        break;
                    case R.id.btnB:
                        transaction.replace(R.id.container, b);
                        location="b";
                        Log.d("btn","btnB");
                        break;
                    case R.id.btnC:
                        transaction.replace(R.id.container, c);
                        location="c";
                        Log.d("btn","btnC");
                        break;

                    case R.id.add:
                        Log.d("Mylogs","Dias");
//                        if(location!=null && et.getText().toString().trim().length() != 0
//                                && calendar.getText().toString().trim().length() != 0){
                        ((MainActivity)getActivity()).refresh();
                            switch (location){
                                case "a":
                                    words = et.getText().toString() + "->" + calendar.getText().toString();
                                    data1.add(words);
                                    Log.d("Mylogs","data1");
                                    break;
                                case "b":
                                    words = et.getText().toString() + "->" + calendar.getText().toString();
                                    data2.add(words);
                                    Log.d("Mylogs","data2");
                                    break;
                                case "c":
                                    words = et.getText().toString() + "->" + calendar.getText().toString();
                                    data3.add(words);
                                    Log.d("Mylogs","data3");
                                    break;

                            }
                            et.setText("");
                            calendar.setText("");

                        //}
                        break;
                    case R.id.date:
                        new DatePickerDialog((MainActivity)getActivity(), date, myCalendar
                                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                        break;
                }
                transaction.addToBackStack("any");
                transaction.commit();
            }
        };
        btnA.setOnClickListener(forBtn);
        btnB.setOnClickListener(forBtn);
        btnC.setOnClickListener(forBtn);
        add.setOnClickListener(forBtn);
        et = (EditText)view.findViewById(R.id.et);
        calendar = (EditText)view.findViewById(R.id.date);
        calendar.setOnClickListener(forBtn);

        return view;
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        calendar.setText(sdf.format(myCalendar.getTime()));
    }
    public FragmentB getFragmentB(String text, int color){
        FragmentB frag = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        bundle.putInt("color", color);
        frag.setArguments(bundle);
        return frag;
    }

    public ArrayList<String> getArr(){
        return arr;
    }
    public ArrayList<String> getArrOne(){
        return data1;
    }
    public ArrayList<String> getArrTwo(){return data2;}
    public ArrayList<String> getArrThree(){
        return data3;
    }
}
