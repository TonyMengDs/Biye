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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class test extends AppCompatActivity {
    private List<View> views = new ArrayList<View>();
    private ViewPager viewPager11;
    private LinearLayout llChat, llFriends, llContacts;
    private TextView tvChat, tvFriends, tvContacts,tvCurrent;
    private String data11[] = {"aa","bb","cc","dd","aa","bb","cc","dd","aa","bb","cc","dd","aa","bb","cc","dd"};//假数据
    private String data21[] = {"aa","bb","cc","dd","aa","bb","cc","dd","aa","bb","cc","dd","aa","bb","cc","dd"};//假数据
    TextView textView31,textView32,textView33,textView34,textView35,textView36,textView37,textView38;
    private EditText editText31;
    private Spinner spinner,spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9,spinner10,spinner11,spinner12,spinner13,spinner14,spinner15,spinner16,spinner17,spinner18,spinner19,spinner20;
    private List<String> data_list91;
    private ArrayAdapter<String> arr_adapter91;
    private String Spinner[]={"spinner1","spinner2","spinner3","spinner4","spinner5","spinner6","spinner7","spinner8","spinner9","spinner10","spinner11","spinner12","spinner13","spinner14","spinner15","spinner16","spinner17","spinner18","spinner19","spinner20"};

    int j=0;
    int q=0;
    int grade=0;
    private int Sjbh8;
    private String Sjmc3,Xh1,Sjbh9;
    private String[] Stbt1,AnswerA1,AnswerB1,AnswerC1,AnswerD1,RightAnswer1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Toast.makeText(test.this, "本次测试共20道题，每题5分，一共100分，请同学们认真作答！", Toast.LENGTH_LONG).show();
        Intent intent886 =getIntent();
        Sjmc3 = intent886.getStringExtra("Sjmc3");
        Xh1 = intent886.getStringExtra("Xh");
        Sjbh9 = intent886.getStringExtra("Sjbh");
        Sjbh8 = Integer.parseInt(Sjbh9);
        Log.i("Mainactivity", Sjbh9);
        new Thread(runnable).start();


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
//                String sql12 = "SELECT Stbt FROM Question where Stbh in (SELECT Stbh FROM Paper where Sjbh='"+Sjbh+"')";
//                try {
//                    stmt = cn.prepareStatement(sql12);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    ResultSet rs112 = stmt.executeQuery();// 返回值代表收到影响的行数
//                    List<String> list1 = new ArrayList<String>();
//                    while(rs112.next())
//                    {
//                        list1.add(rs112.getString(1));
//                    }
//                    if(list1!=null&&list1.size()>0)
//                    {
//                        String[] Stbt=new String[list1.size()];
//                        for(int i=0;i<list1.size();i++)
//                        {
//                            Stbt[i]=list1.get(i);
//                            Log.i("MainActivity",Stbt[i]);
//                            SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.putString("Stbt"+i,Stbt[i]);
//                            editor.commit();
//                        }
//                    }
//                    rs112.close();
//                    stmt.close();
//
//                    PreparedStatement stmt1 = null;
//                    String sql13 = "SELECT AnswerA FROM Question where Stbh in (SELECT Stbh FROM Paper where Sjbh='"+Sjbh+"')";
//                    stmt1 = cn.prepareStatement(sql13);
//                    ResultSet rs113 = stmt1.executeQuery();// 返回值代表收到影响的行数
//                    List<String> list2 = new ArrayList<String>();
//                    while(rs113.next())
//                    {
//                        list2.add(rs113.getString(1));
//                    }
//                    if(list2!=null&&list2.size()>0)
//                    {
//                        String[] AnswerA=new String[list2.size()];
//                        for(int i=0;i<list2.size();i++)
//                        {
//                            AnswerA[i]=list2.get(i);
//                            Log.i("MainActivity",AnswerA[i]);
//                            SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.putString("AnswerA"+i,AnswerA[i]);
//                            editor.commit();
//                        }
//                    }
//                    rs113.close();
//                    stmt1.close();
//
//                    PreparedStatement stmt2 = null;
//                    String sql14 = "SELECT AnswerB FROM Question where Stbh in (SELECT Stbh FROM Paper where Sjbh='"+Sjbh+"')";
//                    stmt2 = cn.prepareStatement(sql14);
//                    ResultSet rs114 = stmt2.executeQuery();// 返回值代表收到影响的行数
//                    List<String> list3 = new ArrayList<String>();
//                    while(rs114.next())
//                    {
//                        list3.add(rs114.getString(1));
//                    }
//                    if(list3!=null&&list3.size()>0)
//                    {
//                        String[] AnswerB=new String[list3.size()];
//                        for(int i=0;i<list3.size();i++)
//                        {
//                            AnswerB[i]=list3.get(i);
//                            Log.i("MainActivity",AnswerB[i]);
//                            SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.putString("AnswerB"+i,AnswerB[i]);
//                            editor.commit();
//                        }
//                    }
//                    rs114.close();
//                    stmt2.close();
//
//                    PreparedStatement stmt3 = null;
//                    String sql15 = "SELECT AnswerC FROM Question where Stbh in (SELECT Stbh FROM Paper where Sjbh='"+Sjbh+"')";
//                    stmt3 = cn.prepareStatement(sql15);
//                    ResultSet rs115 = stmt3.executeQuery();// 返回值代表收到影响的行数
//                    List<String> list4 = new ArrayList<String>();
//                    while(rs115.next())
//                    {
//                        list4.add(rs115.getString(1));
//                    }
//                    if(list4!=null&&list4.size()>0)
//                    {
//                        String[] AnswerC=new String[list4.size()];
//                        for(int i=0;i<list4.size();i++)
//                        {
//                            AnswerC[i]=list4.get(i);
//                            Log.i("MainActivity",AnswerC[i]);
//                            SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.putString("AnswerC"+i,AnswerC[i]);
//                            editor.commit();
//                        }
//                    }
//                    rs115.close();
//                    stmt3.close();
//
//                    PreparedStatement stmt4 = null;
//                    String sql16 = "SELECT AnswerD FROM Question where Stbh in (SELECT Stbh FROM Paper where Sjbh='"+Sjbh+"')";
//                    stmt4 = cn.prepareStatement(sql16);
//                    ResultSet rs116 = stmt4.executeQuery();// 返回值代表收到影响的行数
//                    List<String> list5 = new ArrayList<String>();
//                    while(rs116.next())
//                    {
//                        list5.add(rs116.getString(1));
//                    }
//                    if(list5!=null&&list5.size()>0)
//                    {
//                        String[] AnswerD=new String[list5.size()];
//                        for(int i=0;i<list5.size();i++)
//                        {
//                            AnswerD[i]=list5.get(i);
//                            Log.i("MainActivity",AnswerD[i]);
//                            SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sharedPreferences.edit();
//                            editor.putString("AnswerD"+i,AnswerD[i]);
//                            editor.putString("Fz","5");
//                            editor.commit();
//                        }
//                    }
//                    rs116.close();
//                    stmt4.close();
//
////                    PreparedStatement stmt5 = null;
////                    String sql17 = "SELECT RightAnswer FROM Question where Stbh in (SELECT Stbh FROM Paper where Sjbh='"+Sjbh+"')";
////                    stmt5 = cn.prepareStatement(sql17);
////                    ResultSet rs117 = stmt5.executeQuery();// 返回值代表收到影响的行数
////                    List<String> list6 = new ArrayList<String>();
////                    while(rs117.next())
////                    {
////                        list6.add(rs117.getString(1));
////                    }
////                    if(list6!=null&&list6.size()>0)
////                    {
////                        String[] RightAnswer=new String[list6.size()];
////                        for(int i=0;i<list6.size();i++)
////                        {
////                            RightAnswer[i]=list6.get(i);
////                            Log.i("MainActivity",RightAnswer[i]);
////                            SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
////                            SharedPreferences.Editor editor = sharedPreferences.edit();
////                            editor.putString("RightAnswer"+i,RightAnswer[i]);
////                            editor.commit();
////                        }
////                    }
////                    rs116.close();
////                    stmt4.close();
//
//
//                    cn.close();
//
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                Looper.loop();
//            }
//        }.start();


    }
    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle data = new Bundle();
            data = msg.getData();

            Stbt1 = new String[data.getInt("I")];
            AnswerA1 = new String[data.getInt("I")];
            AnswerB1 = new String[data.getInt("I")];
            AnswerC1 = new String[data.getInt("I")];
            AnswerD1 = new String[data.getInt("I")];
            RightAnswer1 = new String[data.getInt("I")];
            q=data.getInt("I");
            System.out.println(q);

            int w;
            for(w=0;w<20;w++)
            {
                Stbt1[w] =data.getStringArray("Stbt")[w];
                AnswerA1[w] = data.getStringArray("AnswerA")[w];
                AnswerB1[w] = data.getStringArray("AnswerB")[w];
                AnswerC1[w] = data.getStringArray("AnswerC")[w];
                AnswerD1[w] = data.getStringArray("AnswerD")[w];
                RightAnswer1[w] = data.getStringArray("RightAnswer")[w];
                System.out.println(Stbt1[w]);
                System.out.println(AnswerA1[w]);
            }



            initView();

            initData();
        }
    };
    Runnable runnable = new Runnable() {
        private Connection connection = null;

        @Override
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
//                connection = DriverManager.getConnection("jdbc:mysql://172.20.10.2:3306/biye", "root", "123456");
                connection = DriverManager.getConnection("jdbc:mysql://192.168.50.64:3306/biye", "root", "123456");
                System.out.print("连接成功");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                test1(connection);    //测试数据库连接
            } catch (java.sql.SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void test1(Connection con1) throws java.sql.SQLException {
            try {
                String[] Stbt,AnswerA,AnswerB,AnswerC,AnswerD,RightAnswer;
                int i=0;
                String sql = "SELECT Stbt,AnswerA,AnswerB,AnswerC,AnswerD,RightAnswer FROM Question where Stbh in (SELECT Stbh FROM Paper where Sjmc='"+Sjmc3+"') ";        //查询表名为“user”的所有内容
                Statement stmt = con1.createStatement();        //创建Statement
                ResultSet rs = stmt.executeQuery(sql);          //ResultSet类似Cursor
                Stbt = new String[100];
                AnswerA = new String[100];
                AnswerB = new String[100];
                AnswerC = new String[100];
                AnswerD = new String[100];
                RightAnswer = new String[100];
                //<code>ResultSet</code>最初指向第一行
                Bundle bundle = new Bundle();
                while (rs.next()) {

                    Stbt[i] =rs.getString("Stbt");
                    AnswerA[i] = rs.getString("AnswerA");
                    AnswerB[i] = rs.getString("AnswerB");
                    AnswerC[i] = rs.getString("AnswerC");
                    AnswerD[i] = rs.getString("AnswerD");
                    RightAnswer[i] = rs.getString("RightAnswer");
                    i++;
                }
                bundle.clear();
                bundle.putStringArray("Stbt", Stbt);
                bundle.putStringArray("AnswerA", AnswerA);
                bundle.putStringArray("AnswerB", AnswerB);
                bundle.putStringArray("AnswerC", AnswerC);
                bundle.putStringArray("AnswerD", AnswerD);
                bundle.putStringArray("RightAnswer", RightAnswer);
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



    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu2, menu);/*第一个参数是指将哪个菜单资源文件创建出来，
                           第二个改菜单赋予哪个菜单对象、*/
        return true;//意思是显示出来
    }

    //为菜单项添加响应
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        //通过item.getItemId()对不同选项进行不同的处理
        switch (item.getItemId()) {
            case R.id.menu_back32:
                Intent intent111 = new Intent(test.this, MainActivity.class);
                startActivity(intent111);
                break;
            case R.id.menu_back31:
                int i;
//                for(i=0;i<q;i++)
//                {
                    String as1 = spinner1.getSelectedItem().toString();
                    String as2 = spinner2.getSelectedItem().toString();
                    String as3 = spinner3.getSelectedItem().toString();
                    String as4 = spinner4.getSelectedItem().toString();
                    String as5 = spinner5.getSelectedItem().toString();
                    String as6 = spinner6.getSelectedItem().toString();
                    String as7 = spinner7.getSelectedItem().toString();
                    String as8 = spinner8.getSelectedItem().toString();
                    String as9 = spinner9.getSelectedItem().toString();
                    String as10 = spinner10.getSelectedItem().toString();
                    String as11 = spinner11.getSelectedItem().toString();
                    String as12 = spinner12.getSelectedItem().toString();
                    String as13 = spinner13.getSelectedItem().toString();
                    String as14 = spinner14.getSelectedItem().toString();
                    String as15 = spinner15.getSelectedItem().toString();
                    String as16 = spinner16.getSelectedItem().toString();
                    String as17 = spinner17.getSelectedItem().toString();
                    String as18 = spinner18.getSelectedItem().toString();
                    String as19 = spinner19.getSelectedItem().toString();
                    String as20 = spinner20.getSelectedItem().toString();
                    if(as1.equals("请选择您的第一题答案"))
                    {
                        Toast.makeText(test.this, "请选择第一题答案", Toast.LENGTH_SHORT).show();
                    }
                   else if(as2.equals("请选择您的第二题答案"))
            {
                Toast.makeText(test.this, "请选择第二题答案", Toast.LENGTH_SHORT).show();
            }
                else if(as3.equals("请选择您的第三题答案"))
                {
                    Toast.makeText(test.this, "请选择第三题答案", Toast.LENGTH_SHORT).show();
                }
                    else if(as4.equals("请选择您的第四题答案"))
                    {
                        Toast.makeText(test.this, "请选择第四题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as5.equals("请选择您的第五题答案"))
                    {
                        Toast.makeText(test.this, "请选择第五题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as6.equals("请选择您的第六题答案"))
                    {
                        Toast.makeText(test.this, "请选择第六题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as7.equals("请选择您的第七题答案"))
                    {
                        Toast.makeText(test.this, "请选择第七题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as8.equals("请选择您的第八题答案"))
                    {
                        Toast.makeText(test.this, "请选择第八题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as9.equals("请选择您的第九题答案"))
                    {
                        Toast.makeText(test.this, "请选择第九题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as10.equals("请选择您的第十题答案"))
                    {
                        Toast.makeText(test.this, "请选择第十题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as11.equals("请选择您的第十一题答案"))
                    {
                        Toast.makeText(test.this, "请选择第十一题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as12.equals("请选择您的第十二题答案"))
                    {
                        Toast.makeText(test.this, "请选择第十二题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as13.equals("请选择您的第十三题答案"))
                    {
                        Toast.makeText(test.this, "请选择第十三题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as14.equals("请选择您的第十四题答案"))
                    {
                        Toast.makeText(test.this, "请选择第十四题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as15.equals("请选择您的第十五题答案"))
                    {
                        Toast.makeText(test.this, "请选择第十五题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as16.equals("请选择您的第十六题答案"))
                    {
                        Toast.makeText(test.this, "请选择第十六题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as17.equals("请选择您的第十七题答案"))
                    {
                        Toast.makeText(test.this, "请选择第十七题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as18.equals("请选择您的第十八题答案"))
                    {
                        Toast.makeText(test.this, "请选择第十八题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as19.equals("请选择您的第十九题答案"))
                    {
                        Toast.makeText(test.this, "请选择第十九题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(as20.equals("请选择您的第二十题答案"))
                    {
                        Toast.makeText(test.this, "请选择第二十题答案", Toast.LENGTH_SHORT).show();
                    }
                    else if(!as1.equals("请选择您的第一题答案")&&!as2.equals("请选择您的第二题答案")&&!as3.equals("请选择您的第三题答案")&&!as4.equals("请选择您的第四题答案")&&!as5.equals("请选择您的第五题答案")&&!as6.equals("请选择您的第六题答案")&&!as7.equals("请选择您的第七题答案")&&!
                            as8.equals("请选择您的第八题答案")&&!as9.equals("请选择您的第九题答案")&&!as10.equals("请选择您的第十题答案")&&!as11.equals("请选择您的第十一题答案")&&!as12.equals("请选择您的第十二题答案")&&!as13.equals("请选择您的第十三题答案")
                    &&!as14.equals("请选择您的第十四题答案")&&!as15.equals("请选择您的第十五题答案")&&!as16.equals("请选择您的第十六题答案")&&!as17.equals("请选择您的第十七题答案")&&!as18.equals("请选择您的第十八题答案")&&!as19.equals("请选择您的第十九题答案")
                    &&!as20.equals("请选择您的第二十题答案")) {
//                    else if(!as1.equals("请选择您的第一题答案")&&!as2.equals("请选择您的第二题答案")&&!as3.equals("请选择您的第三题答案")&&!as4.equals("请选择您的第四题答案")&&!as5.equals("请选择您的第五题答案")&&!as6.equals("请选择您的第六题答案")&&!as7.equals("请选择您的第七题答案")&&!
//                            as8.equals("请选择您的第八题答案")&&!as9.equals("请选择您的第九题答案")&&!as10.equals("请选择您的第十题答案")&&!as11.equals("请选择您的第十一题答案")&&!as12.equals("请选择您的第十二题答案")&&!as13.equals("请选择您的第十三题答案")
//                            &&!as14.equals("请选择您的第十四题答案")&&!as15.equals("请选择您的第十五题答案")&&!as16.equals("请选择您的第十六题答案")&&!as17.equals("请选择您的第十七题答案")&&!as18.equals("请选择您的第十八题答案")&&!as19.equals("请选择您的第十九题答案")
//                            ) {
                        if (as1.equals(RightAnswer1[0])) {
                            grade = grade + 5;
                        }
                        if (as2.equals(RightAnswer1[1])) {
                            grade = grade + 5;
                        }
                        if (as3.equals(RightAnswer1[2])) {
                            grade = grade + 5;
                        }
                        if (as4.equals(RightAnswer1[3])) {
                            grade = grade + 5;
                        }
                        if (as5.equals(RightAnswer1[4])) {
                            grade = grade + 5;
                        }
                        if (as6.equals(RightAnswer1[5])) {
                            grade = grade + 5;
                        }
                        if (as7.equals(RightAnswer1[6])) {
                            grade = grade + 5;
                        }
                        if (as8.equals(RightAnswer1[7])) {
                            grade = grade + 5;
                        }
                        if (as9.equals(RightAnswer1[8])) {
                            grade = grade + 5;
                        }
                        if (as10.equals(RightAnswer1[9])) {
                            grade = grade + 5;
                        }
                        if (as11.equals(RightAnswer1[10])) {
                            grade = grade + 5;
                        }
                        if (as12.equals(RightAnswer1[11])) {
                            grade = grade + 5;
                        }
                        if (as13.equals(RightAnswer1[12])) {
                            grade = grade + 5;
                        }
                        if (as14.equals(RightAnswer1[13])) {
                            grade = grade + 5;
                        }
                        if (as15.equals(RightAnswer1[14])) {
                            grade = grade + 5;
                        }
                        if (as16.equals(RightAnswer1[15])) {
                            grade = grade + 5;
                        }
                        if (as17.equals(RightAnswer1[16])) {
                            grade = grade + 5;
                        }
                        if (as18.equals(RightAnswer1[17])) {
                            grade = grade + 5;
                        }
                        if (as19.equals(RightAnswer1[18])) {
                            grade = grade + 5;
                        }
                        if (as20.equals(RightAnswer1[19])) {
                            grade = grade + 5;
                        }


//                }

                        Toast.makeText(test.this, "恭喜您获得" + grade + "分", Toast.LENGTH_SHORT).show();
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {

                                    Class.forName("com.mysql.jdbc.Driver");
//                                    String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                    String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                    String username = "root";
                                    String password = "123456";
                                    java.sql.Connection cn = DriverManager.getConnection(url, username, password);
                                    String sql = "INSERT INTO Exam (Sjbh,Xh,Grade) VALUES(" + Sjbh8 + ",'" + Xh1 + "','" + grade + "')";
                                    Statement st = (Statement) cn.createStatement();
                                    st.execute(sql);
                                    st.close();
                                    cn.close();

                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                } catch (SQLException e) {
                                    e.printStackTrace();

                                }
                                Looper.loop();
                            }
                        }.start();
                        Intent intent112 = new Intent(test.this, student.class);
                        intent112.putExtra("Zh",Xh1);
                        startActivity(intent112);
                        break;
                    }
            default:
                break;
        }
        return true;
    }


    private void initView() {
        viewPager11 = (ViewPager) findViewById(R.id.viewPager11);

    }





    private void initData() {
        LayoutInflater mInflater = LayoutInflater.from(this);



//        for(int i=0;i<q;i++)
//        {
            View vpView1 = View.inflate(this,R.layout.test1,null);
            TextView tv11 = (TextView) vpView1.findViewById(R.id.text91);
            TextView tv12 = (TextView) vpView1.findViewById(R.id.text92);
            TextView tv13 = (TextView) vpView1.findViewById(R.id.text93);
            TextView tv14 = (TextView) vpView1.findViewById(R.id.text94);
            TextView tv15 = (TextView) vpView1.findViewById(R.id.text95);




            tv11.setText("（5分）1. "+Stbt1[0]) ;
            tv12.setText("A. "+AnswerA1[0]);
            tv13.setText("B. "+AnswerB1[0]);
            tv14.setText("C. "+AnswerC1[0]);
            tv15.setText("D. "+AnswerD1[0]);

            spinner1 = (Spinner) vpView1.findViewById(R.id.spinner91);
            data_list91 = new ArrayList<String>();
            data_list91.add("请选择您的第一题答案");
            data_list91.add("A");
            data_list91.add("B");
            data_list91.add("C");
            data_list91.add("D");

            arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
            arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
            spinner1.setAdapter(arr_adapter91);

            views.add(vpView1);

        View vpView2 = View.inflate(this,R.layout.test1,null);
        TextView tv21 = (TextView) vpView2.findViewById(R.id.text91);
        TextView tv22 = (TextView) vpView2.findViewById(R.id.text92);
        TextView tv23 = (TextView) vpView2.findViewById(R.id.text93);
        TextView tv24 = (TextView) vpView2.findViewById(R.id.text94);
        TextView tv25 = (TextView) vpView2.findViewById(R.id.text95);




        tv21.setText("（5分）2. "+Stbt1[1]);
        tv22.setText("A. "+AnswerA1[1]);
        tv23.setText("B. "+AnswerB1[1]);
        tv24.setText("C. "+AnswerC1[1]);
        tv25.setText("D. "+AnswerD1[1]);

        spinner2 = (Spinner) vpView2.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第二题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner2.setAdapter(arr_adapter91);

        views.add(vpView2);

        View vpView3 = View.inflate(this,R.layout.test1,null);
        TextView tv31 = (TextView) vpView3.findViewById(R.id.text91);
        TextView tv32 = (TextView) vpView3.findViewById(R.id.text92);
        TextView tv33 = (TextView) vpView3.findViewById(R.id.text93);
        TextView tv34 = (TextView) vpView3.findViewById(R.id.text94);
        TextView tv35 = (TextView) vpView3.findViewById(R.id.text95);




        tv31.setText("（5分）3. "+Stbt1[2]);
        tv32.setText("A. "+AnswerA1[2]);
        tv33.setText("B. "+AnswerB1[2]);
        tv34.setText("C. "+AnswerC1[2]);
        tv35.setText("D. "+AnswerD1[2]);

        spinner3 = (Spinner) vpView3.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第三题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner3.setAdapter(arr_adapter91);

        views.add(vpView3);

        View vpView4 = View.inflate(this,R.layout.test1,null);
        TextView tv41 = (TextView) vpView4.findViewById(R.id.text91);
        TextView tv42 = (TextView) vpView4.findViewById(R.id.text92);
        TextView tv43 = (TextView) vpView4.findViewById(R.id.text93);
        TextView tv44 = (TextView) vpView4.findViewById(R.id.text94);
        TextView tv45 = (TextView) vpView4.findViewById(R.id.text95);




        tv41.setText("（5分）4. "+Stbt1[3]);
        tv42.setText("A. "+AnswerA1[3]);
        tv43.setText("B. "+AnswerB1[3]);
        tv44.setText("C. "+AnswerC1[3]);
        tv45.setText("D. "+AnswerD1[3]);

        spinner4 = (Spinner) vpView4.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第四题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner4.setAdapter(arr_adapter91);

        views.add(vpView4);
        View vpView5 = View.inflate(this,R.layout.test1,null);
        TextView tv51 = (TextView) vpView5.findViewById(R.id.text91);
        TextView tv52 = (TextView) vpView5.findViewById(R.id.text92);
        TextView tv53 = (TextView) vpView5.findViewById(R.id.text93);
        TextView tv54 = (TextView) vpView5.findViewById(R.id.text94);
        TextView tv55 = (TextView) vpView5.findViewById(R.id.text95);




        tv51.setText("（5分）5. "+Stbt1[4]);
        tv52.setText("A. "+AnswerA1[4]);
        tv53.setText("B. "+AnswerB1[4]);
        tv54.setText("C. "+AnswerC1[4]);
        tv55.setText("D. "+AnswerD1[4]);

        spinner5 = (Spinner) vpView5.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第五题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner5.setAdapter(arr_adapter91);

        views.add(vpView5);

        View vpView6 = View.inflate(this,R.layout.test1,null);
        TextView tv61 = (TextView) vpView6.findViewById(R.id.text91);
        TextView tv62 = (TextView) vpView6.findViewById(R.id.text92);
        TextView tv63 = (TextView) vpView6.findViewById(R.id.text93);
        TextView tv64 = (TextView) vpView6.findViewById(R.id.text94);
        TextView tv65 = (TextView) vpView6.findViewById(R.id.text95);




        tv61.setText("（5分）6. "+Stbt1[5]);
        tv62.setText("A. "+AnswerA1[5]);
        tv63.setText("B. "+AnswerB1[5]);
        tv64.setText("C. "+AnswerC1[5]);
        tv65.setText("D. "+AnswerD1[5]);

        spinner6 = (Spinner) vpView6.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第六题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner6.setAdapter(arr_adapter91);

        views.add(vpView6);

        View vpView7 = View.inflate(this,R.layout.test1,null);
        TextView tv71 = (TextView) vpView7.findViewById(R.id.text91);
        TextView tv72 = (TextView) vpView7.findViewById(R.id.text92);
        TextView tv73 = (TextView) vpView7.findViewById(R.id.text93);
        TextView tv74 = (TextView) vpView7.findViewById(R.id.text94);
        TextView tv75 = (TextView) vpView7.findViewById(R.id.text95);




        tv71.setText("（5分）7. "+Stbt1[6]);
        tv72.setText("A. "+AnswerA1[6]);
        tv73.setText("B. "+AnswerB1[6]);
        tv74.setText("C. "+AnswerC1[6]);
        tv75.setText("D. "+AnswerD1[6]);

        spinner7 = (Spinner) vpView7.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第七题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner7.setAdapter(arr_adapter91);

        views.add(vpView7);

        View vpView8 = View.inflate(this,R.layout.test1,null);
        TextView tv81 = (TextView) vpView8.findViewById(R.id.text91);
        TextView tv82 = (TextView) vpView8.findViewById(R.id.text92);
        TextView tv83 = (TextView) vpView8.findViewById(R.id.text93);
        TextView tv84 = (TextView) vpView8.findViewById(R.id.text94);
        TextView tv85 = (TextView) vpView8.findViewById(R.id.text95);




        tv81.setText("（5分）8. "+Stbt1[7]);
        tv82.setText("A. "+AnswerA1[7]);
        tv83.setText("B. "+AnswerB1[7]);
        tv84.setText("C. "+AnswerC1[7]);
        tv85.setText("D. "+AnswerD1[7]);

        spinner8 = (Spinner) vpView8.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第八题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner8.setAdapter(arr_adapter91);

        views.add(vpView8);

        View vpView9 = View.inflate(this,R.layout.test1,null);
        TextView tv91 = (TextView) vpView9.findViewById(R.id.text91);
        TextView tv92 = (TextView) vpView9.findViewById(R.id.text92);
        TextView tv93 = (TextView) vpView9.findViewById(R.id.text93);
        TextView tv94 = (TextView) vpView9.findViewById(R.id.text94);
        TextView tv95 = (TextView) vpView9.findViewById(R.id.text95);




        tv91.setText("（5分）9. "+Stbt1[8]);
        tv92.setText("A. "+AnswerA1[8]);
        tv93.setText("B. "+AnswerB1[8]);
        tv94.setText("C. "+AnswerC1[8]);
        tv95.setText("D. "+AnswerD1[8]);

        spinner9 = (Spinner) vpView9.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第九题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner9.setAdapter(arr_adapter91);

        views.add(vpView9);

        View vpView10 = View.inflate(this,R.layout.test1,null);
        TextView tv101 = (TextView) vpView10.findViewById(R.id.text91);
        TextView tv102 = (TextView) vpView10.findViewById(R.id.text92);
        TextView tv103 = (TextView) vpView10.findViewById(R.id.text93);
        TextView tv104 = (TextView) vpView10.findViewById(R.id.text94);
        TextView tv105 = (TextView) vpView10.findViewById(R.id.text95);




        tv101.setText("（5分）10. "+Stbt1[9]);
        tv102.setText("A. "+AnswerA1[9]);
        tv103.setText("B. "+AnswerB1[9]);
        tv104.setText("C. "+AnswerC1[9]);
        tv105.setText("D. "+AnswerD1[9]);

        spinner10 = (Spinner) vpView10.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第十题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner10.setAdapter(arr_adapter91);

        views.add(vpView10);

        View vpView11 = View.inflate(this,R.layout.test1,null);
        TextView tv111 = (TextView) vpView11.findViewById(R.id.text91);
        TextView tv112 = (TextView) vpView11.findViewById(R.id.text92);
        TextView tv113 = (TextView) vpView11.findViewById(R.id.text93);
        TextView tv114 = (TextView) vpView11.findViewById(R.id.text94);
        TextView tv115 = (TextView) vpView11.findViewById(R.id.text95);




        tv111.setText("（5分）11. "+Stbt1[10]);
        tv112.setText("A. "+AnswerA1[10]);
        tv113.setText("B. "+AnswerB1[10]);
        tv114.setText("C. "+AnswerC1[10]);
        tv115.setText("D. "+AnswerD1[10]);

        spinner11 = (Spinner) vpView11.findViewById(R.id.spinner91);
        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第十一题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner11.setAdapter(arr_adapter91);

        views.add(vpView11);

        View vpView12 = View.inflate(this,R.layout.test1,null);
        TextView tv121 = (TextView) vpView12.findViewById(R.id.text91);
        TextView tv122 = (TextView) vpView12.findViewById(R.id.text92);
        TextView tv123 = (TextView) vpView12.findViewById(R.id.text93);
        TextView tv124 = (TextView) vpView12.findViewById(R.id.text94);
        TextView tv125 = (TextView) vpView12.findViewById(R.id.text95);




        tv121.setText("（5分）12. "+Stbt1[11]);
        tv122.setText("A. "+AnswerA1[11]);
        tv123.setText("B. "+AnswerB1[11]);
        tv124.setText("C. "+AnswerC1[11]);
        tv125.setText("D. "+AnswerD1[11]);

        spinner12 = (Spinner) vpView12.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第十二题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner12.setAdapter(arr_adapter91);

        views.add(vpView12);

        View vpView13 = View.inflate(this,R.layout.test1,null);
        TextView tv131 = (TextView) vpView13.findViewById(R.id.text91);
        TextView tv132 = (TextView) vpView13.findViewById(R.id.text92);
        TextView tv133 = (TextView) vpView13.findViewById(R.id.text93);
        TextView tv134 = (TextView) vpView13.findViewById(R.id.text94);
        TextView tv135 = (TextView) vpView13.findViewById(R.id.text95);




        tv131.setText("（5分）13. "+Stbt1[12]);
        tv132.setText("A. "+AnswerA1[12]);
        tv133.setText("B. "+AnswerB1[12]);
        tv134.setText("C. "+AnswerC1[12]);
        tv135.setText("D. "+AnswerD1[12]);

        spinner13 = (Spinner) vpView13.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第十三题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner13.setAdapter(arr_adapter91);

        views.add(vpView13);

        View vpView14 = View.inflate(this,R.layout.test1,null);
        TextView tv141 = (TextView) vpView14.findViewById(R.id.text91);
        TextView tv142 = (TextView) vpView14.findViewById(R.id.text92);
        TextView tv143 = (TextView) vpView14.findViewById(R.id.text93);
        TextView tv144 = (TextView) vpView14.findViewById(R.id.text94);
        TextView tv145 = (TextView) vpView14.findViewById(R.id.text95);




        tv141.setText("（5分）14. "+Stbt1[13]);
        tv142.setText("A. "+AnswerA1[13]);
        tv143.setText("B. "+AnswerB1[13]);
        tv144.setText("C. "+AnswerC1[13]);
        tv145.setText("D. "+AnswerD1[13]);

        spinner14 = (Spinner) vpView14.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第十四题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner14.setAdapter(arr_adapter91);

        views.add(vpView14);
        View vpView15 = View.inflate(this,R.layout.test1,null);
        TextView tv151 = (TextView) vpView15.findViewById(R.id.text91);
        TextView tv152 = (TextView) vpView15.findViewById(R.id.text92);
        TextView tv153 = (TextView) vpView15.findViewById(R.id.text93);
        TextView tv154 = (TextView) vpView15.findViewById(R.id.text94);
        TextView tv155 = (TextView) vpView15.findViewById(R.id.text95);




        tv151.setText("（5分）15. "+Stbt1[14]);
        tv152.setText("A. "+AnswerA1[14]);
        tv153.setText("B. "+AnswerB1[14]);
        tv154.setText("C. "+AnswerC1[14]);
        tv155.setText("D. "+AnswerD1[14]);

        spinner15 = (Spinner) vpView15.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第十五题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner15.setAdapter(arr_adapter91);

        views.add(vpView15);

        View vpView16 = View.inflate(this,R.layout.test1,null);
        TextView tv161 = (TextView) vpView16.findViewById(R.id.text91);
        TextView tv162 = (TextView) vpView16.findViewById(R.id.text92);
        TextView tv163 = (TextView) vpView16.findViewById(R.id.text93);
        TextView tv164 = (TextView) vpView16.findViewById(R.id.text94);
        TextView tv165 = (TextView) vpView16.findViewById(R.id.text95);




        tv161.setText("（5分）16. "+Stbt1[15]);
        tv162.setText("A. "+AnswerA1[15]);
        tv163.setText("B. "+AnswerB1[15]);
        tv164.setText("C. "+AnswerC1[15]);
        tv165.setText("D. "+AnswerD1[15]);

        spinner16 = (Spinner) vpView16.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第十六题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner16.setAdapter(arr_adapter91);

        views.add(vpView16);

        View vpView17 = View.inflate(this,R.layout.test1,null);
        TextView tv171 = (TextView) vpView17.findViewById(R.id.text91);
        TextView tv172 = (TextView) vpView17.findViewById(R.id.text92);
        TextView tv173 = (TextView) vpView17.findViewById(R.id.text93);
        TextView tv174 = (TextView) vpView17.findViewById(R.id.text94);
        TextView tv175 = (TextView) vpView17.findViewById(R.id.text95);




        tv171.setText("（5分）17. "+Stbt1[16]);
        tv172.setText("A. "+AnswerA1[16]);
        tv173.setText("B. "+AnswerB1[16]);
        tv174.setText("C. "+AnswerC1[16]);
        tv175.setText("D. "+AnswerD1[16]);

        spinner17 = (Spinner) vpView17.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第十七题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner17.setAdapter(arr_adapter91);

        views.add(vpView17);

        View vpView18 = View.inflate(this,R.layout.test1,null);
        TextView tv181 = (TextView) vpView18.findViewById(R.id.text91);
        TextView tv182 = (TextView) vpView18.findViewById(R.id.text92);
        TextView tv183 = (TextView) vpView18.findViewById(R.id.text93);
        TextView tv184 = (TextView) vpView18.findViewById(R.id.text94);
        TextView tv185 = (TextView) vpView18.findViewById(R.id.text95);




        tv181.setText("（5分）18. "+Stbt1[17]);
        tv182.setText("A. "+AnswerA1[17]);
        tv183.setText("B. "+AnswerB1[17]);
        tv184.setText("C. "+AnswerC1[17]);
        tv185.setText("D. "+AnswerD1[17]);

        spinner18 = (Spinner) vpView18.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第十八题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner18.setAdapter(arr_adapter91);

        views.add(vpView18);

        View vpView19 = View.inflate(this,R.layout.test1,null);
        TextView tv191 = (TextView) vpView19.findViewById(R.id.text91);
        TextView tv192 = (TextView) vpView19.findViewById(R.id.text92);
        TextView tv193 = (TextView) vpView19.findViewById(R.id.text93);
        TextView tv194 = (TextView) vpView19.findViewById(R.id.text94);
        TextView tv195 = (TextView) vpView19.findViewById(R.id.text95);




        tv191.setText("（5分）19. "+Stbt1[18]);
        tv192.setText("A. "+AnswerA1[18]);
        tv193.setText("B. "+AnswerB1[18]);
        tv194.setText("C. "+AnswerC1[18]);
        tv195.setText("D. "+AnswerD1[18]);

        spinner19 = (Spinner) vpView19.findViewById(R.id.spinner91);

        data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第十九题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

        arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner19.setAdapter(arr_adapter91);

        views.add(vpView19);

           View vpView20 = View.inflate(this,R.layout.test1,null);
    TextView tv201 = (TextView) vpView20.findViewById(R.id.text91);
    TextView tv202 = (TextView) vpView20.findViewById(R.id.text92);
    TextView tv203 = (TextView) vpView20.findViewById(R.id.text93);
    TextView tv204 = (TextView) vpView20.findViewById(R.id.text94);
    TextView tv205 = (TextView) vpView20.findViewById(R.id.text95);




        tv201.setText("（5分）20. "+Stbt1[19]);
        tv202.setText("A. "+AnswerA1[19]);
        tv203.setText("B. "+AnswerB1[19]);
        tv204.setText("C. "+AnswerC1[19]);
        tv205.setText("D. "+AnswerD1[19]);

    spinner20 = (Spinner) vpView20.findViewById(R.id.spinner91);

    data_list91 = new ArrayList<String>();
        data_list91.add("请选择您的第二十题答案");
        data_list91.add("A");
        data_list91.add("B");
        data_list91.add("C");
        data_list91.add("D");

    arr_adapter91= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list91);
        arr_adapter91.setDropDownViewResource(R.layout.dropdown_style);
        spinner20.setAdapter(arr_adapter91);

        views.add(vpView20);
//        }
//
//            View tab01 = mInflater.inflate(R.layout.tab01, null);
//            View tab02 = mInflater.inflate(R.layout.tab01, null);
//            views.add(tab01);
//        views.add(tab02);



    MyPagerAdapter adapter = new MyPagerAdapter(views);
        viewPager11.setAdapter(adapter);
}






}

