package com.example.biye;

import android.content.Intent;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import static com.example.biye.student.handler;

public class forget extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup type;
    private RadioButton Student,Teacher;
    private String typename="";
    private EditText editText001,editText002,editText003,editText004;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget);
        Button button001 = findViewById(R.id.button001);
        button001.setOnClickListener(this);
    }
    public void onClick(View v) {
        String MM1,MM2="";
        type =(RadioGroup)findViewById(R.id.type);
        Student = (RadioButton)findViewById(R.id.Student);
        Teacher = (RadioButton)findViewById(R.id.Teacher);
        editText003 =findViewById(R.id.editText003);
        editText004 = findViewById(R.id.editText004);

        MM1 = editText003.getText().toString().trim();
        MM2 = editText004.getText().toString().trim();
        if(MM1.equals(MM2)&&MM1!=""){
            for(int i=0;i<type.getChildCount();i++){
                RadioButton rb = (RadioButton)type.getChildAt(i);
                if(rb.isChecked())
                {
                    typename = rb.getText().toString();
                    break;
                }
            }
            if(typename.equals("")) {
                Toast.makeText(forget.this, "请选择类型", Toast.LENGTH_SHORT).show();
            }
            else if(typename.equals("学生")){
//                new Thread() {
//                    @Override
//                    public void run() {
//                        Looper.prepare();
//                        try {
                            editText001 = findViewById(R.id.editText001);
                            String Zh = editText001.getText().toString().trim();
                            editText002 = findViewById(R.id.editText002);
                            editText004 = findViewById(R.id.editText004);
                            MM2 = editText004.getText().toString().trim();

                            String Sfzh = editText002.getText().toString().trim();
                            SendByHttpClient(Zh);
//                            Class.forName("com.mysql.jdbc.Driver");
//                            String url = "jdbc:mysql://192.168.50.64:3306/biye";
//                            String username = "root";
//                            String password = "123456";
//                            java.sql.Connection cn = DriverManager.getConnection(url, username, password);
//                            String sql = "select IDCard from Student where Xh=" + Zh;
//                            Statement st = (Statement) cn.createStatement();
//                            ResultSet rs = st.executeQuery(sql);
//                            if (rs.next()) {
//                                String Sfzh1 = rs.getString("IDCard");
//                                Log.i("Mainactivity", Sfzh1);
//
//
//                                if (Sfzh.equals(Sfzh1)) {
//                                    PreparedStatement stmt =null;
//
//                                    String sql1 = "update Student set Code='" + MM2 + "' where Xh='" + Zh + "'";
//                                    stmt = cn.prepareStatement(sql1);
//                                    stmt.execute();// 返回值代表收到影响的行数
//
//                                    stmt.close();
//
//                                    cn.close();
//                                    Toast.makeText(forget.this, "您的密码已重置成功", Toast.LENGTH_SHORT).show();
//                                    Intent intent911 = new Intent(forget.this, MainActivity.class);
//                                    startActivity(intent911);
//                                }
//                                else{
//                                    Toast.makeText(forget.this, "请输入正确的账号身份证", Toast.LENGTH_SHORT).show();
//                                }
//                                st.close();
//                                rs.close();
//                                cn.close();
//                            }
//                            else{
//                                Toast.makeText(forget.this, "请输入正确的账号", Toast.LENGTH_SHORT).show();
//                            }


//                        } catch (ClassNotFoundException e) {
//                            e.printStackTrace();
//                        } catch (SQLException e) {
//                            e.printStackTrace();
//
//                        }
//                        Looper.loop();
//                    }
//                }.start();
            }

            else if(typename.equals("教师"))
            {
//                new Thread() {
//                    @Override
//                    public void run() {
//                        Looper.prepare();
//                        try {
                            editText001 = findViewById(R.id.editText001);
                            String Zh = editText001.getText().toString().trim();
                            editText002 = findViewById(R.id.editText002);
                            editText004 = findViewById(R.id.editText004);
                            MM2 = editText004.getText().toString().trim();
                            String Sfzh = editText002.getText().toString().trim();
                            SendByHttpClient1(Zh);
//                            Class.forName("com.mysql.jdbc.Driver");
//                            String url = "jdbc:mysql://192.168.50.64:3306/biye";
//                            String username = "root";
//                            String password = "123456";
//                            java.sql.Connection cn = DriverManager.getConnection(url, username, password);
//                            String sql = "select IDCard from Teacher where Gh=" + Zh;
//                            Statement st = (Statement) cn.createStatement();
//                            ResultSet rs = st.executeQuery(sql);
//                            if (rs.next()) {
//                                String Sfzh1 = rs.getString("IDCard");
//                                Log.i("Mainactivity", Sfzh1);
//
//
//                                if (Sfzh.equals(Sfzh1)) {
//
//                                    PreparedStatement stmt =null;
//                                    ResultSet rs1 = null;
//                                    String sql1 = "update Teacher set Code='" + MM2 + "' where Gh='" + Zh + "'";
//                                    stmt = cn.prepareStatement(sql1);
//                                    stmt.execute();// 返回值代表收到影响的行数
//                                    Toast.makeText(forget.this, "您的密码已重置成功", Toast.LENGTH_SHORT).show();
//                                    Intent intent911 = new Intent(forget.this, MainActivity.class);
//                                    startActivity(intent911);
//                                }
//
//                                else{
//                                    Toast.makeText(forget.this, "请输入正确的账号身份证", Toast.LENGTH_SHORT).show();
//                                }
//                                st.close();
//                                rs.close();
//                                cn.close();
//                            }
//                      else{
//                                Toast.makeText(forget.this, "请输入正确的账号", Toast.LENGTH_SHORT).show();
//                            }
//
//                        } catch (ClassNotFoundException e) {
//                            e.printStackTrace();
//                        } catch (SQLException e) {
//                            e.printStackTrace();
//
//                        }
//                        Looper.loop();
//                    }
//                }.start();
            }
        }
        else
        {
            Toast.makeText(forget.this, "密码请重新输入", Toast.LENGTH_SHORT).show();
        }

    }

    public void SendByHttpClient(final String Zh){

        new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    HttpClient httpclient=new DefaultHttpClient();

                    HttpPost httpPost=new HttpPost("http://192.168.50.64:8080/TomcatTest/Login2");//服务器地址，指向Servlet
//                    HttpPost httpPost=new HttpPost("http://172.20.10.2:8080/TomcatTest/Login2");//服务器地址，指向Servlet

                    List<NameValuePair> params=new ArrayList<NameValuePair>();//将id和pw装入list

                    params.add(new BasicNameValuePair("ID",Zh));

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
    public void SendByHttpClient1(final String Zh){

        new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    HttpClient httpclient=new DefaultHttpClient();

                    HttpPost httpPost=new HttpPost("http://192.168.50.64:8080/TomcatTest/Login3");//服务器地址，指向Servlet
//                    HttpPost httpPost=new HttpPost("http://172.20.10.2:8080/TomcatTest/Login3");//服务器地址，指向Servlet

                    List<NameValuePair> params=new ArrayList<NameValuePair>();//将id和pw装入list

                    params.add(new BasicNameValuePair("ID",Zh));

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
                    String Sfzh = editText002.getText().toString().trim();
                    String MM1 = editText003.getText().toString().trim();
                    String Zh = editText001.getText().toString().trim();

//                    if(response.equals("true")){
//                        Intent intent911 = new Intent(MainActivity.this, student.class);
//                                        intent911.putExtra("Zh",id);
//                                        startActivity(intent911);
//                    }

                    if (response.equals(Sfzh)) {
                        Toast.makeText(forget.this, "您的密码已重置成功", Toast.LENGTH_SHORT).show();
                        SendByHttpClient2(Zh,MM1);
                        Intent intent911 = new Intent(forget.this, MainActivity.class);
                        startActivity(intent911);
                    }
                    else if(response.equals("null"))
                    {
                        Toast.makeText(forget.this, "请输入正确的账号", Toast.LENGTH_SHORT).show();
                    }
                    else if(!response.equals(Sfzh)&&!response.equals("null")){
                        Toast.makeText(forget.this, "请输入正确的账号身份证", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case 2:
                    String response1=(String)msg.obj;
                    Sfzh = editText002.getText().toString().trim();
                   MM1 = editText003.getText().toString().trim();
                    Zh = editText001.getText().toString().trim();

//                    if(response.equals("true")){
//                        Intent intent911 = new Intent(MainActivity.this, student.class);
//                                        intent911.putExtra("Zh",id);
//                                        startActivity(intent911);
//                    }

                    if (response1.equals(Sfzh)) {
                        Toast.makeText(forget.this, "您的密码已重置成功", Toast.LENGTH_SHORT).show();
                        SendByHttpClient3(Zh,MM1);
                        Intent intent911 = new Intent(forget.this, MainActivity.class);
                        startActivity(intent911);
                    }
                    else if(response1.equals("null"))
                    {
                        Toast.makeText(forget.this, "请输入正确的账号", Toast.LENGTH_SHORT).show();
                    }
                    else if(!response1.equals(Sfzh)&&!response1.equals("null")){
                        Toast.makeText(forget.this, "请输入正确的账号身份证", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:

                    break;

            }

        }

    };

    public void SendByHttpClient2(final String id,final String pw){

        new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    HttpClient httpclient=new DefaultHttpClient();

                    HttpPost httpPost=new HttpPost("http://192.168.50.64:8080/TomcatTest/Login4");//服务器地址，指向Servlet
//                    HttpPost httpPost=new HttpPost("http://172.20.10.2:8080/TomcatTest/Login4");//服务器地址，指向Servlet

                    List<NameValuePair> params=new ArrayList<NameValuePair>();//将id和pw装入list

                    params.add(new BasicNameValuePair("ID",id));
                    params.add(new BasicNameValuePair("PW",pw));
                    final UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params,"utf-8");//以UTF-8格式发送

                    httpPost.setEntity(entity);

                    HttpResponse httpResponse= httpclient.execute(httpPost);

                    if(httpResponse.getStatusLine().getStatusCode()==200)//在200毫秒之内接收到返回值

                    {

                        HttpEntity entity1=httpResponse.getEntity();

                        String response= EntityUtils.toString(entity1, "utf-8");//以UTF-8格式解析

//                        Message message=new Message();
//
//                        message.what=2;
//
//                        message.obj=response;
//
//                        handler.sendMessage(message);

                    }

                }

                catch (Exception e) {

                    e.printStackTrace();

                }

            }

        }).start();

    }
    public void SendByHttpClient3(final String id,final String pw){

        new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    HttpClient httpclient=new DefaultHttpClient();

                    HttpPost httpPost=new HttpPost("http://192.168.50.64:8080/TomcatTest/Login5");//服务器地址，指向Servlet
//                    HttpPost httpPost=new HttpPost("http://172.20.10.2:8080/TomcatTest/Login5");//服务器地址，指向Servlet

                    List<NameValuePair> params=new ArrayList<NameValuePair>();//将id和pw装入list

                    params.add(new BasicNameValuePair("ID",id));

                    params.add(new BasicNameValuePair("PW",pw));

                    final UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params,"utf-8");//以UTF-8格式发送

                    httpPost.setEntity(entity);

                    HttpResponse httpResponse= httpclient.execute(httpPost);

                    if(httpResponse.getStatusLine().getStatusCode()==200)//在200毫秒之内接收到返回值

                    {

                        HttpEntity entity1=httpResponse.getEntity();

                        String response= EntityUtils.toString(entity1, "utf-8");//以UTF-8格式解析

//                        Message message=new Message();
//
//                        message.what=2;
//
//                        message.obj=response;
//
//                        handler.sendMessage(message);

                    }

                }

                catch (Exception e) {

                    e.printStackTrace();

                }

            }

        }).start();

    }
}
