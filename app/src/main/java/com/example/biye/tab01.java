package com.example.biye;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class tab01 extends AppCompatActivity {

    private String data11[] = {"aa","bb","cc","dd","aa","bb","cc","dd","aa","bb","cc","dd","aa","bb","cc","dd"};//假数据

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab01);

        ListView listView11 = (ListView) findViewById(R.id.listview11);//在视图中找到ListView

        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data11);//新建并配置ArrayAapeter

        listView11.setAdapter(adapter11);

        listView11.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        Toast.makeText(tab01.this,"你点击了",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
