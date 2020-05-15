package com.example.biye;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

public class grade extends AppCompatActivity {

    private  String[] Sjmc,Grade;
    private String Name;
    private TextView textViewdd, textViewdd1;
    private ListView lv;
    private List<User> userList = new ArrayList<User>();
    private BaseAdapter adapter;
    private String Zh1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade);

        Intent intent886 = getIntent();
        Name = intent886.getStringExtra("Name");
        Zh1 = intent886.getStringExtra("Zh");

        textViewdd = findViewById(R.id.textViewdd);
        Log.i("Mainactivity", Name);
        new Thread(runnable).start();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu3, menu);/*第一个参数是指将哪个菜单资源文件创建出来，
                           第二个改菜单赋予哪个菜单对象、*/
        return true;//意思是显示出来
    }

    //为菜单项添加响应
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        //通过item.getItemId()对不同选项进行不同的处理
        switch (item.getItemId()) {
            case R.id.menu_back32:
                Intent intent111 = new Intent(grade.this, MainActivity.class);
                startActivity(intent111);
                break;
            case R.id.menu_back31:
                Intent intent112 = new Intent(grade.this, teacher.class);
                intent112.putExtra("Zh",Zh1);
                startActivity(intent112);
                break;
            default:
                break;
        }
        return true;
    }
    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle data = new Bundle();
            data = msg.getData();

//            textViewdd.setText(data.get("Sjbh").toString());
//            textViewdd1.setText(data.get("Grade").toString());


//            int i=1;
//            int d=100;
            lv=(ListView)findViewById(R.id.listView1);

//                ue.setSjbh(""+i);
//                ue.setGrade("               "+d);

            Sjmc = new String[data.getInt("I")];
            Grade = new String[data.getInt("I")];
            int w;
            for(w=0;w<data.getInt("I");w++)
            {
                User ue = new User();
//                ue.setSjmc(data.get("Sjmc").toString());
//                ue.setGrade(data.get("Grade").toString());
                ue.setSjmc(data.getStringArray("Sjmc")[w]);
                ue.setGrade(data.getStringArray("Grade")[w]);
                System.out.println(data.getStringArray("Sjmc")[w]);
                System.out.println(data.getStringArray("Grade")[w]);
                Sjmc[w] =data.getStringArray("Sjmc")[w];
                Grade[w] = data.getStringArray("Grade")[w];
                System.out.println(Sjmc[w]);
                System.out.println(Grade[w]);
                userList.add(ue);
            }
            adapter = new BaseAdapter() {
                @Override
                public int getCount() {
                    return userList.size();
                }

                @Override
                public Object getItem(int i) {
                    return null;
                }

                @Override
                public long getItemId(int i) {
                    return 0;
                }

                @Override
                public View getView(int i, View convertView, ViewGroup viewGroup) {
                    LayoutInflater inflater=grade.this.getLayoutInflater();
                    View view;
                    if(convertView==null){
                        view = inflater.inflate(R.layout.item,null);
                    }
                    else{
                        view=convertView;

                    }
                    textViewdd = (TextView)view.findViewById(R.id.textViewdd);
//                    textViewdd.setText("1");
//
                    textViewdd.setText(userList.get(i).getSjmc());
                    textViewdd1 = (TextView)view.findViewById(R.id.textViewdd1);
//
                  textViewdd1.setText(userList.get(i).getGrade());
                    return view;


                }
            };



            lv.setAdapter(adapter);
        }
    };
    Runnable runnable = new Runnable() {
        private Connection connection = null;

        @Override
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://192.168.50.64:3306/biye", "root", "123456");
//                connection = DriverManager.getConnection("jdbc:mysql://172.20.10.2:3306/biye", "root", "123456");

                System.out.print("连接成功");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                test(connection);    //测试数据库连接
            } catch (java.sql.SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void test(Connection con1) throws java.sql.SQLException {
            try {
                String[] Sjmc,Grade;
                int i=0;
                String sql = "SELECT DISTINCT Sjmc,Grade FROM Paper,Exam where Xh in (SELECT Xh FROM Student where Name='" + Name + "') and Paper.Sjbh=Exam.Sjbh ";        //查询表名为“user”的所有内容
                Statement stmt = con1.createStatement();        //创建Statement
                ResultSet rs = stmt.executeQuery(sql);          //ResultSet类似Cursor
                Sjmc = new String[100];
                Grade = new String[100];
                //<code>ResultSet</code>最初指向第一行
                Bundle bundle = new Bundle();
                while (rs.next()) {

                    Sjmc[i] =rs.getString("Sjmc");
                    Grade[i] = rs.getString("Grade");
                    i++;
                }
                bundle.clear();
                bundle.putStringArray("Sjmc", Sjmc);
                bundle.putStringArray("Grade", Grade);
                bundle.putInt("I",i);
//                bundle.putString("Sjmc", rs.getString("Sjmc"));
//                bundle.putString("Grade", rs.getString("Grade"));
                Message msg = new Message();
                msg.setData(bundle);
                myHandler.sendMessage(msg);

                rs.close();
                stmt.close();

//                String sql1 = "SELECT Grade FROM Exam where Xh in (SELECT Xh FROM Student where Name='" + Name + "')";        //查询表名为“user”的所有内容
//                Statement stmt1 = con1.createStatement();        //创建Statement
//                ResultSet rs1 = stmt1.executeQuery(sql1);          //ResultSet类似Cursor
//
//                while (rs1.next()) {
//
//                    bundle.putString("Grade", rs.getString("Grade"));
//                    Message msg1 = new Message();
//                    msg1.setData(bundle);
//                    myHandler.sendMessage(msg1);
//                }
//                rs1.close();
//                stmt1.close();
            } catch (SQLException e) {

            } finally {
                if (con1 != null)
                    try {
                        con1.close();
                    } catch (SQLException e) {
                    }
            }
        }
    };
};

//    Runnable runnable = new Runnable() {
//        private Connection cn=null;
//        @Override
//        public void run() {
//            Looper.prepare();
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//
//                String url = "jdbc:mysql://192.168.50.64:3306/biye";
//                String username = "root";
//                String password = "123456";
//
//
//                cn = DriverManager.getConnection(url, username, password);
//
//                Statement stmt = (Statement) cn.createStatement();
//
//                String sql12 = "SELECT Sjbh,Grade  FROM Exam where Xh in (SELECT Xh FROM Student where Name='" + Name + "')";
//
//                ResultSet rs = stmt.executeQuery(sql12);
//                Bundle bundle = new Bundle();
//                while (rs.next()) ;
//                {
//                    bundle.clear();
//                    bundle.putString("Sjbh", rs.getString("Sjbh"));
//                    bundle.putString("Grade", rs.getString("Grade"));
//                    Message msg = new Message();
//                    msg.setData(bundle);
//                    myHandler.sendMessage(msg);
//                }
//                rs.close();
//                stmt.close();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } finally{
//                if(cn !=null)
//                    try{
//                        cn.close();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//            }
//
//            Looper.loop();
//        }
//
//    };
//}







