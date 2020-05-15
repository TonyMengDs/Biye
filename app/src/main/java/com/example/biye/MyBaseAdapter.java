package com.example.biye;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    private String[] data11;
    private Context mContext;
    private String[] Zjmc;
    private String[] Zjmc1;
    private int z=0;
    private ListView listView11;
    public MyBaseAdapter(Context mContext,String[] data11){
        super();
        this.mContext = mContext;
        this.data11 = data11;
    }
    @Override
    public int getCount(){
        return data11.length;
    }
    @Override
    public Object getItem(int position){
        return null;
    }

    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final TextView textView = new TextView(mContext);
        textView.setLayoutParams(new ViewGroup.LayoutParams(1200, 160));
        textView.setText(data11[position]);
//        if(unread){
//            textView.setBackgroundResource(R.drawable.mail_read_bg);
//        }
//        else
//        {
//            textView.setBackgroundResource(R.drawable.mail_read_bg);
//        }
//        new Thread() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                try {
//                    Class.forName("com.mysql.jdbc.Driver");
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//                String url = "jdbc:mysql://192.168.50.64:3306/biye";
//                String username = "root";
//                String password = "123456";
//                java.sql.Connection cn = null;
//                try {
//                    cn = DriverManager.getConnection(url, username, password);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                PreparedStatement stmt = null;
//                try {
//                    String sql2 = "SELECT DISTINCT Zjmc FROM  Chapter  WHERE Zjbh in (SELECT Zjbh FROM Study )";
//                    Statement stmt2 = cn.createStatement();        //创建Statement
//                    ResultSet rs2 = stmt2.executeQuery(sql2);
//                    Zjmc = new String[40];
//                    while(rs2.next())
//                    {
//                        Zjmc[z]=rs2.getString("Zjmc");
//                        z++;
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    cn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                Looper.loop();
//            }
//        }.start();
//        Zjmc1 = new String[z];
//        int c;
//        for(c=0;c<z;c++)
//        {
//            Zjmc1[c]=Zjmc[c];
//        }
//        for(c=0;c<z;c++)
//        {
//            if (data11[position].equals(Zjmc1[c]))
//            {
//                textView.setBackgroundColor(Color.GREEN);
//            }
//        }
        return textView;
    }
}
