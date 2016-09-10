package com.example.gk.testlearncloud.app;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * 项目名称：TestLearnCloud
 * 类描述：
 * 创建人：gk
 * 创建时间：2016/9/10 11:50
 * 修改人：gk
 * 修改时间：2016/9/10 11:50
 * 修改备注：
 */
public class App extends Application {
    public static final String LEANCOULD_ID = "v9m06d0rlb4iyo92ma3m2hlrot994ujqv15hukna4d93q53u";
    public static final String LEANCOULD_KEY = "mr3rm08v5xc3sg44r6qnwtbrqtyr57gsdy6lzj5aak0b9q2a";

    @Override
    public void onCreate() {
        super.onCreate();
        initSdk();
    }

    private void initSdk() {
        AVOSCloud.initialize(this, LEANCOULD_ID, LEANCOULD_KEY);
    }
}
