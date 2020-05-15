package com.example.biye;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.io.InputStream;
import java.util.ArrayList;

public class exceljbcj extends AppCompatActivity {
    private String Zh1;
    ArrayList<View> viewContainter = new ArrayList<View>();
    private int images[]={R.drawable.exceljbcj1,R.drawable.exceljbcj2,R.drawable.exceljbcj3,R.drawable.exceljbcj4,R.drawable.exceljbcj5,R.drawable.exceljbcj6,R.drawable.exceljbcj7,R.drawable.exceljbcj8,R.drawable.exceljbcj9,R.drawable.exceljbcj10,R.drawable.exceljbcj11,R.drawable.exceljbcj12,R.drawable.exceljbcj13,R.drawable.exceljbcj14,R.drawable.exceljbcj15,R.drawable.exceljbcj16,R.drawable.exceljbcj17,R.drawable.exceljbcj18,R.drawable.exceljbcj19,R.drawable.exceljbcj20,R.drawable.exceljbcj21,R.drawable.exceljbcj22,R.drawable.exceljbcj23,R.drawable.exceljbcj24,R.drawable.exceljbcj25,R.drawable.exceljbcj26,R.drawable.exceljbcj27,R.drawable.exceljbcj28,R.drawable.exceljbcj29,R.drawable.exceljbcj30,R.drawable.exceljbcj31,R.drawable.exceljbcj31,R.drawable.exceljbcj32,R.drawable.exceljbcj33,R.drawable.exceljbcj34,R.drawable.exceljbcj35,R.drawable.exceljbcj36,R.drawable.exceljbcj37,R.drawable.exceljbcj38,R.drawable.exceljbcj39,R.drawable.exceljbcj40,R.drawable.exceljbcj41,R.drawable.exceljbcj42,R.drawable.exceljbcj43,R.drawable.exceljbcj44,R.drawable.exceljbcj45

    };
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsjjc);
        Intent intent321 =getIntent();
        Zh1 = intent321.getStringExtra("Zh");
//        View jsjjc1 = LayoutInflater.from(this).inflate(R.layout.jsjjc1,null);
//        View jsjjc2 = LayoutInflater.from(this).inflate(R.layout.jsjjc2,null);
//        View jsjjc3 = LayoutInflater.from(this).inflate(R.layout.jsjjc3,null);
//
//        viewContainter.add(jsjjc1);
//        viewContainter.add(jsjjc2);
//        viewContainter.add(jsjjc3);

        ViewPager viewPager11 = findViewById(R.id.viewPager11);
        for(int i=0;i<images.length;i++)
        {
            ImageView imageView = new ImageView(this);
            //   imageView.setImageResource(images[i]);
            Bitmap bitmap = readBitMap(this, images[i]);
            imageView.setImageBitmap(bitmap);
            viewContainter.add(imageView);
        }
        MyPagerAdapter adapter = new MyPagerAdapter(viewContainter);
        viewPager11.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);/*第一个参数是指将哪个菜单资源文件创建出来，
                           第二个改菜单赋予哪个菜单对象、*/
        return true;//意思是显示出来
    }

    //为菜单项添加响应
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //通过item.getItemId()对不同选项进行不同的处理
        switch (item.getItemId()) {
            case R.id.menu_back12:
                Intent intent111 = new Intent(exceljbcj.this, MainActivity.class);
                startActivity(intent111);
                break;
            case R.id.menu_back11:
                Intent intent112 = new Intent(exceljbcj.this, student.class);
                intent112.putExtra("Zh",Zh1);
                startActivity(intent112);
                break;
            default:
                break;
        }
        return true;
    }

    public static Bitmap readBitMap(Context context, int resId) {

        BitmapFactory.Options opt = new BitmapFactory.Options();

        opt.inPreferredConfig = Bitmap.Config.RGB_565;

        opt.inPurgeable = true;

        opt.inInputShareable = true;

        // 获取资源图片

        InputStream is = context.getResources().openRawResource(resId);

        return BitmapFactory.decodeStream(is, null, opt);

    }




}
