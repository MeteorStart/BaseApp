package com.project.lx.baseapplication.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.project.lx.baseapplication.utils.LogUtils;

import java.util.Stack;

import butterknife.ButterKnife;

/**
 * @author: Meteor
 * @description: 所有Activity的基类
 * @version: V 1.0
 * @date: 2016/12/28 0028 15:33
 * @company:
 * @email: lx802315@163.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    //声明一个构建着对象，用于创建警告对话框
    private AlertDialog.Builder builder;
    //用于创建一个进度条对话框
    private ProgressDialog dialog;
    //用于打印log
    private final String TAG = "BaseActivity";
    //声明一个活动管理栈
    private static Stack<Activity> activities = new Stack<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加活动到活动栈中
        activities.add(this);

        //固定屏幕方向
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //设置在activity启动的时候输入法默认不开启
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        initRootView();
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();

        //打印当前类名
        String msg = this.getClass().getName();
        LogUtils.print(msg);
    }

    /**
     * 初始化根布局文件
     */
    public abstract void initRootView();

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化接口
     */
    public abstract void initListener();

    /**
     * 实现沉浸式通知栏，使通知栏和APP的标题颜色一样
     */
    protected void immersiveNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //导航栏透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //底部虚拟按钮透明
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 显示一个警告对话框，无按钮，需要自己设置
     *
     * @param title 标题
     * @param msg   内容
     * @param flag  是否可以取消
     * @return
     */
    protected AlertDialog.Builder showAlertDialog(String title, String msg, boolean flag) {
        if (builder == null) {
            //创建一个构建者对象
            builder = new AlertDialog.Builder(this);
            builder.setTitle(title).setMessage(msg).setCancelable(flag);
        }
        return builder;
    }

    /**
     * 功能:取消警告对话框
     */
    protected void dismissAlertDialog(android.app.AlertDialog alertDialog) {
        if (alertDialog != null) {
            //取消警告对话框
            alertDialog.dismiss();
        }
    }

    /**
     * 功能 ：显示一个进度条对话框
     */
    protected void showProcessDialog(String title, String msg, boolean falg) {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
        }
        dialog.setTitle(title);
        dialog.setMessage(msg);
        dialog.setCancelable(falg);
        dialog.show();
    }

    /**
     * 功能 ：取消一个进度条对话框
     */
    protected void dismissProcessDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /**
     * 判断用户是否登陆过
     *
     * @return true 为登陆成功 false 为没有登陆过
     */
    protected boolean isLogin() {
        return true;
    }

    /**
     * 退出所有活动并且退出当前应用
     */
    public static void exitApplication() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
