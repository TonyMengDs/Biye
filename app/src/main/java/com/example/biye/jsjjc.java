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

public class jsjjc extends AppCompatActivity {
    private String Zh1;
    ArrayList<View> viewContainter = new ArrayList<View>();
    private int images[]={R.drawable.jsjjc1,R.drawable.jsjjc2,R.drawable.jsjjc3,R.drawable.jsjjc4,R.drawable.jsjjc5,R.drawable.jsjjc6,R.drawable.jsjjc8,R.drawable.jsjjc9,R.drawable.jsjjc10,R.drawable.jsjjc11,R.drawable.jsjjc12,R.drawable.jsjjc13,R.drawable.jsjjc14,R.drawable.jsjjc15,R.drawable.jsjjc16,R.drawable.jsjjc17,R.drawable.jsjjc18,R.drawable.jsjjc19,R.drawable.jsjjc20
            ,R.drawable.jsjjc21,R.drawable.jsjjc22,R.drawable.jsjjc23,R.drawable.jsjjc24,R.drawable.jsjjc25,R.drawable.jsjjc26,R.drawable.jsjjc27,R.drawable.jsjjc28,R.drawable.jsjjc29,R.drawable.jsjjc30
            ,R.drawable.jsjjc31,R.drawable.jsjjc32,R.drawable.jsjjc33,R.drawable.jsjjc34,R.drawable.jsjjc35,R.drawable.jsjjc36,R.drawable.jsjjc37,R.drawable.jsjjc38,R.drawable.jsjjc39,R.drawable.jsjjc40
            ,R.drawable.jsjjc41,R.drawable.jsjjc42,R.drawable.jsjjc43,R.drawable.jsjjc44,R.drawable.jsjjc45,R.drawable.jsjjc46,R.drawable.jsjjc47,R.drawable.jsjjc48,R.drawable.jsjjc49,R.drawable.jsjjc50
            ,R.drawable.jsjjc51,R.drawable.jsjjc52,R.drawable.jsjjc53,R.drawable.jsjjc54,R.drawable.jsjjc55,R.drawable.jsjjc56,R.drawable.jsjjc57,R.drawable.jsjjc58,R.drawable.jsjjc59,R.drawable.jsjjc60
            ,R.drawable.jsjjc61,R.drawable.jsjjc62,R.drawable.jsjjc63,R.drawable.jsjjc64,R.drawable.jsjjc65,R.drawable.jsjjc66,R.drawable.jsjjc67,R.drawable.jsjjc68,R.drawable.jsjjc69,R.drawable.jsjjc70
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
                Intent intent111 = new Intent(jsjjc.this, MainActivity.class);
                startActivity(intent111);
                break;
            case R.id.menu_back11:
                Intent intent112 = new Intent(jsjjc.this, student.class);
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
