package com.example.biye;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import com.example.biye.UploadUtil;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;

import javax.net.ssl.HttpsURLConnection;

/**
 * Activity 上传的界面
 * @author spring sky
 * Email:vipa1888@163.com
 * QQ:840950105
 * MyName:石明政
 *
 */
public class upload extends Activity implements OnClickListener{
    private static final String TAG = "uploadFile";
public static final int EXTERNAL_STORAGE_REQ_CODE = 10 ;
    private static final int TIME_OUT = 10*1000;   //超时时间
    private static final String CHARSET = "utf-8"; //设置编码
//    private static final String TAG = "uploadImage";

//    private static String requestURL = "http://172.20.10.2:8080/biye/";
    private static String requestURL = "http://192.168.0.126:8080/biye/";
    private Button selectImage,uploadImage;
    private ImageView imageView;

    private           String result = null;
    private String picPath = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);
        int permission = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // 请求权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    EXTERNAL_STORAGE_REQ_CODE);
        }

        selectImage = (Button) this.findViewById(R.id.selectImage);
        uploadImage = (Button) this.findViewById(R.id.uploadImage);
        selectImage.setOnClickListener(this);
        uploadImage.setOnClickListener(this);

        imageView = (ImageView) this.findViewById(R.id.imageView);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.selectImage:
                /***
                 * 这个是调用android内置的intent，来过滤图片文件   ，同时也可以过滤其他的
                 */
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(intent, 1);
                break;
            case R.id.uploadImage:
                File file = new File(picPath);
                if(file!=null)
                {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            String  BOUNDARY =  UUID.randomUUID().toString();  //边界标识   随机生成
                            String PREFIX = "--" , LINE_END = "\r\n";
                            String CONTENT_TYPE = "multipart/form-data";   //内容类型

                            try {
                                URL url = new URL(requestURL);
                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                conn.setReadTimeout(TIME_OUT);
                                conn.setConnectTimeout(TIME_OUT);
                                conn.setDoInput(true);  //允许输入流
                                conn.setDoOutput(true); //允许输出流
                                conn.setUseCaches(false);  //不允许使用缓存
                                conn.setRequestMethod("POST");  //请求方式
                                conn.setRequestProperty("Charset", CHARSET);  //设置编码
//            conn.setRequestProperty("Charset", "UTF-8");  //设置编码
                                conn.setRequestProperty("connection", "keep-alive");
                                conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);

                                File file = new File(picPath);
                                if(file!=null) {
                                    /**
                                     * 当文件不为空，把文件包装并且上传
                                     */
                                    DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                                    StringBuffer sb = new StringBuffer();
                                    sb.append(PREFIX);
                                    sb.append(BOUNDARY);
                                    sb.append(LINE_END);
                                    /**
                                     * 这里重点注意：
                                     * name里面的值为服务器端需要key   只有这个key 才可以得到对应的文件
                                     * filename是文件的名字，包含后缀名的   比如:abc.png
                                     */

                                    sb.append("Content-Disposition: form-data; name=\"img\"; filename=\"" + file.getName() + "\"" + LINE_END);
                                    sb.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINE_END);
                                    sb.append(LINE_END);
                                    dos.write(sb.toString().getBytes());
                                    InputStream is = new FileInputStream(file);
                                    byte[] bytes = new byte[1024];
                                    int len = 0;
                                    while ((len = is.read(bytes)) != -1) {
                                        dos.write(bytes, 0, len);
                                    }
                                    is.close();
                                    dos.write(LINE_END.getBytes());
                                    byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
                                    dos.write(end_data);
                                    dos.flush();
                                    /**
                                     * 获取响应码  200=成功
                                     * 当响应成功，获取响应的流
                                     */
                                    int res = conn.getResponseCode();
                                    Log.e(TAG, "response code:" + res);
//                if(res==200)
//                {
                                    Log.e(TAG, "request success");
                                    InputStream input = conn.getInputStream();
                                    StringBuffer sb1 = new StringBuffer();
                                    int ss;
                                    while ((ss = input.read()) != -1) {
                                        sb1.append((char) ss);
                                    }
                                    result = sb1.toString();
                                    Log.e(TAG, "result : " + result);
//                }
//                else{
//                    Log.e(TAG, "request error");
//                }
                                }
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
//                    String request = UploadUtil.uploadFile( file, requestURL);

                        }
                    }).start();
                    uploadImage.setText(result);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==Activity.RESULT_OK)
        {
            /**
             * 当选择的图片不为空的话，在获取到图片的途径
             */
            Uri uri = data.getData();

            try {
                String[] pojo = {MediaStore.Images.Media.DATA};

                Cursor cursor = managedQuery(uri, pojo, null, null,null);
                if(cursor!=null)
                {
                    ContentResolver cr = this.getContentResolver();
                    int colunm_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    cursor.moveToFirst();
                    String path = cursor.getString(colunm_index);
                    /***
                     * 这里加这样一个判断主要是为了第三方的软件选择，比如：使用第三方的文件管理器的话，你选择的文件就不一定是图片了，这样的话，我们判断文件的后缀名
                     * 如果是图片格式的话，那么才可以
                     */
                    if(path.endsWith("jpg")||path.endsWith("png"))
                    {
//                        Log.e(TAG, "hahahauri = "+ uri);
                        picPath = path;
                        Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                        imageView.setImageBitmap(bitmap);
//                        imageView.setColorFilter(Color.BLUE);
                    Log.e(TAG, "hahahauri = "+ picPath);
                    }else{alert();}
                }else{alert();}

            } catch (Exception e) {
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void alert()
    {
        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("您选择的不是有效的图片")
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                picPath = null;
                            }
                        })
                .create();
        dialog.show();
    }

}