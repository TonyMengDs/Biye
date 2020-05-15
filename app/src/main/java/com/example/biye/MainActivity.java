package com.example.biye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.example.biye.student.handler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup type;
    private RadioButton Student,Teacher;
    private String typename="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button11 = findViewById(R.id.button11);
        TextView textView11 = findViewById(R.id.textView11);



        button11.setTag(1);
        textView11.setTag(2);

        button11.setOnClickListener(this);
        textView11.setOnClickListener(this);
    }


    public void onClick(View v) {
        int tag = (Integer)v.getTag();



        switch(tag){
            case 1:
                type =(RadioGroup)findViewById(R.id.type);
                Student = (RadioButton)findViewById(R.id.Student);
                Teacher = (RadioButton)findViewById(R.id.Teacher);
                for(int i=0;i<type.getChildCount();i++){
                    RadioButton rb = (RadioButton)type.getChildAt(i);
                    if(rb.isChecked())
                    {
                        typename = rb.getText().toString();
                        break;
                    }
                }
                if(typename.equals("")) {
                    Toast.makeText(MainActivity.this, "请选择类型", Toast.LENGTH_SHORT).show();
                }
                else if(typename.equals("学生")){
                    EditText editTextm1 = findViewById(R.id.editTextm1);
                    String id = editTextm1.getText().toString().trim();
                    EditText editTextm2 = findViewById(R.id.editTextm2);

                    String pw = editTextm2.getText().toString().trim();
                    SendByHttpClient(id);
//                    new Thread() {
//                        @Override
//                        public void run() {
//                            Looper.prepare();
//                            try {
//                                EditText editTextm1 = findViewById(R.id.editTextm1);
//                                String Zh = editTextm1.getText().toString().trim();
//                                EditText editTextm2 = findViewById(R.id.editTextm2);
//
//                                String MM = editTextm2.getText().toString().trim();
//                                Class.forName("com.mysql.jdbc.Driver");
//                                String url = "jdbc:mysql://192.168.50.64:3306/biye";
//                                String username = "root";
//                                String password = "123456";
//                                java.sql.Connection cn = DriverManager.getConnection(url, username, password);
//                                String sql = "select Code from Student where Xh=" + Zh;
//                                Statement st = (Statement) cn.createStatement();
//                                ResultSet rs = st.executeQuery(sql);
//                                if (rs.next()) {
//                                    String MM1 = rs.getString("Code");
//                                    Log.i("Mainactivity", MM1);
//
//
//                                    if (MM.equals(MM1)) {
//                                        Intent intent911 = new Intent(MainActivity.this, student.class);
//                                        intent911.putExtra("Zh",Zh);
//                                        startActivity(intent911);
//                                    }
//                                    else{
//                                        Toast.makeText(MainActivity.this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
//                                    }
//                                    st.close();
//                                    rs.close();
//                                    cn.close();
//                                }
//                                else
//                                {
//                                    Toast.makeText(MainActivity.this, "请输入正确的账号", Toast.LENGTH_SHORT).show();
//                                }
//
//                            } catch (ClassNotFoundException e) {
//                                e.printStackTrace();
//                            } catch (SQLException e) {
//                                e.printStackTrace();
//
//                            }
//                            Looper.loop();
//                        }
//                    }.start();
                }

                        else if(typename.equals("教师"))
                        {
                            EditText editTextm1 = findViewById(R.id.editTextm1);
                            String id = editTextm1.getText().toString().trim();
                            EditText editTextm2 = findViewById(R.id.editTextm2);

                            String pw = editTextm2.getText().toString().trim();
                            SendByHttpClient1(id);
//                            new Thread() {
//                                @Override
//                                public void run() {
//                                    Looper.prepare();
//                                    try {
//                                        EditText editTextm1 = findViewById(R.id.editTextm1);
//                                        String Zh = editTextm1.getText().toString().trim();
//                                        EditText editTextm2 = findViewById(R.id.editTextm2);
//
//                                        String MM = editTextm2.getText().toString().trim();
//                                        Class.forName("com.mysql.jdbc.Driver");
//                                        String url = "jdbc:mysql://192.168.50.64:3306/biye";
//                                        String username = "root";
//                                        String password = "123456";
//                                        java.sql.Connection cn = DriverManager.getConnection(url, username, password);
//                                        String sql = "select Code from Teacher where Gh=" + Zh;
//                                        Statement st = (Statement) cn.createStatement();
//                                        ResultSet rs = st.executeQuery(sql);
//                                        if (rs.next()) {
//                                            String MM1 = rs.getString("Code");
//                                            Log.i("Mainactivity", MM1);
//
//
//                                            if (MM.equals(MM1)) {
//
//                                                Intent intent9111 = new Intent(MainActivity.this, teacher.class);
//                                                intent9111.putExtra("Zh",Zh);
//                                                startActivity(intent9111);
//                                            }
//
//                                            else{
//                                                Toast.makeText(MainActivity.this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
//                                            }
//                                            st.close();
//                                            rs.close();
//                                            cn.close();
//                                        }
//                                    else{
//                                            Toast.makeText(MainActivity.this, "请输入正确的账号", Toast.LENGTH_SHORT).show();
//                                        }
//
//                                    } catch (ClassNotFoundException e) {
//                                        e.printStackTrace();
//                                    } catch (SQLException e) {
//                                        e.printStackTrace();
//
//                                    }
//                                    Looper.loop();
//                                }
//                            }.start();
                        }








                break;
            case 2:
        Intent intent1111 = new Intent(MainActivity.this, forget.class);
        startActivity(intent1111);
    }
    }


    public void SendByHttpClient(final String id){

        new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    HttpClient httpclient=new DefaultHttpClient();

                    HttpPost httpPost=new HttpPost("http://192.168.50.64:8080/TomcatTest/Login");//服务器地址，指向Servlet
//                    HttpPost httpPost=new HttpPost("http://172.20.10.2:8080/TomcatTest/Login");//服务器地址，指向Servlet

                    List<NameValuePair> params=new ArrayList<NameValuePair>();//将id和pw装入list

                    params.add(new BasicNameValuePair("ID",id));

//                    params.add(new BasicNameValuePair("PW",pw));

                    final UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params,"utf-8");//以UTF-8格式发送

                    httpPost.setEntity(entity);

                    HttpResponse httpResponse= httpclient.execute(httpPost);

                    if(httpResponse.getStatusLine().getStatusCode()==200)//在200毫秒之内接收到返回值

                    {

                        HttpEntity entity1=httpResponse.getEntity();

                        String response= EntityUtils.toString(entity1, "utf-8");//以UTF-8格式解析

                        Message message=new Message();

                        message.what=1;

                        message.obj=response;

                        handler.sendMessage(message);

                    }

                }

                catch (Exception e) {

                    e.printStackTrace();

                }

            }

        }).start();

    }
    public void SendByHttpClient1(final String id){

        new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    HttpClient httpclient=new DefaultHttpClient();
//                    HttpPost httpPost=new HttpPost("http://172.20.10.2:8080/TomcatTest/Login1");//服务器地址，指向Servlet
                    HttpPost httpPost=new HttpPost("http://192.168.50.64:8080/TomcatTest/Login1");//服务器地址，指向Servlet


                    List<NameValuePair> params=new ArrayList<NameValuePair>();//将id和pw装入list

                    params.add(new BasicNameValuePair("ID",id));

//                    params.add(new BasicNameValuePair("PW",pw));

                    final UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params,"utf-8");//以UTF-8格式发送

                    httpPost.setEntity(entity);

                    HttpResponse httpResponse= httpclient.execute(httpPost);

                    if(httpResponse.getStatusLine().getStatusCode()==200)//在200毫秒之内接收到返回值

                    {

                        HttpEntity entity1=httpResponse.getEntity();

                        String response= EntityUtils.toString(entity1, "utf-8");//以UTF-8格式解析

                        Message message=new Message();

                        message.what=2;

                        message.obj=response;

                        handler.sendMessage(message);

                    }

                }

                catch (Exception e) {

                    e.printStackTrace();

                }

            }

        }).start();

    }

    public static final int SHOW_RESPONSE=1;

    public Handler handler=new Handler() {

        public void handleMessage(Message msg)

        {

            switch (msg.what){

                case SHOW_RESPONSE:

                    String response=(String)msg.obj;
                    EditText editTextm1 = findViewById(R.id.editTextm1);
                    String id = editTextm1.getText().toString().trim();
                    EditText editTextm2 = findViewById(R.id.editTextm2);
//
                                String MM = editTextm2.getText().toString().trim();
//                    if(response.equals("true")){
//                        Intent intent911 = new Intent(MainActivity.this, student.class);
//                                        intent911.putExtra("Zh",id);
//                                        startActivity(intent911);
//                    }

                    if (response.equals(MM)) {
                                        Intent intent911 = new Intent(MainActivity.this, student.class);
                                        intent911.putExtra("Zh",id);
                                        startActivity(intent911);
                                    }
                    else if(response.equals("null"))
                    {
                        Toast.makeText(MainActivity.this, "请输入正确的账号", Toast.LENGTH_SHORT).show();
                    }
                                    else if(!response.equals(MM)&&!response.equals("null")){
                                        Toast.makeText(MainActivity.this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                                    }
                    break;

                case 2:
                    String response1=(String)msg.obj;
                    editTextm1 = findViewById(R.id.editTextm1);
                    id = editTextm1.getText().toString().trim();
                    editTextm2 = findViewById(R.id.editTextm2);
//
                    MM = editTextm2.getText().toString().trim();
//                    if(response.equals("true")){
//                        Intent intent911 = new Intent(MainActivity.this, student.class);
//                                        intent911.putExtra("Zh",id);
//                                        startActivity(intent911);
//                    }

                    if (response1.equals(MM)) {
                        Intent intent911 = new Intent(MainActivity.this, teacher.class);
                        intent911.putExtra("Zh",id);
                        startActivity(intent911);
                    }
                    else if(response1.equals("null"))
                    {
                        Toast.makeText(MainActivity.this, "请输入正确的账号", Toast.LENGTH_SHORT).show();
                    }
                    else if(!response1.equals(MM)&&!response1.equals("null")){
                        Toast.makeText(MainActivity.this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:

                    break;

            }

        }

    };


}
