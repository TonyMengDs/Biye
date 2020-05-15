package com.example.biye;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class tab05 extends AppCompatActivity {
    private EditText editText51;
    private Spinner spinner51,spinner52,spinner53,spinner54,spinner55;
    private List<String> data_list51,data_list52,data_list53,data_list54,data_list55;
    private ArrayAdapter<String> arr_adapter51,arr_adapter52,arr_adapter53,arr_adapter54,arr_adapter55;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab05);
        Button button51 = findViewById(R.id.button51);
      //  button51.setOnClickListener(this);

        editText51 = (EditText)findViewById(R.id.editText61);

        spinner51 = (Spinner) findViewById(R.id.spinner51);
        spinner52 = (Spinner) findViewById(R.id.spinner52);
        spinner53 = (Spinner) findViewById(R.id.spinner53);
        spinner54 = (Spinner) findViewById(R.id.spinner54);
        spinner55 = (Spinner) findViewById(R.id.spinner55);




        data_list51 = new ArrayList<String>();
        data_list52 = new ArrayList<String>();
        data_list53 = new ArrayList<String>();
        data_list54 = new ArrayList<String>();
        data_list55 = new ArrayList<String>();

        data_list51.add("计算机基础占比");
        data_list51.add("0");
        data_list51.add("5");
        data_list51.add("10");
        data_list51.add("15");
        data_list51.add("20");
        data_list51.add("25");


        data_list52.add("操作系统占比");
        data_list52.add("0");
        data_list52.add("5");
        data_list52.add("10");
        data_list52.add("15");
        data_list52.add("20");
        data_list52.add("25");


        data_list53.add("Excel占比");
        data_list53.add("0");
        data_list53.add("5");
        data_list53.add("10");
        data_list53.add("15");
        data_list53.add("20");
        data_list53.add("25");



       // data_list54.add("数据分析、图表操作占比");
        data_list54.add("SQL占比");
        data_list54.add("0");
        data_list54.add("5");
        data_list54.add("10");
        data_list54.add("15");
        data_list54.add("20");
        data_list54.add("25");

        data_list55.add("数据分析、图表操作占比");


        arr_adapter51= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list51);
        arr_adapter51.setDropDownViewResource(R.layout.dropdown_style);
        spinner51.setAdapter(arr_adapter51);
        arr_adapter52= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list52);
        arr_adapter52.setDropDownViewResource(R.layout.dropdown_style);
        spinner52.setAdapter(arr_adapter52);
        arr_adapter53= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list53);
        arr_adapter53.setDropDownViewResource(R.layout.dropdown_style);
        spinner53.setAdapter(arr_adapter53);
        arr_adapter54= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list54);
        arr_adapter54.setDropDownViewResource(R.layout.dropdown_style);
        spinner54.setAdapter(arr_adapter54);
        arr_adapter55= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list55);
        arr_adapter55.setDropDownViewResource(R.layout.dropdown_style);
        spinner55.setAdapter(arr_adapter55);

//        spinner51.setOnItemSelectedListener(spinnerSelectedListener);
//        spinner52.setOnItemSelectedListener(spinnerSelectedListener);
//        spinner53.setOnItemSelectedListener(spinnerSelectedListener);
          spinner54.setOnItemSelectedListener(spinnerSelectedListener);
 //       spinner55.setOnItemSelectedListener(spinnerSelectedListener);
    }




    private Spinner.OnItemSelectedListener spinnerSelectedListener = new Spinner.OnItemSelectedListener()
    {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
        {
            int a,b,c,d,e;

            String values1 = (String)spinner51.getSelectedItem();


            String values2 = (String)spinner52.getSelectedItem();


            String values3 = (String)spinner53.getSelectedItem();


            String values4 = (String)spinner54.getSelectedItem();


            if(values1.equals("计算机基础占比"))
            {
                Toast.makeText(tab05.this,"请选择计算机基础占比",Toast.LENGTH_SHORT).show();
            }
            else if(values2.equals("操作系统占比"))
            {
                Toast.makeText(tab05.this,"请选择操作系统占比",Toast.LENGTH_SHORT).show();
            }
            else if(values3.equals("Excel占比"))
            {
                Toast.makeText(tab05.this,"请选择Excel占比",Toast.LENGTH_SHORT).show();
            }
            else if(values4.equals("SQL占比"))
            {
                Toast.makeText(tab05.this,"请选择SQL占比",Toast.LENGTH_SHORT).show();
            }
            else if(!values1.equals("计算机基础占比")&&!values2.equals("操作系统占比")&&!values3.equals("Excel占比")&&!values4.equals("SQL占比")) {
                a = Integer.parseInt(values1);
                b = Integer.parseInt(values2);
                c = Integer.parseInt(values3);
                d = Integer.parseInt(values4);
                e = 100 - a - b - c - d;
                String str = String.valueOf(e);
                data_list55.clear();
                data_list55.add("数据分析、图表操作占比");
                data_list55.add(str);
                spinner55.setAdapter(arr_adapter55);
            }
//            if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("100%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("95%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("95%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("95%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("95%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("90%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("90%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("90%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("90%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("90%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("90%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("90%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("10%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("90%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("10%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("90%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("90%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("15%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("15%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("15%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("15%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("5%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("5%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("10%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("10%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("10%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("10%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("10%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("10%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("85%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("20%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("20%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("20%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("20%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("5%")&&values3.equals("5%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("15%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("15%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("15%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("15%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("15%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("15%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("15%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("15%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("15%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("15%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("15%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("15%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("10%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("0%")&&values3.equals("10%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("10%")&&values3.equals("10%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("10%")&&values3.equals("0%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("10%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("80%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("25%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("25%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("25%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("25%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("20%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("20%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("20%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("20%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("20%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("20%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("20%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("20%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("20%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("20%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("20%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("20%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("5%")&&values3.equals("5%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("10%")&&values3.equals("5%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("5%")&&values3.equals("10%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("5%")&&values3.equals("5%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("10%")&&values3.equals("5%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("5%")&&values3.equals("10%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("10%")&&values3.equals("10%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("10%")&&values3.equals("0%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("5%")&&values3.equals("0%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("10%")&&values3.equals("0%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("5%")&&values2.equals("0%")&&values3.equals("10%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("0%")&&values3.equals("5%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("0%")&&values3.equals("10%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("5%")&&values3.equals("10%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("10%")&&values3.equals("5%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("10%")&&values3.equals("10%")&&values4.equals("5%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("15%")&&values2.equals("10%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("15%")&&values2.equals("0%")&&values3.equals("10%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("15%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("15%")&&values3.equals("0%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("15%")&&values3.equals("10%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("15%")&&values3.equals("0%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("0%")&&values3.equals("15%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("10%")&&values3.equals("15%")&&values4.equals("0%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("15%")&&values4.equals("10%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("10%")&&values2.equals("0%")&&values3.equals("0%")&&values4.equals("15%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("10%")&&values3.equals("0%")&&values4.equals("15%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
//            else if(values1.equals("0%")&&values2.equals("0%")&&values3.equals("10%")&&values4.equals("15%"))
//            {
//                data_list55.clear();
//                data_list55.add("数据分析、图表操作占比");
//                data_list55.add("75%");
//                spinner55.setAdapter(arr_adapter55);
//                return;
//            }
       }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);/*第一个参数是指将哪个菜单资源文件创建出来，
                           第二个改菜单赋予哪个菜单对象、*/
        return true;//意思是显示出来
    }

    //为菜单项添加响应
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        //通过item.getItemId()对不同选项进行不同的处理
        switch (item.getItemId()) {
            case R.id.menu_back:
                Intent intent1 = new Intent(tab05.this, MainActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
        return true;
    }

}
