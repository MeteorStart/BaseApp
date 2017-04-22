package com.project.lx.baseapplication.application;

import android.app.Application;
import android.content.Context;

import com.project.lx.baseapplication.constants.Constants;
import com.project.lx.baseapplication.utils.CrashHandlerUtils;

/**
 * @author: X_Meteor
 * @description: 自定义的BaseApplication
 * @version: V_1.0.0
 * @date: 2017/4/21 16:34
 * @email: lx802315@163.com
 */
public class BaseApplication extends Application {

    /**
     * 维护一个全局的context对象
     */
    public Context context;

    /**
     * 用于存放当前用户（如果有的话）
     */
//    private static UserInfo currentUser;

    //单例模式
    private static BaseApplication myApplication = null;

    public static BaseApplication getInstance() {
        return myApplication;
    }

    /**
     * 获取当前的用户对象
     *
     * @param currentUser
     */
//    public UserInfo getCurrentUser() {
//        UserInfo user = currentUser;
//        if (user != null) {
//            return user;
//        }
//        return null;
//    }

    /**
     * 设置当前的用户对象
     *
     */
//    public void setCurrentUser(UserInfo currentUser) {
//        this.currentUser = currentUser;
//    }

    /**
     * 定义一个标记
     */
    private static String TAG;

    @Override
    public void onCreate() {
        super.onCreate();
        //把TAG定义为当前类的类名
        TAG = this.getClass().getSimpleName();
        //由于Application类本身已经单例，所以直接按以下处理即可。
        myApplication = this;
        context = getApplicationContext();

        //全局异常处理
        if(Constants.isCollectException){
            CrashHandlerUtils crashHandler = CrashHandlerUtils.getInstance();
            crashHandler.init(getApplicationContext());
        }
    }
}
