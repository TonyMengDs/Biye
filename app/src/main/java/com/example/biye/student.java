package com.example.biye;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;


public class student extends AppCompatActivity implements View.OnClickListener{
    private List<View> views = new ArrayList<View>();
    private ViewPager viewPager;
    private LinearLayout llChat, llFriends, llContacts;
    private TextView tvChat, tvFriends, tvContacts,tvCurrent;
    private String data11[] = {"计算机基础","操作系统","Excel基础","Excel公式","Excel函数","Excel查找函数","Excel数据分析","Excel图表","计算机网络基础","信息安全","数据库应用","Excel基本操作","SQL案例"};//假数据
    TextView textView31,textView32,textView33,textView34,textView35,textView36,textView37,textView38;
    private EditText editText31,editText32,editText33,editText34;
    private String Zh,Name,Sex,College,Major,Bj,Code,IDCard,Phone;
    public static  Handler handler;
    private ListView listView21;
    private Adapter adapter21;
    private   String[] Sjmc;
    private String[] Zjmc;
    private int q;
    private String data21[] ={"1","2","3"};
    private String Xh1,Name1,Sex1,College1,Major1,Bj1,IDCard1,Phone1;
    private String Zh1,Sjbh9;
    private String Xxrq;
    protected  ListView mListView;
    protected SimpleAdapter mAdapter;
    protected List<Map<String,Object>> mList = new ArrayList<>();
//    private List<Kaoshi> KaoshiList = new ArrayList<Kaoshi>();
//    private BaseAdapter adapter;
//    private TextView textViewgg;
//Calendar cl = Calendar.getInstance();
//int year =

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);

        Time t=new Time();
        t.setToNow();
        int year = t.year;
        int month = t.month+1;
        int day = t.monthDay;
        int total = year*10000+month*100+day;
        Xxrq = String.valueOf(total);
//        textViewgg =findViewById(R.id.textViewgg);

        Intent intent321 =getIntent();
        Zh1 = intent321.getStringExtra("Zh");


        new Thread(runnable).start();








    }

    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle data = new Bundle();
            data = msg.getData();

            listView21=(ListView)findViewById(R.id.listview21);
            Sjmc = new String[data.getInt("I")];
            Zjmc = new String[data.getInt("Z")];
            q = data.getInt("Z");
            int w;
            for(w=0;w<data.getInt("I");w++)
            {
//                Kaoshi ks = new Kaoshi();
//                ks.setSjmc(data.getStringArray("Sjmc")[w]);
//                System.out.println(data.getStringArray("Sjmc")[w]);
                Sjmc[w] =data.getStringArray("Sjmc")[w];
//                System.out.println(Sjmc[w]);
//                KaoshiList.add(ks);
            }
            int c;
            for(c=0;c<data.getInt("Z");c++)
            {
                Zjmc[c]=data.getStringArray("Zjmc")[c];
            }
            Xh1=data.getString("Xh");
            Name1=data.getString("Name");
            Sex1=data.getString("Sex");
            College1=data.getString("College");
            Major1=data.getString("Major");
            Bj1=data.getString("Bj");
            IDCard1=data.getString("IDCard");
            Phone1=data.getString("Phone");

            initView();

            initData();
//            adapter = new BaseAdapter() {
//                @Override
//                public int getCount() {
//                    return KaoshiList.size();
//                }
//
//                @Override
//                public Object getItem(int i) {
//                    return null;
//                }
//
//                @Override
//                public long getItemId(int i) {
//                    return 0;
//                }
//
//                @Override
//                public View getView(int i, View convertView, ViewGroup viewGroup) {
//                    LayoutInflater inflater=student.this.getLayoutInflater();
//                    View view;
//                    if(convertView==null){
//                        view = inflater.inflate(R.layout.item1,null);
//                    }
//                    else{
//                        view=convertView;
//
//                    }
//                    textViewgg = (TextView)view.findViewById(R.id.textViewgg);
////                    textViewdd.setText("1");
////
//                    textViewgg.setText(KaoshiList.get(i).getSjmc());
//
//                    return view;
//
//
//                }
//            };
//
//
//
//            listView21.setAdapter(adapter);


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
                String[] Sjmc;
                String[] Sjbh;
                String[] Zjmc;
                String Xh=null,Name=null,Sex=null,College=null,Major=null,Bj=null,IDCard=null,Phone=null;
                int i=0;
                String sql = "SELECT DISTINCT Sjbh,Sjmc FROM  Paper ";        //查询表名为“user”的所有内容
                Statement stmt = con1.createStatement();        //创建Statement
                ResultSet rs = stmt.executeQuery(sql);          //ResultSet类似Cursor
                Sjmc = new String[100];
                Sjbh = new String[100];
                Zjmc = new String[100];
                //<code>ResultSet</code>最初指向第一行
                Bundle bundle = new Bundle();
                while (rs.next()) {

                    Sjbh[i]=rs.getString("Sjbh");
                    Sjmc[i] =rs.getString("Sjmc");
                    i++;
                }
                int z=0;
                String sql2 = "SELECT DISTINCT Zjmc FROM  Chapter  WHERE Zjbh in (SELECT Zjbh FROM Study WHERE Xh='"+Zh1+"')";
                Statement stmt2 = con1.createStatement();        //创建Statement
                ResultSet rs2 = stmt2.executeQuery(sql2);
                while(rs2.next())
                {
                    Zjmc[z]=rs2.getString("Zjmc");
                    z++;
                }

                String sql1 = "SELECT Xh,Name,Sex,College,Major,Class,IDCard,Phone FROM  Student  WHERE Xh='"+Zh1+"'";
                Statement stmt1 = con1.createStatement();        //创建Statement
                ResultSet rs1 = stmt1.executeQuery(sql1);
                while(rs1.next()){
                    Xh = rs1.getString("Xh");
                    Name = rs1.getString("Name");
                    Sex = rs1.getString("Sex");
                    College = rs1.getString("College");
                    Major = rs1.getString("Major");
                    Bj = rs1.getString("Class");
                    IDCard = rs1.getString("IDCard");
                    Phone = rs1.getString("Phone");
                    System.out.println(Xh);
                    System.out.println(Name);
                    System.out.println(Sex);
                }
                bundle.clear();
                bundle.putStringArray("Sjmc", Sjmc);
                bundle.putStringArray("Sjbh", Sjbh);
                bundle.putStringArray("Zjmc", Zjmc);
                bundle.putString("Xh",Xh);
                bundle.putString("Name",Name);
                bundle.putString("Sex",Sex);
                bundle.putString("College",College);
                bundle.putString("Major",Major);
                bundle.putString("Bj",Bj);
                bundle.putString("IDCard",IDCard);
                bundle.putString("Phone",Phone);
                bundle.putInt("I",i);
                bundle.putInt("Z",z);
//                bundle.putString("Sjmc", rs.getString("Sjmc"));
//                bundle.putString("Grade", rs.getString("Grade"));
                Message msg = new Message();
                msg.setData(bundle);
                myHandler.sendMessage(msg);

                rs.close();
                stmt.close();
                rs1.close();
                stmt1.close();
                rs2.close();
                stmt2.close();

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
                    Intent intent1 = new Intent(student.this, MainActivity.class);
                    startActivity(intent1);
                    break;
                default:
                    break;
            }
            return true;
        }


    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        llChat = (LinearLayout) findViewById(R.id.llChat);
        llFriends = (LinearLayout) findViewById(R.id.llFriends);
        llContacts = (LinearLayout) findViewById(R.id.llContacts);





        tvChat = (TextView) findViewById(R.id.tvChat);
        tvFriends = (TextView) findViewById(R.id.tvFriends);
        tvContacts = (TextView) findViewById(R.id.tvContacts);


        tvChat.setOnClickListener(this);
        tvFriends.setOnClickListener(this);
        tvContacts.setOnClickListener(this);

        tvChat.setSelected(true);
        tvCurrent = tvChat;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                changeTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    private void initData() {
        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01 = mInflater.inflate(R.layout.tab01, null);
        View tab02 = mInflater.inflate(R.layout.tab02, null);
        View tab03 = mInflater.inflate(R.layout.tab03, null);

        ListView listView11 = (ListView) tab01.findViewById(R.id.listview11);//在视图中找到ListView
//
        mListView =(ListView)tab01.findViewById(R.id.listview11);
        mAdapter = new SimpleAdapter(this,mList,R.layout.vlist,new String[]{"title"},new int[]{R.id.title})
        {
            @Override
            public View getView(int position,View convertView,ViewGroup parent){
                View view = super.getView(position,convertView,parent);
                Boolean isFocus = (Boolean)mList.get(position).get("isfocus");
                if(isFocus){
//                    view.setBackgroundColor(Color.GREEN);
                    view.setBackgroundResource(R.drawable.biaoqian5);
                }else
                {
                    view.setBackgroundResource(R.drawable.biaoqian4);
                }
                return view;
            }
        };
        for(int i=0;i<13;i++){
            Map<String,Object> map = new HashMap <String,Object>();
            map.put("title",data11[i]);
            map.put("isfocus",false);
            mList.add(map);
        }
        mAdapter.notifyDataSetChanged();
        mListView.setAdapter(mAdapter);
//        final ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data11);//新建并配置ArrayAapeter
//        listView11.setAdapter(adapter11);
//        MyBaseAdapter mBaseAdapter = new MyBaseAdapter(getApplicationContext(),data11);
//        listView11.setAdapter(mBaseAdapter);


        int c;
        for(c=0;c<q;c++)
        {
            if (data11[0].equals(Zjmc[c]))
            {
                mList.get(0).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[1].equals(Zjmc[c]))
            {
                mList.get(1).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[2].equals(Zjmc[c]))
            {
                mList.get(2).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[3].equals(Zjmc[c]))
            {
                mList.get(3).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[4].equals(Zjmc[c]))
            {
                mList.get(4).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[5].equals(Zjmc[c]))
            {
                mList.get(5).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[6].equals(Zjmc[c]))
            {
                mList.get(6).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[7].equals(Zjmc[c]))
            {
                mList.get(7).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[8].equals(Zjmc[c]))
            {
                mList.get(8).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[9].equals(Zjmc[c]))
            {
                mList.get(9).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[10].equals(Zjmc[c]))
            {
                mList.get(10).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[11].equals(Zjmc[c]))
            {
                mList.get(11).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
        for(c=0;c<q;c++)
        {
            if (data11[12].equals(Zjmc[c]))
            {
                mList.get(12).put("isfocus",true);
                mAdapter.notifyDataSetChanged();
//                View view1 =listView11.getChildAt(1);
//                view1.setBackgroundColor(Color.GREEN);
            }
        }
//        for(c=0;c<q;c++)
//        {
//            if (adapter11.getItem(1-listView11.getFirstVisiblePosition()).equals(Zjmc[c]))
//            {
//                View view2 =listView11.getChildAt(1-listView11.getFirstVisiblePosition());
//                view2.setBackgroundColor(Color.GREEN);
//            }
//        }
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent intent991 = new Intent(student.this,jsjjc.class);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        intent991.putExtra("Zh",Xh1);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",1)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent991.putExtra("Name",Name);
//                        intent991.putExtra("Sex",Sex);
//                        intent991.putExtra("College",College);
//                        intent991.putExtra("Major",Major);
//                        intent991.putExtra("Bj",Bj);
//                        intent991.putExtra("IDCard",IDCard);
//                        intent991.putExtra("Phone",Phone);
                        startActivity(intent991);
                        break;
                    case 1:
                        Intent intent992 = new Intent(student.this,czxt.class);
                        intent992.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",2)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent992.putExtra("Name",Name);
//                        intent992.putExtra("Sex",Sex);
//                        intent992.putExtra("College",College);
//                        intent992.putExtra("Major",Major);
//                        intent992.putExtra("Bj",Bj);
//                        intent992.putExtra("IDCard",IDCard);
//                        intent992.putExtra("Phone",Phone);
                        startActivity(intent992);
                        break;
                    case 2:
                        Intent intent993 = new Intent(student.this,exceljc.class);
                        intent993.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",3)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent993.putExtra("Name",Name);
//                        intent993.putExtra("Sex",Sex);
//                        intent993.putExtra("College",College);
//                        intent993.putExtra("Major",Major);
//                        intent993.putExtra("Bj",Bj);
//                        intent993.putExtra("IDCard",IDCard);
//                        intent993.putExtra("Phone",Phone);
                        startActivity(intent993);
                        break;
                    case 3:
                        Intent intent994 = new Intent(student.this,excelgs.class);
                        intent994.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",4)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent994.putExtra("Name",Name);
//                        intent994.putExtra("Sex",Sex);
//                        intent994.putExtra("College",College);
//                        intent994.putExtra("Major",Major);
//                        intent994.putExtra("Bj",Bj);
//                        intent994.putExtra("IDCard",IDCard);
//                        intent994.putExtra("Phone",Phone);
                        startActivity(intent994);
                        break;
                    case 4:
                        Intent intent995 = new Intent(student.this,excelhs.class);
                        intent995.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",5)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent995.putExtra("Name",Name);
//                        intent995.putExtra("Sex",Sex);
//                        intent995.putExtra("College",College);
//                        intent995.putExtra("Major",Major);
//                        intent995.putExtra("Bj",Bj);
//                        intent995.putExtra("IDCard",IDCard);
//                        intent995.putExtra("Phone",Phone);
                        startActivity(intent995);
                        break;
                    case 5:
                        Intent intent996 = new Intent(student.this,excelczhs.class);
                        intent996.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",6)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent996.putExtra("Name",Name);
//                        intent996.putExtra("Sex",Sex);
//                        intent996.putExtra("College",College);
//                        intent996.putExtra("Major",Major);
//                        intent996.putExtra("Bj",Bj);
//                        intent996.putExtra("IDCard",IDCard);
//                        intent996.putExtra("Phone",Phone);
                        startActivity(intent996);
                        break;
                    case 6:
                        Intent intent997 = new Intent(student.this,excelsjfx.class);
                        intent997.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",7)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent997.putExtra("Name",Name);
//                        intent997.putExtra("Sex",Sex);
//                        intent997.putExtra("College",College);
//                        intent997.putExtra("Major",Major);
//                        intent997.putExtra("Bj",Bj);
//                        intent997.putExtra("IDCard",IDCard);
//                        intent997.putExtra("Phone",Phone);
                        startActivity(intent997);
                        break;
                    case 7:
                        Intent intent998 = new Intent(student.this,exceltb.class);
                        intent998.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",8)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent998.putExtra("Name",Name);
//                        intent998.putExtra("Sex",Sex);
//                        intent998.putExtra("College",College);
//                        intent998.putExtra("Major",Major);
//                        intent998.putExtra("Bj",Bj);
//                        intent998.putExtra("IDCard",IDCard);
//                        intent998.putExtra("Phone",Phone);
                        startActivity(intent998);
                        break;
                    case 8:
                        Intent intent999 = new Intent(student.this,jsjwljc.class);
                        intent999.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",9)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent999.putExtra("Name",Name);
//                        intent999.putExtra("Sex",Sex);
//                        intent999.putExtra("College",College);
//                        intent999.putExtra("Major",Major);
//                        intent999.putExtra("Bj",Bj);
//                        intent999.putExtra("IDCard",IDCard);
//                        intent999.putExtra("Phone",Phone);
                        startActivity(intent999);
                        break;
                    case 9:
                        Intent intent981 = new Intent(student.this,xxaq.class);
                        intent981.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",10)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent981.putExtra("Name",Name);
//                        intent981.putExtra("Sex",Sex);
//                        intent981.putExtra("College",College);
//                        intent981.putExtra("Major",Major);
//                        intent981.putExtra("Bj",Bj);
//                        intent981.putExtra("IDCard",IDCard);
//                        intent981.putExtra("Phone",Phone);
                        startActivity(intent981);
                        break;
                    case 10:
                        Intent intent971 = new Intent(student.this,sjkyy.class);
                        intent971.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",11)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent971.putExtra("Name",Name);
//                        intent971.putExtra("Sex",Sex);
//                        intent971.putExtra("College",College);
//                        intent971.putExtra("Major",Major);
//                        intent971.putExtra("Bj",Bj);
//                        intent971.putExtra("IDCard",IDCard);
//                        intent971.putExtra("Phone",Phone);
                        startActivity(intent971);
                        break;
                    case 11:
                        Intent intent961 = new Intent(student.this,exceljbcj.class);
                        intent961.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",12)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent961.putExtra("Name",Name);
//                        intent961.putExtra("Sex",Sex);
//                        intent961.putExtra("College",College);
//                        intent961.putExtra("Major",Major);
//                        intent961.putExtra("Bj",Bj);
//                        intent961.putExtra("IDCard",IDCard);
//                        intent961.putExtra("Phone",Phone);
                        startActivity(intent961);
                        break;
                    case 12:
                        Intent intent661 = new Intent(student.this,sqlal.class);
                        intent661.putExtra("Zh",Xh1);
                        view.setBackgroundResource(R.drawable.biaoqian5);
                        new Thread() {
                            @Override
                            public void run() {
                                Looper.prepare();
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                java.sql.Connection cn = null;
                                try {
                                    cn = DriverManager.getConnection(url, username, password);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                PreparedStatement stmt = null;
                                String sql12 = "INSERT INTO Study VALUES("+Xxrq+","+Zh1+",13)";
                                try {
                                    stmt = cn.prepareStatement(sql12);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    stmt.execute();// 返回值代表收到影响的行数
                                    Toast.makeText(student.this, "您的学习信息已经更新", Toast.LENGTH_SHORT).show();
                                    stmt.close();
                                    cn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                Looper.loop();
                            }
                        }.start();
//                        intent961.putExtra("Name",Name);
//                        intent961.putExtra("Sex",Sex);
//                        intent961.putExtra("College",College);
//                        intent961.putExtra("Major",Major);
//                        intent961.putExtra("Bj",Bj);
//                        intent961.putExtra("IDCard",IDCard);
//                        intent961.putExtra("Phone",Phone);
                        startActivity(intent661);
                        break;
                }
            }
        });

        final ListView listView21 = (ListView) tab02.findViewById(R.id.listview21);//在视图中找到ListView

       final ArrayAdapter<String> adapter21 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Sjmc);//新建并配置ArrayAapeter

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
//                String sql12 = "SELECT DISTINCT(Sjbh) FROM Paper";
//                try {
//                    stmt = cn.prepareStatement(sql12);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    ResultSet rs112 = stmt.executeQuery();// 返回值代表收到影响的行数
//                    List<String> list = new ArrayList<String>();
//                    while(rs112.next())
//                    {
//                        list.add(rs112.getString(1));
//                    }
//                    if(list!=null&&list.size()>0)
//                    {
//                        data21 =new String[list.size()];
//                        for(int i=0;i<list.size();i++)
//                        {
//                            data21[i]=list.get(i);
//                            Log.i("MainActivity",data21[i]);
//                        }
//
//                    }
//                    rs112.close();
//                    stmt.close();
//                    cn.close();
//
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                Looper.loop();
//            }
//        }.start();
//
        listView21.setAdapter(adapter21);

        listView21.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Sjmc3 = adapter21.getItem(i);

                Sjbh9 = String.valueOf(i+1);
                Intent intent886 = new Intent(student.this, test.class);
                intent886.putExtra("Sjbh",Sjbh9);
                intent886.putExtra("Xh",Xh1);
                intent886.putExtra("Sjmc3",Sjmc3);
                startActivity(intent886);
            }
        });

        textView31 = tab03.findViewById(R.id.textView31);
        textView32 = tab03.findViewById(R.id.textView32);
        textView33 = tab03.findViewById(R.id.textView33);
        textView34 = tab03.findViewById(R.id.textView34);
        editText31 = tab03.findViewById(R.id.editText31);
        editText32 = tab03.findViewById(R.id.editText32);
        editText33 = tab03.findViewById(R.id.editText33);
        editText34 = tab03.findViewById(R.id.editText34);
        textView31.setText(Xh1);
        textView32.setText(Name1);
        textView33.setText(Sex1);
        textView34.setText(IDCard1);
        editText31.setText(College1);
        editText32.setText(Major1);
        editText33.setText(Bj1);
        editText34.setText(Phone1);
//        Intent intent9111 =getIntent();
//        Zh = intent9111.getStringExtra("Zh");
//        new Thread() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                try {
//                    Intent intent321 =getIntent();
//                    Zh = intent321.getStringExtra("Zh");
//
//                    textView31.setText(Zh);
//                    Class.forName("com.mysql.jdbc.Driver");
//                    String url = "jdbc:mysql://192.168.50.64:3306/biye";
//                    String username = "root";
//                    String password = "123456";
//                    Connection cn = DriverManager.getConnection(url, username, password);
//                    String sql = "select Name from Student where Xh=" + Zh;
//                    Statement st = (Statement) cn.createStatement();
//                    ResultSet rs = st.executeQuery(sql);
//                    while (rs.next()) {
//                        Name = rs.getString("Name");
//                        Log.i("Mainactivity", Name);
//                        textView32.setText(Name);
//                    }
//                    st.close();
//                    rs.close();
//                    String sql1 = "select Sex from Student where Xh=" + Zh;
//                    Statement st1= (Statement) cn.createStatement();
//                    ResultSet rs1 = st1.executeQuery(sql1);
//                    while (rs1.next()) {
//                        Sex = rs1.getString("Sex");
//                        Log.i("Mainactivity", Sex);
//                        textView33.setText(Sex);
//                    }
//                    st1.close();
//                    rs1.close();
//                    String sql2 = "select College from Student where Xh=" + Zh;
//                    Statement st2= (Statement) cn.createStatement();
//                    ResultSet rs2 = st2.executeQuery(sql2);
//                    while (rs2.next()) {
//                        College = rs2.getString("College");
//                        Log.i("Mainactivity", College);
//                        textView34.setText(College);
//                    }
//                    st2.close();
//                    rs2.close();
//                    String sql3 = "select Major from Student where Xh=" + Zh;
//                    Statement st3= (Statement) cn.createStatement();
//                    ResultSet rs3 = st3.executeQuery(sql3);
//                    while (rs3.next()) {
//                        Major = rs3.getString("Major");
//                        Log.i("Mainactivity", Major);
//                        textView35.setText(Major);
//                    }
//                    st3.close();
//                    rs3.close();
//                    String sql4 = "select Class from Student where Xh=" + Zh;
//                    Statement st4= (Statement) cn.createStatement();
//                    ResultSet rs4 = st4.executeQuery(sql4);
//                    while (rs4.next()) {
//                        Bj = rs4.getString("Class");
//                        Log.i("Mainactivity", Bj);
//                        textView36.setText(Bj);
//                    }
//                    st4.close();
//                    rs4.close();
//                    String sql5 = "select IDCard from Student where Xh=" + Zh;
//                    Statement st5= (Statement) cn.createStatement();
//                    ResultSet rs5 = st5.executeQuery(sql5);
//                    while (rs5.next()) {
//                        IDCard = rs5.getString("IDCard");
//                        Log.i("Mainactivity", IDCard);
//                        textView37.setText(IDCard);
//                    }
//                    st5.close();
//                    rs5.close();
//                    String sql6 = "select Phone from Student where Xh=" + Zh;
//                    Statement st6= (Statement) cn.createStatement();
//                    ResultSet rs6 = st6.executeQuery(sql6);
//                    while (rs6.next()) {
//                        Phone = rs6.getString("Phone");
//                        Log.i("Mainactivity", Phone);
//                        editText31.setText(Phone);
//                    }
//                    st6.close();
//                    rs6.close();
//                    cn.close();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//
//                }
//                Looper.loop();
//            }
//        }.start();
//        textView31.setText("41610076");
//        textView32.setText("孟啸东");
//        textView33.setText("男");
//        textView34.setText("经济信息工程学院");
//        textView35.setText("计算机科学与技术");
//        textView36.setText("二班");
//        textView37.setText("510502199802042222");
//        editText31.setHint("15283026368");
        Button button31 = tab03.findViewById(R.id.button31);
        button31.setOnClickListener(this);


        views.add(tab01);
        views.add(tab02);
        views.add(tab03);

        MyPagerAdapter adapter = new MyPagerAdapter(views);
        viewPager.setAdapter(adapter);
    }


    public void addDataToList(){
            for(int i=0;i<12;i++){
                Map<String,Object> map = new HashMap <String,Object>();
                map.put("title",data11[i]);
                map.put("isfocus",false);
                mList.add(map);
            }
            mAdapter.notifyDataSetChanged();
    }
    public void setItemBGColorBlue(int position){
            mList.get(position).put("isfocus",true);
            mAdapter.notifyDataSetChanged();
    }



        public void onClick(View v) {
        changeTab(v.getId());
    }

    private void changeTab(int id) {
        tvCurrent.setSelected(false);
        switch (id) {
            case R.id.tvChat:
                viewPager.setCurrentItem(0);
            case 0:
                tvChat.setSelected(true);
                tvCurrent = tvChat;
                break;
            case R.id.tvFriends:
                viewPager.setCurrentItem(1);
            case 1:
                tvFriends.setSelected(true);
                tvCurrent = tvFriends;
                break;
            case R.id.tvContacts:
                viewPager.setCurrentItem(2);
            case 2:
                tvContacts.setSelected(true);
                tvCurrent = tvContacts;
                break;
            case R.id.button31:
                String College = editText31.getText()+"";
                String Major = editText32.getText()+"";
                String Bj = editText33.getText()+"";
                String Phone = editText34.getText()+"";
                if(College.equals(""))
                {
                    editText31.setHint("请输入学院，不能为空");
                    return;
                }
                else if(Major.equals(""))
                {
                    editText32.setHint("请输入专业，不能为空");
                    return;
                }
                else if(Bj.equals(""))
                {
                    editText33.setHint("请输入班级，不能为空");
                    return;
                }
                else if(Phone.equals(""))
                {
                    editText34.setHint("请输入电话，不能为空");
                    return;
                }
                else if(!College.equals("")&&!Major.equals("")&&!Bj.equals("")&&!Phone.equals("")){
                    new Thread() {
                        @Override
                        public void run() {
                            Looper.prepare();
                            String College = editText31.getText()+"";
                            String Major = editText32.getText()+"";
                            String Bj = editText33.getText()+"";
                            String Phone = editText34.getText() + "";
                            String Zh = textView31.getText() + "";
                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
//                            String url = "jdbc:mysql://172.20.10.2:3306/biye";
                            String url = "jdbc:mysql://192.168.50.64:3306/biye";
                            String username = "root";
                            String password = "123456";
                            java.sql.Connection cn = null;
                            try {
                                cn = DriverManager.getConnection(url, username, password);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            PreparedStatement stmt = null;
                            String sql12 = "update Student set College='"+College+"',Major='"+Major+"',Class='"+Bj+"', Phone='" + Phone + "' where Xh='" + Zh + "'";
                            try {
                                stmt = cn.prepareStatement(sql12);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            try {
                                stmt.execute();// 返回值代表收到影响的行数
                                Toast.makeText(student.this, "您的信息已经更改成功", Toast.LENGTH_SHORT).show();
                                stmt.close();
                                cn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            Intent intent71 = new Intent(student.this, student.class);
                            intent71.putExtra("Zh",Zh);
                            intent71.putExtra("Name",Name);
                            intent71.putExtra("Sex",Sex);
                            intent71.putExtra("College",College);
                            intent71.putExtra("Major",Major);
                            intent71.putExtra("Bj",Bj);
                            intent71.putExtra("IDCard",IDCard);
                            intent71.putExtra("Phone",Phone);
                            startActivity(intent71);
                            Looper.loop();
                        }
                    }.start();
                }
                break;
            default:
                break;
        }
    }
//
//
//
//        Handler myHandler = new Handler() {
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//
//                Bundle data = new Bundle();
//                data = msg.getData();
//
//
//                Sjmc = new String[data.getInt("I")];
//                int w;
//                for(w=0;w<data.getInt("I");w++)
//                {
//
//                    System.out.println(data.getStringArray("Sjmc")[w]);
//                    System.out.println(data.getStringArray("Grade")[w]);
//                    Sjmc[w] =data.getStringArray("Sjmc")[w];
//                    System.out.println(Sjmc[w]);
//
//                }
//
//            }
//        };
//        Runnable runnable = new Runnable() {
//            private Connection connection = null;
//
//            @Override
//            public void run() {
//                try {
//                    Class.forName("com.mysql.jdbc.Driver");
//                    connection = DriverManager.getConnection("jdbc:mysql://192.168.50.64:3306/biye", "root", "123456");
//                    System.out.print("连接成功");
//                } catch (ClassNotFoundException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//                try {
//                    test(connection);    //测试数据库连接
//                } catch (java.sql.SQLException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//
//            public void test(Connection con1) throws java.sql.SQLException {
//                try {
//                    String[] Sjmc;
//                    int i=0;
//                    String sql = "SELECT DISTINCT Sjmc FROM  Paper ";        //查询表名为“user”的所有内容
//                    Statement stmt = con1.createStatement();        //创建Statement
//                    ResultSet rs = stmt.executeQuery(sql);          //ResultSet类似Cursor
//                    Sjmc = new String[100];
//                    //<code>ResultSet</code>最初指向第一行
//                    Bundle bundle = new Bundle();
//                    while (rs.next()) {
//
//                        Sjmc[i] =rs.getString("Sjmc");
//                        i++;
//                    }
//                    bundle.clear();
//                    bundle.putStringArray("Sjmc", Sjmc);
//                    bundle.putInt("I",i);
////                bundle.putString("Sjmc", rs.getString("Sjmc"));
////                bundle.putString("Grade", rs.getString("Grade"));
//                    Message msg = new Message();
//                    msg.setData(bundle);
//                    myHandler.sendMessage(msg);
//
//                    rs.close();
//                    stmt.close();
//
//
//                } catch (SQLException e) {
//
//                } finally {
//                    if (con1 != null)
//                        try {
//                            con1.close();
//                        } catch (SQLException e) {
//                        }
//                }
//            }
//        };

    }


