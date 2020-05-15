package com.example.biye;

import android.content.Intent;
import android.media.MediaExtractor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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


public class teacher extends AppCompatActivity implements View.OnClickListener {
    private List<View> views1 = new ArrayList<View>();
    private ViewPager viewPager1;
    private LinearLayout llChat1, llFriends1, llContacts1,llMine1,llStudent1;
    private TextView tvChat1, tvFriends1, tvContacts1,tvMine1,tvStudent1,tvCurrent1;
    private EditText editText61,editText62,editText63,editText64,editText65;
    private Spinner spinner61,spinner62,spinner63;
    private List<String> data_list61,data_list62,data_list63;
    private ArrayAdapter<String> arr_adapter61,arr_adapter62,arr_adapter63;
    TextView textView71,textView72,textView73,textView74,textView75,textView76;
    private EditText editText51;
    private Spinner spinner51,spinner52,spinner53,spinner54,spinner55;
    private List<String> data_list51,data_list52,data_list53,data_list54,data_list55;
    private ArrayAdapter<String> arr_adapter51,arr_adapter52,arr_adapter53,arr_adapter54,arr_adapter55;
    private EditText editText71,editText72;
    private String data81[] = {"孟啸东","狗小渣哦","查克拉"};//假数据
    private String data41[] = {"计算机基础","操作系统","Excel基础","Excel公式","Excel函数","Excel查找函数","Excel数据分析","Excel图表","计算机网络基础","信息安全","数据库应用","Excel基本操作","SQL案例"};//假数据
    private String Zh,Name,Sex,Pose,Code,IDCard,Phone;
    private int max;
    private ListView listView81;
    private Adapter adapter81;
    private String Gh1,Name1,Sex1,Pose1,IDCard1,Phone1;
    private String Zh1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher);

        Intent intent321 =getIntent();
        Zh1 = intent321.getStringExtra("Zh");
        new Thread(runnable).start();

    }



    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle data = new Bundle();
            data = msg.getData();

            Gh1=data.getString("Gh");
            Name1=data.getString("Name");
            Sex1=data.getString("Sex");
            Pose1=data.getString("Pose");
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
                String Gh=null,Name=null,Sex=null,Pose=null,IDCard=null,Phone=null;
                int i=0;
                Bundle bundle = new Bundle();
                  String sql1 = "SELECT Gh,Name,Sex,Pose,IDCard,Phone FROM  Teacher  WHERE Gh='"+Zh1+"'";
                Statement stmt1 = con1.createStatement();        //创建Statement
                ResultSet rs1 = stmt1.executeQuery(sql1);
                while(rs1.next()){
                    Gh = rs1.getString("Gh");
                    Name = rs1.getString("Name");
                    Sex = rs1.getString("Sex");
                    Pose = rs1.getString("Pose");
                    IDCard = rs1.getString("IDCard");
                    Phone = rs1.getString("Phone");
                    System.out.println(Gh);
                    System.out.println(Name);
                    System.out.println(Sex);
                }
                bundle.clear();
                bundle.putString("Gh",Gh);
                bundle.putString("Name",Name);
                bundle.putString("Sex",Sex);
                bundle.putString("Pose",Pose);
                bundle.putString("IDCard",IDCard);
                bundle.putString("Phone",Phone);
                bundle.putInt("I",i);
//                bundle.putString("Sjmc", rs.getString("Sjmc"));
//                bundle.putString("Grade", rs.getString("Grade"));
                Message msg = new Message();
                msg.setData(bundle);
                myHandler.sendMessage(msg);

                rs1.close();
                stmt1.close();


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
//            case R.id.menu_back41:
//                Intent intent2 = new Intent(teacher.this,upload.class);
//                startActivity(intent2);
//                break;
            case R.id.menu_back:
                Intent intent1 = new Intent(teacher.this, MainActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
        return true;
    }


    private void initView() {
        viewPager1 = (ViewPager) findViewById(R.id.viewPager1);

        llChat1 = (LinearLayout) findViewById(R.id.llChat1);
        llFriends1 = (LinearLayout) findViewById(R.id.llFriends1);
        llContacts1 = (LinearLayout) findViewById(R.id.llContacts1);
        llMine1 = (LinearLayout)findViewById(R.id.llMine1);
        llStudent1 = (LinearLayout)findViewById(R.id.llStudent1);

        llChat1.setOnClickListener((View.OnClickListener) this);
        llFriends1.setOnClickListener((View.OnClickListener) this);
        llContacts1.setOnClickListener((View.OnClickListener) this);
        llMine1.setOnClickListener((View.OnClickListener)this);
        llStudent1.setOnClickListener((View.OnClickListener)this);


        tvChat1 = (TextView) findViewById(R.id.tvChat1);
        tvFriends1 = (TextView) findViewById(R.id.tvFriends1);
        tvContacts1 = (TextView) findViewById(R.id.tvContacts1);
        tvMine1 = (TextView) findViewById(R.id.tvMine1);
        tvStudent1 = (TextView) findViewById(R.id.tvStudent1);

        tvChat1.setSelected(true);
        tvCurrent1 = tvChat1;

        viewPager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

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
        View tab04 = mInflater.inflate(R.layout.tab04, null);
        View tab05 = mInflater.inflate(R.layout.tab05, null);
        View tab06 = mInflater.inflate(R.layout.tab06, null);
        View tab07 = mInflater.inflate(R.layout.tab07, null);
        View tab08 = mInflater.inflate(R.layout.tab08, null);

        Button button61 = tab06.findViewById(R.id.button61);
        button61.setOnClickListener(this);

        editText61 = (EditText)tab06.findViewById(R.id.editText61);
        editText62 = (EditText)tab06.findViewById(R.id.editText62);
        editText63 = (EditText)tab06.findViewById(R.id.editText63);
        editText64 = (EditText)tab06.findViewById(R.id.editText64);
        editText65 = (EditText)tab06.findViewById(R.id.editText65);
        spinner61 = (Spinner) tab06.findViewById(R.id.spinner61);

        spinner62 = (Spinner) tab06.findViewById(R.id.spinner62);
        spinner63 = (Spinner) tab06.findViewById(R.id.spinner63);

        data_list61 = new ArrayList<String>();
        data_list62 = new ArrayList<String>();
        data_list63 = new ArrayList<String>();
        data_list61.add("请选择正确答案");
        data_list61.add("A");
        data_list61.add("B");
        data_list61.add("C");
        data_list61.add("D");
        data_list62.add("请选择分值");
        data_list62.add("5");
        data_list62.add("10");
        data_list63.add("请选择所属章节");
        data_list63.add("计算机基础");
        data_list63.add("操作系统");
        data_list63.add("Excel");
        data_list63.add("SQL");
        data_list63.add("数据分析、图表操作");
        //适配器
        //arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        arr_adapter61= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list61);
        //设置样式
        //arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arr_adapter61.setDropDownViewResource(R.layout.dropdown_style);
        //加载适配器
        spinner61.setAdapter(arr_adapter61);

        arr_adapter62= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list62);
        arr_adapter62.setDropDownViewResource(R.layout.dropdown_style);
        spinner62.setAdapter(arr_adapter62);

        arr_adapter63= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list63);
        arr_adapter63.setDropDownViewResource(R.layout.dropdown_style);
        spinner63.setAdapter(arr_adapter63);
        spinner61.setPrompt("请选择正确答案：");
        spinner62.setPrompt("请选择分值：");
        //editText2 = (EditText)findViewById(R.id.editText2);
        //editText2.setOnFocusChangeListener(this);  //对edit 进行焦点监听
        //editText2.setFocusable(false);
        //editText2.setFocusableInTouchMode(false);
        Button button51 = tab05.findViewById(R.id.button51);
        button51.setOnClickListener(this);

        editText51 = (EditText)tab05.findViewById(R.id.editText51);

        spinner51 = (Spinner) tab05.findViewById(R.id.spinner51);
        spinner52 = (Spinner) tab05.findViewById(R.id.spinner52);
        spinner53 = (Spinner) tab05.findViewById(R.id.spinner53);
        spinner54 = (Spinner) tab05.findViewById(R.id.spinner54);
        spinner55 = (Spinner) tab05.findViewById(R.id.spinner55);




        data_list51 = new ArrayList<String>();
        data_list52 = new ArrayList<String>();
        data_list53 = new ArrayList<String>();
        data_list54 = new ArrayList<String>();
        data_list55 = new ArrayList<String>();

        data_list51.add("计算机基础占比");
        data_list51.add("0");
        data_list51.add("5");
        data_list51.add("10");
        data_list51.add("15");
        data_list51.add("20");
        data_list51.add("25");


        data_list52.add("操作系统占比");
        data_list52.add("0");
        data_list52.add("5");
        data_list52.add("10");
        data_list52.add("15");
        data_list52.add("20");
        data_list52.add("25");


        data_list53.add("Excel占比");
        data_list53.add("0");
        data_list53.add("5");
        data_list53.add("10");
        data_list53.add("15");
        data_list53.add("20");
        data_list53.add("25");



        // data_list54.add("数据分析、图表操作占比");
        data_list54.add("SQL占比");
        data_list54.add("0");
        data_list54.add("5");
        data_list54.add("10");
        data_list54.add("15");
        data_list54.add("20");
        data_list54.add("25");

        data_list55.add("数据分析、图表操作占比");


        arr_adapter51= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list51);
        arr_adapter51.setDropDownViewResource(R.layout.dropdown_style);
        spinner51.setAdapter(arr_adapter51);
        arr_adapter52= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list52);
        arr_adapter52.setDropDownViewResource(R.layout.dropdown_style);
        spinner52.setAdapter(arr_adapter52);
        arr_adapter53= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list53);
        arr_adapter53.setDropDownViewResource(R.layout.dropdown_style);
        spinner53.setAdapter(arr_adapter53);
        arr_adapter54= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list54);
        arr_adapter54.setDropDownViewResource(R.layout.dropdown_style);
        spinner54.setAdapter(arr_adapter54);
        arr_adapter55= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list55);
        arr_adapter55.setDropDownViewResource(R.layout.dropdown_style);
        spinner55.setAdapter(arr_adapter55);

//        spinner51.setOnItemSelectedListener(spinnerSelectedListener);
//        spinner52.setOnItemSelectedListener(spinnerSelectedListener);
//        spinner53.setOnItemSelectedListener(spinnerSelectedListener);
        spinner54.setOnItemSelectedListener(spinnerSelectedListener);
        //       spinner55.setOnItemSelectedListener(spinnerSelectedListener);


        textView71 = tab07.findViewById(R.id.textView71);
        textView72 = tab07.findViewById(R.id.textView72);
        textView73 = tab07.findViewById(R.id.textView73);
        textView74 = tab07.findViewById(R.id.textView74);
        editText72 = tab07.findViewById(R.id.editText72);
        editText71 = tab07.findViewById(R.id.editText71);

        textView71.setText(Gh1);
        textView72.setText(Name1);
        textView73.setText(Sex1);
        textView74.setText(IDCard1);
        editText71.setText(Pose1);
        editText72.setText(Phone1);
//        final Handler handler = new Handler(){
//            @Override
//            public void handleMessage(Message msg){
//                super.handleMessage(msg);
//                if(msg.what ==1)
//                {
//                    String name =(String)msg.obj;
//                    textView72.setText(name);
//                }
//
//            }
//        };
//        new Thread() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                try {
//                    Intent intent9111 =getIntent();
//                    Zh = intent9111.getStringExtra("Zh");
//
//
//                    Class.forName("com.mysql.jdbc.Driver");
//                    String url = "jdbc:mysql://192.168.50.64:3306/biye";
//                    String username = "root";
//                    String password = "123456";
//                    java.sql.Connection cn = DriverManager.getConnection(url, username, password);
//                    String sql = "select Name from Teacher where Gh=" + Zh;
//                    Statement st = (Statement) cn.createStatement();
//                    ResultSet rs = st.executeQuery(sql);
//                    while (rs.next()) {
//                        Name = rs.getString("Name");
//                        Log.i("Mainactivity", Name);
//                        textView72.setText(Name);
////                        Message message=handler.obtainMessage();
////                        message.what=1;
////                        message.obj=Name;
////                        handler.sendMessage(message);
//
//                    }
//                    st.close();
//                    rs.close();
//                    String sql1 = "select Sex from Teacher where Gh=" + Zh;
//                    Statement st1= (Statement) cn.createStatement();
//                    ResultSet rs1 = st1.executeQuery(sql1);
//                    while (rs1.next()) {
//                        Sex = rs1.getString("Sex");
//                        Log.i("Mainactivity", Sex);
//                        textView73.setText(Sex);
//                    }
//                    st1.close();
//                    rs1.close();
//                    String sql2 = "select Pose from Teacher where Gh=" + Zh;
//                    Statement st2= (Statement) cn.createStatement();
//                    ResultSet rs2 = st2.executeQuery(sql2);
//                    while (rs2.next()) {
//                        Pose = rs2.getString("Pose");
//                        Log.i("Mainactivity", Pose);
//                        textView74.setText(Pose);
//                    }
//                    st2.close();
//                    rs2.close();
//                    String sql3 = "select IDCard from Teacher where Gh=" + Zh;
//                    Statement st3= (Statement) cn.createStatement();
//                    ResultSet rs3 = st3.executeQuery(sql3);
//                    while (rs3.next()) {
//                        IDCard = rs3.getString("IDCard");
//                        Log.i("Mainactivity", IDCard);
//                        textView75.setText(IDCard);
//                    }
//                    st3.close();
//                    rs3.close();
//                    String sql4 = "select Phone from Teacher where Gh=" + Zh;
//                    Statement st4= (Statement) cn.createStatement();
//                    ResultSet rs4 = st4.executeQuery(sql4);
//                    while (rs4.next()) {
//                        Phone = rs4.getString("Phone");
//                        Log.i("Mainactivity", Phone);
//                        editText71.setText(Phone);
//                    }
//                    st4.close();
//                    rs4.close();
//                    cn.close();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//
//                }
//
//                Looper.loop();
//            }
//        }.start();
//        textView71.setText("12345678");
//        textView72.setText("王某某");
//        textView73.setText("女");
//        textView74.setText("教授");
//        textView75.setText("510111111111111111");
//        editText71.setHint("13909090909");

        Button button71 = tab07.findViewById(R.id.button71);
        button71.setOnClickListener(this);

        ListView listView81 = (ListView) tab08.findViewById(R.id.listview81);//在视图中找到ListView

        final ArrayAdapter<String> adapter81 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data81);//新建并配置ArrayAapeter

        listView81.setAdapter(adapter81);

        listView81.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                             String Name = adapter81.getItem(i);
                                                Intent intent886 = new Intent(teacher.this, grade.class);
                                                intent886.putExtra("Name",Name);
                                                intent886.putExtra("Zh",Zh1);
                                                startActivity(intent886);
                                            }
                                        });
        ListView listView41 = (ListView) tab04.findViewById(R.id.listview41);//在视图中找到ListView

        ArrayAdapter<String> adapter41 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data41);//新建并配置ArrayAapeter

        listView41.setAdapter(adapter41);

        listView41.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent intent991 = new Intent(teacher.this,jsjjc1.class);
                        intent991.putExtra("Zh",Gh1);
                        startActivity(intent991);
                        break;
                    case 1:
                        Intent intent992 = new Intent(teacher.this,czxt1.class);
                        intent992.putExtra("Zh",Gh1);
                        startActivity(intent992);
                        break;
                    case 2:
                        Intent intent993 = new Intent(teacher.this,exceljc1.class);
                        intent993.putExtra("Zh",Gh1);
                        startActivity(intent993);
                        break;
                    case 3:
                        Intent intent994 = new Intent(teacher.this,excelgs1.class);
                        intent994.putExtra("Zh",Gh1);
                        startActivity(intent994);
                        break;
                    case 4:
                        Intent intent995 = new Intent(teacher.this,excelhs1.class);
                        intent995.putExtra("Zh",Gh1);
                        startActivity(intent995);
                        break;
                    case 5:
                        Intent intent996 = new Intent(teacher.this,excelczhs1.class);
                        intent996.putExtra("Zh",Gh1);
                        startActivity(intent996);
                        break;
                    case 6:
                        Intent intent997 = new Intent(teacher.this,excelsjfx1.class);
                        intent997.putExtra("Zh",Gh1);
                        startActivity(intent997);
                        break;
                    case 7:
                        Intent intent998 = new Intent(teacher.this,exceltb1.class);
                        intent998.putExtra("Zh",Gh1);
                        startActivity(intent998);
                        break;
                    case 8:
                        Intent intent999 = new Intent(teacher.this,jsjwljc1.class);
                        intent999.putExtra("Zh",Gh1);
                        startActivity(intent999);
                        break;
                    case 9:
                        Intent intent981 = new Intent(teacher.this,xxaq1.class);
                        intent981.putExtra("Zh",Gh1);
                        startActivity(intent981);
                        break;
                    case 10:
                        Intent intent971 = new Intent(teacher.this,sjkyy1.class);
                        intent971.putExtra("Zh",Gh1);
                        startActivity(intent971);
                        break;
                    case 11:
                        Intent intent961 = new Intent(teacher.this,exceljbcj1.class);
                        intent961.putExtra("Zh",Gh1);
                        startActivity(intent961);
                        break;
                    case 12:
                        Intent intent661 = new Intent(teacher.this,sqlal1.class);
                        intent661.putExtra("Zh",Gh1);
                        startActivity(intent661);
                        break;

                }
            }
        });
        views1.add(tab04);
        views1.add(tab05);
        views1.add(tab06);
        views1.add(tab07);
        views1.add(tab08);

        MyPagerAdapter adapter = new MyPagerAdapter(views1);
        viewPager1.setAdapter(adapter);

    }

    private Spinner.OnItemSelectedListener spinnerSelectedListener = new Spinner.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            int a, b, c, d, e;

            String values1 = (String) spinner51.getSelectedItem();


            String values2 = (String) spinner52.getSelectedItem();


            String values3 = (String) spinner53.getSelectedItem();


            String values4 = (String) spinner54.getSelectedItem();


            if (values1.equals("计算机基础占比")) {

            } else if (values2.equals("操作系统占比")) {

            } else if (values3.equals("Excel占比")) {

            } else if (values4.equals("SQL占比")) {

            } else if (!values1.equals("计算机基础占比") && !values2.equals("操作系统占比") && !values3.equals("Excel占比") && !values4.equals("SQL占比")) {
                a = Integer.parseInt(values1);
                b = Integer.parseInt(values2);
                c = Integer.parseInt(values3);
                d = Integer.parseInt(values4);
                e = 100 - a - b - c - d;
                String str = String.valueOf(e);
                data_list55.clear();
                data_list55.add("数据分析、图表操作占比");
                data_list55.add(str);
                spinner55.setAdapter(arr_adapter55);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    public void onClick(View v) {
        changeTab(v.getId());
    }

    private void changeTab(int id) {
        tvCurrent1.setSelected(false);
        switch (id) {
            case R.id.llChat1:
                viewPager1.setCurrentItem(0);
            case 0:
                tvChat1.setSelected(true);
                tvCurrent1 = tvChat1;
                break;
            case R.id.llFriends1:
                viewPager1.setCurrentItem(1);
            case 1:
                tvFriends1.setSelected(true);
                tvCurrent1 = tvFriends1;
                break;
            case R.id.llContacts1:
                viewPager1.setCurrentItem(2);
            case 2:
                tvContacts1.setSelected(true);
                tvCurrent1 = tvContacts1;
                break;
            case R.id.llMine1:
                viewPager1.setCurrentItem(3);
            case 3:
                tvMine1.setSelected(true);
                tvCurrent1 = tvMine1;
                break;
            case R.id.llStudent1:
                viewPager1.setCurrentItem(4);
            case 4:
                tvStudent1.setSelected(true);
                tvCurrent1 = tvStudent1;
                break;
            case R.id.button61:
                String Stbt = editText61.getText()+"";
                String AnswerA = editText62.getText()+"";
                String AnswerB = editText63.getText()+"";
                String AnswerC = editText64.getText()+"";
                String AnswerD = editText65.getText()+"";
                String RightAnswer =(String) spinner61.getSelectedItem();
                String Fz = (String) spinner62.getSelectedItem();
                String Zjbh = (String) spinner63.getSelectedItem();

                if(Stbt.equals(""))
                {
                    editText61.setHint("请输入试题，不能为空");
                    return;
                }
                if(AnswerA.equals(""))
                {
                    editText62.setHint("请输入A答案，不能为空");
                    return;
                }
                if(AnswerB.equals(""))
                {
                    editText63.setHint("请输入B答案，不能为空");
                    return;
                }
                if(AnswerC.equals(""))
                {
                    editText64.setHint("请输入C答案，不能为空");
                    return;
                }
                if(AnswerD.equals(""))
                {
                    editText65.setHint("请输入D答案，不能为空");
                    return;
                }
                if(RightAnswer.equals("请选择正确答案"))
                {
                    Toast.makeText(teacher.this, "请选择正确答案,不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Fz.equals("请选择分值"))
                {
                    Toast.makeText(teacher.this, "请选择分值,不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Zjbh.equals("请选择所属章节"))
                {
                    Toast.makeText(teacher.this, "请选择所属章节,不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                else {
                    new Thread() {
                        @Override
                        public void run() {
                            Looper.prepare();
                            try {
                                String Stbt = editText61.getText()+"";
                                String AnswerA = editText62.getText()+"";
                                String AnswerB = editText63.getText()+"";
                                String AnswerC = editText64.getText()+"";
                                String AnswerD = editText65.getText()+"";
                                String RightAnswer =(String) spinner61.getSelectedItem();
                                String Fz = (String) spinner62.getSelectedItem();
                                String Zjbh = (String) spinner63.getSelectedItem();

                                Class.forName("com.mysql.jdbc.Driver");
//                                String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
                                String username = "root";
                                String password = "123456";
                                Connection cn = DriverManager.getConnection(url, username, password);
                                if(Zjbh.equals("计算机基础")) {
                                    String sql = "insert into question (Zjbh,Stbt,AnswerA,AnswerB,AnswerC,AnswerD,RightAnswer,Fz)values('1','" + Stbt + "','"+ AnswerA+"','"+AnswerB+"','"+AnswerC+"','"+AnswerD+"','"+RightAnswer+"','"+Fz+"')";
                                    Statement st = (Statement) cn.createStatement();
                                    st.execute(sql);
                                    st.close();
                                }
                                else if(Zjbh.equals("操作系统")){
                                    String sql = "insert into question (Zjbh,Stbt,AnswerA,AnswerB,AnswerC,AnswerD,RightAnswer,Fz)values('2','" + Stbt + "','"+ AnswerA+"','"+AnswerB+"','"+AnswerC+"','"+AnswerD+"','"+RightAnswer+"','"+Fz+"')";
                                    Statement st = (Statement) cn.createStatement();
                                    st.execute(sql);
                                    st.close();
                                }
                                else if(Zjbh.equals("Excel"))
                                {
                                    String sql = "insert into question (Zjbh,Stbt,AnswerA,AnswerB,AnswerC,AnswerD,RightAnswer,Fz)values('5','" + Stbt + "','"+ AnswerA+"','"+AnswerB+"','"+AnswerC+"','"+AnswerD+"','"+RightAnswer+"','"+Fz+"')";
                                    Statement st = (Statement) cn.createStatement();
                                    st.execute(sql);
                                    st.close();
                                }
                                else if(Zjbh.equals("SQL")){
                                    String sql = "insert into question (Zjbh,Stbt,AnswerA,AnswerB,AnswerC,AnswerD,RightAnswer,Fz)values('13','" + Stbt + "','"+ AnswerA+"','"+AnswerB+"','"+AnswerC+"','"+AnswerD+"','"+RightAnswer+"','"+Fz+"')";
                                    Statement st = (Statement) cn.createStatement();
                                    st.execute(sql);
                                    st.close();
                                }
                                else if(Zjbh.equals("数据分析、图表操作")){
                                    String sql = "insert into question (Zjbh,Stbt,AnswerA,AnswerB,AnswerC,AnswerD,RightAnswer,Fz)values('8','" + Stbt + "','"+ AnswerA+"','"+AnswerB+"','"+AnswerC+"','"+AnswerD+"','"+RightAnswer+"','"+Fz+"')";
                                    Statement st = (Statement) cn.createStatement();
                                    st.execute(sql);
                                    st.close();
                                }


                                cn.close();

                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (SQLException e) {
                                e.printStackTrace();

                            }
                            Looper.loop();
                        }
                    }.start();
                    Toast.makeText(teacher.this, "您的试题已经上传成功", Toast.LENGTH_SHORT).show();
                    Intent intent61 = new Intent(teacher.this, teacher.class);
                    intent61.putExtra("Zh",Zh);
                    intent61.putExtra("Name",Name);
                    intent61.putExtra("Sex",Sex);
                    intent61.putExtra("Pose",Pose);
                    intent61.putExtra("IDCard",IDCard);
                    intent61.putExtra("Phone",Phone);
                    startActivity(intent61);
                }
                break;
            case R.id.button71:
                Pose = editText71.getText()+"";
                String Phone = editText72.getText()+"";
                if(Pose.equals(""))
                {
                    editText71.setHint("请输入职位，不能为空");
                    return;
                }
                if(Phone.equals(""))
                {
                    editText72.setHint("请输入电话号码，不能为空");
                    return;
                }
                else {
                    new Thread() {
                        @Override
                        public void run() {
                            Looper.prepare();
                            String Phone = editText72.getText() + "";
                            String Zh = textView71.getText() + "";
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
                            String sql12 = "update Teacher set Pose ='"+Pose+"',Phone='" + Phone + "' where Gh='" + Zh + "'";
                            try {
                                stmt = cn.prepareStatement(sql12);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            try {
                                stmt.execute();// 返回值代表收到影响的行数
                                Toast.makeText(teacher.this, "您的信息已经更改成功", Toast.LENGTH_SHORT).show();
                                stmt.close();
                                cn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            Intent intent71 = new Intent(teacher.this, teacher.class);
                            intent71.putExtra("Zh",Zh);
                            intent71.putExtra("Name",Name);
                            intent71.putExtra("Sex",Sex);
                            intent71.putExtra("Pose",Pose);
                            intent71.putExtra("IDCard",IDCard);
                            intent71.putExtra("Phone",Phone);
                            startActivity(intent71);
                            Looper.loop();
                        }
                    }.start();
                }
                break;
            case R.id.button51:


                        String values1 = (String) spinner51.getSelectedItem();


                        String values2 = (String) spinner52.getSelectedItem();


                        String values3 = (String) spinner53.getSelectedItem();


                        String values4 = (String) spinner54.getSelectedItem();

                        String values5 = (String) spinner55.getSelectedItem();
                        String values6 = (String) editText51.getText().toString();
                        if (editText51.getText().toString().equals("")) {
                            Toast.makeText(teacher.this, "请输入试卷名称", Toast.LENGTH_SHORT).show();
                        } else if (values1.equals("计算机基础占比")) {
                            Toast.makeText(teacher.this, "请选择计算机基础占比", Toast.LENGTH_SHORT).show();
                        } else if (values2.equals("操作系统占比")) {
                            Toast.makeText(teacher.this, "请选择操作系统占比", Toast.LENGTH_SHORT).show();
                        } else if (values3.equals("Excel占比")) {
                            Toast.makeText(teacher.this, "请选择Excel占比", Toast.LENGTH_SHORT).show();
                        } else if (values4.equals("SQL占比")) {
                            Toast.makeText(teacher.this, "请选择SQL占比", Toast.LENGTH_SHORT).show();
                        } else if (values5.equals("数据分析、图表操作占比")) {
                            Toast.makeText(teacher.this, "请选择数据分析、图表操作占比", Toast.LENGTH_SHORT).show();
                        } else if (!editText51.getText().toString().equals("") && !values1.equals("计算机基础占比") && !values2.equals("操作系统占比") && !values3.equals("Excel占比") && !values4.equals("SQL占比") && !values5.equals("数据分析、图表操作占比")) {
                            new Thread() {
                                @Override
                                public void run() {
                                    Looper.prepare();
                                    int x1, x2, x3, x4, x5;
                                    String values1 = (String) spinner51.getSelectedItem();


                                    String values2 = (String) spinner52.getSelectedItem();


                                    String values3 = (String) spinner53.getSelectedItem();


                                    String values4 = (String) spinner54.getSelectedItem();

                                    String values5 = (String) spinner55.getSelectedItem();
                                    String values6 = (String) editText51.getText().toString();
                                    x1 = Integer.valueOf(values1).intValue();
                                    x2 = Integer.valueOf(values2).intValue();
                                    x3 = Integer.valueOf(values3).intValue();
                                    x4 = Integer.valueOf(values4).intValue();
                                    x5 = Integer.valueOf(values5).intValue();
                                    x1 = x1 / 5;
                                    x2 = x2 / 5;
                                    x3 = x3 / 5;
                                    x4 = x4 / 5;
                                    x5 = x5 / 5;
                                    String[] Stbh1, Stbh2, Stbh3, Stbh4, Stbh5;
                                    Stbh1 = new String[100];
                                    Stbh2 = new String[100];
                                    Stbh3 = new String[100];
                                    Stbh4 = new String[100];
                                    Stbh5 = new String[100];
                                    int w = 0;
                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
//
                            String url = "jdbc:mysql://192.168.50.64:3306/biye";
//                                    String url = "jdbc:mysql://172.20.10.2:3306/biye";
                                    String username = "root";
                                    String password = "123456";
                                    java.sql.Connection cn = null;
                                    try {
                                        cn = DriverManager.getConnection(url, username, password);
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
//                            if(x1<=2){
                                    PreparedStatement stmt70 = null;
                                    String sql70 = "select max(Sjbh) from Paper";
//                    String sql70 = "INSERT INTO Paper(Sjbh,Th,Stbh) SELECT Stbh FROM Question Where Zjbh='1' ORDER BY RAND() LIMIT"+x1;
                                    try {

                                        stmt70 = cn.prepareStatement(sql70);
                                        ResultSet rs70 = stmt70.executeQuery();
                                        while (rs70.next()) {
                                            max = rs70.getInt(1);
                                            Log.i("Mainactivity", String.valueOf(max));

                                        }
                                        PreparedStatement stmt90 = null;
                                        String sql90 = "select Stbh from Question Where Zjbh='1'AND Fz='5' ORDER BY RAND() LIMIT " + x1;
                                        stmt90 = cn.prepareStatement(sql90);
                                        ResultSet rs90 = stmt90.executeQuery();
                                        while (rs90.next()) {
                                            Stbh1[w] = rs90.getString("Stbh");
                                            w++;
                                        }
                                        w = 0;
                                        max = max + 1;
                                        int q;
                                        for (q = 1; q < x1 + 1; q++) {
                                            PreparedStatement stmt71 = null;
//                                    String sql71 = "INSERT INTO Paper(Sjbh,Th,Sjmc,Stbh) SELECT "+ max + "," + q + ",'"+values6+"',Stbh FROM Question Where Zjbh='1' ORDER BY RAND() LIMIT 1";
                                            String sql71 = "INSERT INTO Paper VALUES (" + max + "," + q + ",'" + Stbh1[q - 1] + "','" + values6 + "')";
                                            stmt71 = cn.prepareStatement(sql71);
                                            stmt71.execute();
                                            stmt71.close();
                                        }
                                        stmt70.close();
                                        rs70.close();
                                        stmt90.close();
                                        rs90.close();

                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }

//                            else{
//                                PreparedStatement stmt70 = null;
//                                String sql70 = "select max(Sjbh) from Paper";
////                    String sql70 = "INSERT INTO Paper(Sjbh,Th,Stbh) SELECT Stbh FROM Question Where Zjbh='1' ORDER BY RAND() LIMIT"+x1;
//                                try {
//
//                                    stmt70 = cn.prepareStatement(sql70);
//                                    ResultSet rs70 = stmt70.executeQuery();
//                                    while (rs70.next()) {
//                                        max = rs70.getInt(1);
//                                        Log.i("Mainactivity", String.valueOf(max));
//
//                                    }
//                                    PreparedStatement stmt90 = null;
//                                    String sql90 = "select Stbh from Question Where Zjbh='1' AND Fz='10' ORDER BY RAND() LIMIT 1" ;
//                                    stmt90 = cn.prepareStatement(sql90);
//                                    ResultSet rs90 = stmt90.executeQuery();
//                                    while(rs90.next())
//                                    {
//                                        Stbh1[w] = rs90.getString("Stbh");
//                                        w++;
//                                    }
//                                    max = max + 1;
//                                    PreparedStatement stmt51 = null;
////                                    String sql71 = "INSERT INTO Paper(Sjbh,Th,Sjmc,Stbh) SELECT "+ max + "," + q + ",'"+values6+"',Stbh FROM Question Where Zjbh='1' ORDER BY RAND() LIMIT 1";
//                                    String sql51 = "INSERT INTO Paper VALUES ("+ max + "," + 1 + ",'"+Stbh1[0]+"','"+values6+"')";
//                                    stmt51 = cn.prepareStatement(sql51);
//                                    stmt51.execute();
//                                    stmt51.close();
//                                    stmt90.close();
//                                    rs90.close();
//                                    w=0;
//
//                                    PreparedStatement stmt60 =null;
//                                    String sql60 ="select Stbh from Question Where Zjbh='1' AND Fz='5' ORDER BY RAND() LIMIT"+(x1-2);
//                                    stmt60 = cn.prepareStatement(sql60);
//                                    ResultSet rs60 = stmt60.executeQuery();
//                                    while(rs60.next())
//                                    {
//                                        Stbh1[w] = rs60.getString("Stbh");
//
//                                        w++;
//                                    }
//                                    Log.i("Mainactivity", String.valueOf(w));
//                                    int m=w;
//                                    w=0;
//
//                                    int q;
////                                    for (q = 1; q < x1+1; q++) {
//                                    for (q = 2; q <=x1; q++) {
//                                        PreparedStatement stmt71 = null;
////                                    String sql71 = "INSERT INTO Paper(Sjbh,Th,Sjmc,Stbh) SELECT "+ max + "," + q + ",'"+values6+"',Stbh FROM Question Where Zjbh='1' ORDER BY RAND() LIMIT 1";
//                                        String sql71 = "INSERT INTO Paper VALUES ("+ max + "," + q + ",'"+Stbh1[q-1]+"','"+values6+"')";
//                                        stmt71 = cn.prepareStatement(sql71);
//                                        stmt71.execute();
//                                        stmt71.close();
//                                    }
//                                    stmt70.close();
//                                    rs70.close();
//                                    stmt60.close();
//                                    rs60.close();
//
//
//                                } catch (SQLException e) {
//                                    e.printStackTrace();
//                                }
//                            }


                                    PreparedStatement stmt72 = null;
                                    String sql72 = "select max(Sjbh) from Paper";
//                    String sql70 = "INSERT INTO Paper(Sjbh,Th,Stbh) SELECT Stbh FROM Question Where Zjbh='1' ORDER BY RAND() LIMIT"+x1;
                                    try {

                                        stmt72 = cn.prepareStatement(sql72);
                                        ResultSet rs72 = stmt72.executeQuery();
                                        while (rs72.next()) {
                                            max = rs72.getInt(1);
                                            Log.i("Mainactivity", String.valueOf(max));

                                        }
                                        PreparedStatement stmt91 = null;
                                        String sql91 = "select Stbh from Question Where Zjbh='2' ORDER BY RAND() LIMIT " + x2;
                                        stmt91 = cn.prepareStatement(sql91);
                                        ResultSet rs91 = stmt91.executeQuery();
                                        while (rs91.next()) {
                                            Stbh2[w] = rs91.getString("Stbh");
                                            w++;
                                        }
                                        w = 0;
                                        int q;
//                                for (q = x1+1; q < x1+x2+1; q++) {
                                        for (q = x1 + 1; q < x1 + x2 + 1; q++) {
                                            PreparedStatement stmt73 = null;
//                                    String sql73 = "INSERT INTO Paper(Sjbh,Th,Sjmc,Stbh) SELECT "+ max + "," + q + ",'"+values6+"',Stbh FROM Question Where Zjbh='2' ORDER BY RAND() LIMIT 1" ;
//                                    String sql73 = "INSERT INTO Paper VALUES ("+ max + "," + q + ",'"+Stbh2[q-1-x1]+"','"+values6+"')" ;
                                            String sql73 = "INSERT INTO Paper VALUES (" + max + "," + q + ",'" + Stbh2[q - 1 - x1] + "','" + values6 + "')";
                                            stmt73 = cn.prepareStatement(sql73);
                                            stmt73.execute();
                                            stmt73.close();
                                        }
                                        stmt72.close();
                                        rs72.close();
                                        stmt91.close();
                                        rs91.close();

                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    PreparedStatement stmt74 = null;
                                    String sql74 = "select max(Sjbh) from Paper";
//                    String sql70 = "INSERT INTO Paper(Sjbh,Th,Stbh) SELECT Stbh FROM Question Where Zjbh='1' ORDER BY RAND() LIMIT"+x1;
                                    try {

                                        stmt74 = cn.prepareStatement(sql74);
                                        ResultSet rs74 = stmt74.executeQuery();
                                        while (rs74.next()) {
                                            max = rs74.getInt(1);
                                            Log.i("Mainactivity", String.valueOf(max));

                                        }
                                        PreparedStatement stmt92 = null;
                                        String sql92 = "select Stbh from Question Where Zjbh='5' ORDER BY RAND() LIMIT " + x3;
                                        stmt92 = cn.prepareStatement(sql92);
                                        ResultSet rs92 = stmt92.executeQuery();
                                        while (rs92.next()) {
                                            Stbh3[w] = rs92.getString("Stbh");
                                            w++;
                                        }
                                        w = 0;
                                        int q;
//                                for (q = x1+x2+1; q < x1+x2+x3+1; q++) {
                                        for (q = x1 + x2 + 1; q < x1 + x2 + x3 + 1; q++) {
                                            PreparedStatement stmt75 = null;
//                                    String sql75 = "INSERT INTO Paper(Sjbh,Th,Sjmc,Stbh) SELECT "+ max + "," + q + ",'"+values6+"',Stbh FROM Question Where Zjbh='5' ORDER BY RAND() LIMIT 1";
//                                    String sql75 = "INSERT INTO Paper VALUES ("+ max + "," + q + ",'"+Stbh3[q-1-x1-x2]+"','"+values6+"')";
                                            String sql75 = "INSERT INTO Paper VALUES (" + max + "," + q + ",'" + Stbh3[q - 1 - x1 - x2] + "','" + values6 + "')";
                                            stmt75 = cn.prepareStatement(sql75);
                                            stmt75.execute();
                                            stmt75.close();
                                        }
                                        stmt74.close();
                                        rs74.close();
                                        stmt92.close();
                                        rs92.close();

                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    PreparedStatement stmt76 = null;
                                    String sql76 = "select max(Sjbh) from Paper";
//                    String sql70 = "INSERT INTO Paper(Sjbh,Th,Stbh) SELECT Stbh FROM Question Where Zjbh='1' ORDER BY RAND() LIMIT"+x1;
                                    try {

                                        stmt76 = cn.prepareStatement(sql76);
                                        ResultSet rs76 = stmt76.executeQuery();
                                        while (rs76.next()) {
                                            max = rs76.getInt(1);
                                            Log.i("Mainactivity", String.valueOf(max));

                                        }
                                        PreparedStatement stmt93 = null;
                                        String sql93 = "select Stbh from Question Where Zjbh='13' ORDER BY RAND() LIMIT " + x4;
                                        stmt93 = cn.prepareStatement(sql93);
                                        ResultSet rs93 = stmt93.executeQuery();
                                        while (rs93.next()) {
                                            Stbh4[w] = rs93.getString("Stbh");
                                            w++;
                                        }
                                        w = 0;
                                        int q;
                                        for (q = x1 + x2 + x3 + 1; q < x1 + x2 + x3 + x4 + 1; q++) {
//                                for (q = x1+x2+x3+1; q < x1+x2+x3+x4+1; q++) {
                                            PreparedStatement stmt77 = null;
//                                    String sql77 = "INSERT INTO Paper(Sjbh,Th,Sjmc,Stbh) SELECT "+ max + "," + q + ",'"+values6+"',Stbh FROM Question Where Zjbh='13' ORDER BY RAND() LIMIT 1" ;
//                                    String sql77 = "INSERT INTO Paper VALUES ("+ max + "," + q + ",'"+Stbh4[q-1-x1-x2-x3]+"','"+values6+"')";
                                            String sql77 = "INSERT INTO Paper VALUES (" + max + "," + q + ",'" + Stbh4[q - 1 - x1 - x2 - x3] + "','" + values6 + "')";
                                            stmt77 = cn.prepareStatement(sql77);
                                            stmt77.execute();
                                            stmt77.close();
                                        }
                                        stmt76.close();
                                        rs76.close();
                                        stmt93.close();
                                        rs93.close();

                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    PreparedStatement stmt78 = null;
                                    String sql78 = "select max(Sjbh) from Paper";
//                    String sql70 = "INSERT INTO Paper(Sjbh,Th,Stbh) SELECT Stbh FROM Question Where Zjbh='1' ORDER BY RAND() LIMIT"+x1;
                                    try {

                                        stmt78 = cn.prepareStatement(sql78);
                                        ResultSet rs78 = stmt78.executeQuery();
                                        while (rs78.next()) {
                                            max = rs78.getInt(1);
                                            Log.i("Mainactivity", String.valueOf(max));

                                        }
                                        PreparedStatement stmt94 = null;
                                        String sql94 = "select Stbh from Question Where Zjbh='8' ORDER BY RAND() LIMIT " + x5;
                                        stmt94 = cn.prepareStatement(sql94);
                                        ResultSet rs94 = stmt94.executeQuery();
                                        while (rs94.next()) {
                                            Stbh5[w] = rs94.getString("Stbh");
                                            w++;
                                        }
                                        w = 0;
                                        int q;
//                                for (q = x1+x2+x3+x4+1; q <x1+x2+x3+x4+x5+1; q++) {
                                        for (q = x1 + x2 + x3 + x4 + 1; q < x1 + x2 + x3 + x4 + x5 + 1; q++) {
                                            PreparedStatement stmt79 = null;
//                                    String sql79 = "INSERT INTO Paper(Sjbh,Th,Sjmc,Stbh) SELECT "+ max + "," + q + ",'"+values6+"',Stbh  FROM Question Where Zjbh='8' ORDER BY RAND() LIMIT 1" ;
//                                    String sql79 = "INSERT INTO Paper VALUES ("+ max + "," + q + ",'"+Stbh5[q-1-x1-x2-x3-x4]+"','"+values6+"')" ;
                                            String sql79 = "INSERT INTO Paper VALUES (" + max + "," + q + ",'" + Stbh5[q - 1 - x1 - x2 - x3 - x4] + "','" + values6 + "')";
                                            stmt79 = cn.prepareStatement(sql79);
                                            stmt79.execute();
                                            stmt79.close();
                                        }
                                        stmt78.close();
                                        rs78.close();
                                        stmt94.close();
                                        rs94.close();

                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    Toast.makeText(teacher.this, "动态组卷成功，试卷信息已上传，试卷共20题，每题5分，总计100分\n计算机基础占" + x1 + "道" + values1 + "分\n操作系统占" + x2 + "道" + values2 + "分\nExcel占" + x3 + "道" + values3 + "分\nSQL占" + x4 + "道" + values4 + "分\n数据分析、图表操作占" + x5 + "道" + values5 + "分", Toast.LENGTH_LONG).show();
                                    Intent intent71 = new Intent(teacher.this, teacher.class);
                                    intent71.putExtra("Zh", Zh);
                                    intent71.putExtra("Name", Name);
                                    intent71.putExtra("Sex", Sex);
                                    intent71.putExtra("Pose", Pose);
                                    intent71.putExtra("IDCard", IDCard);
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


}

