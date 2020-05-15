package com.example.biye;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class tab06 extends AppCompatActivity implements View.OnClickListener{
    private EditText editText61,editText62,editText63,editText64,editText65;
    private Spinner spinner61,spinner62,spinner63;
    private List<String> data_list61,data_list62,data_list63;
    private ArrayAdapter<String> arr_adapter61,arr_adapter62,arr_adapter63;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab06);

        Button button61 = findViewById(R.id.button61);
        button61.setOnClickListener(this);

        editText61 = (EditText)findViewById(R.id.editText61);
        editText62 = (EditText)findViewById(R.id.editText62);
        editText63 = (EditText)findViewById(R.id.editText63);
        editText64 = (EditText)findViewById(R.id.editText64);
        editText65 = (EditText)findViewById(R.id.editText65);
        spinner61 = (Spinner) findViewById(R.id.spinner61);

        spinner62 = (Spinner) findViewById(R.id.spinner62);
        spinner63 = (Spinner) findViewById(R.id.spinner63);

        data_list61 = new ArrayList<String>();
        data_list62 = new ArrayList<String>();
        data_list63 = new ArrayList<String>();
        data_list61.add("A");
        data_list61.add("B");
        data_list61.add("C");
        data_list61.add("D");
        data_list62.add("5");
        data_list62.add("10");
        data_list63.add("5");
        data_list63.add("10");
        //适配器
        //arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        arr_adapter61= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list61);
        //设置样式
        //arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arr_adapter61.setDropDownViewResource(R.layout.dropdown_style);
        //加载适配器
        spinner61.setAdapter(arr_adapter61);

        arr_adapter62= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list62);
        arr_adapter62.setDropDownViewResource(R.layout.dropdown_style);
        spinner62.setAdapter(arr_adapter62);

        arr_adapter63= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list63);
        arr_adapter63.setDropDownViewResource(R.layout.dropdown_style);
        spinner63.setAdapter(arr_adapter63);
        spinner61.setPrompt("请选择正确答案：");
        spinner62.setPrompt("请选择分值：");
        //editText2 = (EditText)findViewById(R.id.editText2);
        //editText2.setOnFocusChangeListener(this);  //对edit 进行焦点监听
        //editText2.setFocusable(false);
        //editText2.setFocusableInTouchMode(false);
    }

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
                Intent intent1 = new Intent(tab06.this, MainActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        String Stbt = editText61.getText()+"";
        String AnswerA = editText62.getText()+"";
        String AnswerB = editText63.getText()+"";
        String AnswerC = editText64.getText()+"";
        String AnswerD = editText65.getText()+"";
        String RightAnswer =(String) spinner61.getSelectedItem();
        String Fz = (String) spinner62.getSelectedItem();
        String Zjbh = (String) spinner63.getSelectedItem();

        if(Stbt.equals(""))
        {
            editText61.setHint("请输入试题，不能为空");
            return;
        }
        if(AnswerA.equals(""))
        {
            editText62.setHint("请输入A答案，不能为空");
            return;
        }
        if(AnswerB.equals(""))
        {
            editText63.setHint("请输入B答案，不能为空");
            return;
        }
        if(AnswerC.equals(""))
        {
            editText64.setHint("请输入C答案，不能为空");
            return;
        }
        if(AnswerD.equals(""))
        {
            editText65.setHint("请输入D答案，不能为空");
            return;
        }
        if(RightAnswer.equals(""))
        {
            spinner61.setPrompt("请选择正确答案，不能为空");
            return;
        }
        if(Zjbh.equals(""))
        {
            spinner63.setPrompt("请选择章节，不能为空");
            return;
        }
        if(Fz.equals(""))
        {
            spinner62.setPrompt("请选择分值，不能为空");
            return;
        }
        Toast.makeText(tab06.this,"您的试题已经上传成功",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(tab06.this,tab06.class);
        startActivity(intent);
    }
}
