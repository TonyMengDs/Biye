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

public class jsjwljc extends AppCompatActivity {
    private String Zh1;
    ArrayList<View> viewContainter = new ArrayList<View>();
    private int images[]={R.drawable.jsjwljc1,R.drawable.jsjwljc2,R.drawable.jsjwljc3,R.drawable.jsjwljc4,R.drawable.jsjwljc5,R.drawable.jsjwljc6,R.drawable.jsjwljc7,R.drawable.jsjwljc8,R.drawable.jsjwljc9,R.drawable.jsjwljc10,R.drawable.jsjwljc11,R.drawable.jsjwljc12,R.drawable.jsjwljc13,R.drawable.jsjwljc14,R.drawable.jsjwljc15,R.drawable.jsjwljc16,R.drawable.jsjwljc17,R.drawable.jsjwljc18,R.drawable.jsjwljc19
            ,R.drawable.jsjwljc20,R.drawable.jsjwljc21,R.drawable.jsjwljc22,R.drawable.jsjwljc23,R.drawable.jsjwljc24,R.drawable.jsjwljc25,R.drawable.jsjwljc26,R.drawable.jsjwljc27,R.drawable.jsjwljc28,R.drawable.jsjwljc29
            ,R.drawable.jsjwljc30,R.drawable.jsjwljc31,R.drawable.jsjwljc32,R.drawable.jsjwljc33,R.drawable.jsjwljc34,R.drawable.jsjwljc35,R.drawable.jsjwljc36,R.drawable.jsjwljc37,R.drawable.jsjwljc38,R.drawable.jsjwljc39
            ,R.drawable.jsjwljc40,R.drawable.jsjwljc41,R.drawable.jsjwljc42,R.drawable.jsjwljc43,R.drawable.jsjwljc44,R.drawable.jsjwljc45,R.drawable.jsjwljc46,R.drawable.jsjwljc47,R.drawable.jsjwljc48,R.drawable.jsjwljc49
            ,R.drawable.jsjwljc50,R.drawable.jsjwljc51,R.drawable.jsjwljc52

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
                Intent intent111 = new Intent(jsjwljc.this, MainActivity.class);
                startActivity(intent111);
                break;
            case R.id.menu_back11:
                Intent intent112 = new Intent(jsjwljc.this, student.class);
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
