package com.example.gk.testlearncloud;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.CountCallback;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;
import com.avos.avoscloud.SaveCallback;
import com.example.gk.testlearncloud.bean.ResponseItemBean;
import com.example.gk.testlearncloud.bean.ServerData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_save;
    private Button btn_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private Toast toast;

    private void initEvent() {
        btn_save.setOnClickListener(this);
        btn_query.setOnClickListener(this);
        toast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);
    }

    private void initView() {
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_query = (Button) findViewById(R.id.btn_query);
    }


    private ProgressDialog progressDialog;

    /**
     * 隐藏加载中的dialog
     */
    private void dissmissProgressDialog() {
        if (null != progressDialog && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                progressDialog = ProgressDialog.show(MainActivity.this, "保存", "正在发疯保存中...");
                createObject();
                break;
            case R.id.btn_query:
                progressDialog = ProgressDialog.show(MainActivity.this, "查询", "正在发疯查询中...");
                queryObject();
                break;
        }
    }

    public static final String TABLE_NAME = "TestObject";//表格的名称
    public static int position = 10086;

    /**
     * 创建对象并存储数据
     */
    private void createObject() {
        AVObject testObject = new AVObject(TABLE_NAME);
        testObject.put("foo", "bar");
        testObject.put("name", "imgod");
        testObject.put("sex", "男");
        testObject.put("age", position++);
        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                dissmissProgressDialog();
                if (e == null) {
                    toast.setText("存储成功");
                    toast.show();
                } else {
                    toast.setText("存储失败");
                    toast.show();
                }
            }
        });
    }

    /**
     * 查询对象
     */
    private void queryObject() {
        AVQuery query = new AVQuery(TABLE_NAME);
        query.findInBackground(new FindCallback() {
            @Override
            protected void internalDone0(Object o, AVException e) {
                dissmissProgressDialog();
                if (e == null) {
                    // Success, see count variable
                    resolveQueryResponse(o.toString());
                } else {
                    // Failed
                    Log.e("query", "error:" + e.getCode() + e.getMessage());
                }
            }

            @Override
            public void done(List list, AVException e) {
                dissmissProgressDialog();
                if (e == null) {
                    // Success, see count variable
                    Log.e("query", "count:" + list.size());
                } else {
                    // Failed
                    Log.e("query", "error");
                }
            }
        });
    }

    private List<AVObject> resultList = new ArrayList<>();

    /**
     * 解析得到的对象集合json串
     *
     * @param content
     */
    private void resolveQueryResponse(String content) {
        Log.e("resolveQueryResponse", content);
        List<AVObject> tempList = JSON.parseArray(content, AVObject.class);
        resultList.clear();
        resultList.addAll(tempList);
        Log.e("resolveQueryResponse", "当前服务器共有" + resultList.size() + "条数据");
        toast.setText("当前服务器共有" + resultList.size() + "条数据");
        toast.show();
        for (int i = 0; i < resultList.size(); i++) {
            AVObject av = resultList.get(i);
            Log.e("resolveQueryResponse", "test:" + av.toString());
        }
    }

}
