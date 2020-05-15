package com.example.biye;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class tab03 extends AppCompatActivity implements View.OnClickListener{
    TextView textView31,textView32,textView33,textView34,textView35,textView36,textView37;
    private EditText editText31;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab03);
        textView31 = findViewById(R.id.textView31);
        textView32 = findViewById(R.id.textView32);
        textView33 = findViewById(R.id.textView33);
        textView34 = findViewById(R.id.textView34);
        editText31 = findViewById(R.id.editText31);
        Button button31 = findViewById(R.id.button31);
        textView31.setText("41610076");
        textView32.setText("孟啸东");
        textView33.setText("男");
        textView34.setText("经济信息工程学院");
        editText31.setHint("15283026368");
        button31.setOnClickListener(this);
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
                Intent intent1 = new Intent(tab03.this, MainActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
        return true;
    }
    @Override
    public void onClick(View view) {
        String Phone = editText31.getText()+"";
        if(Phone.equals(""))
        {
            editText31.setHint("请输入电话，不能为空");
            return;
        }
        Toast.makeText(tab03.this,"您的信息已经更改成功",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(tab03.this,tab03.class);
        startActivity(intent);
    }
}
