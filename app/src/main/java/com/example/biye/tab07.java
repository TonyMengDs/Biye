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

public class tab07 extends AppCompatActivity implements View.OnClickListener{
    TextView textView71,textView72,textView73,textView74,textView75,textView76;
    private EditText editText71,editText72;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab07);
        textView71 = findViewById(R.id.textView71);
        textView72 = findViewById(R.id.textView72);
        textView73 = findViewById(R.id.textView73);
        textView74 = findViewById(R.id.textView74);
        editText71 = findViewById(R.id.editText71);
        editText72 = findViewById(R.id.editText72);
        Button button71 = findViewById(R.id.button71);
        button71.setOnClickListener(this);
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
                Intent intent1 = new Intent(tab07.this, MainActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
        return true;
    }
    @Override
    public void onClick(View view) {
        String Phone = editText71.getText()+"";
        if(Phone.equals(""))
        {
            editText71.setHint("请输入电话，不能为空");
            return;
        }
        Toast.makeText(tab07.this,"您的信息已经更改成功",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(tab07.this,tab07.class);
        startActivity(intent);
    }
}
