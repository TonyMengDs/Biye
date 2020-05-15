package com.example.biye;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.io.InputStream;
import java.util.ArrayList;

public class exceltb1 extends AppCompatActivity {
    private String Zh1;
    ArrayList<View> viewContainter = new ArrayList<View>();
    private int images[]={R.drawable.exceltb1,R.drawable.exceltb2,R.drawable.exceltb3,R.drawable.exceltb4,R.drawable.exceltb5,R.drawable.exceltb6,R.drawable.exceltb7,R.drawable.exceltb8,R.drawable.exceltb9,R.drawable.exceltb10,R.drawable.exceltb11,R.drawable.exceltb12,R.drawable.exceltb13,R.drawable.exceltb14,R.drawable.exceltb15,R.drawable.exceltb16,R.drawable.exceltb17,R.drawable.exceltb18,R.drawable.exceltb19,R.drawable.exceltb20,R.drawable.exceltb21,R.drawable.exceltb22,R.drawable.exceltb23,R.drawable.exceltb24,R.drawable.exceltb25,R.drawable.exceltb26,R.drawable.exceltb27,R.drawable.exceltb28,R.drawable.exceltb29,R.drawable.exceltb30,R.drawable.exceltb31

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
                Intent intent111 = new Intent(exceltb1.this, MainActivity.class);
                startActivity(intent111);
                break;
            case R.id.menu_back11:
                Intent intent112 = new Intent(exceltb1.this, teacher.class);
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
