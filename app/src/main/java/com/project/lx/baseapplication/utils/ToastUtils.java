package com.project.lx.baseapplication.utils;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * @author: X_Meteor
 * @description: 任意线程的Toast工具类
 * @version:
 * @date: 2017/3/22 0022 14:41
 * @company:
 * @email: lx802315@163.com
 */
public class ToastUtils {
    public static void showToast(Context context, String content) {
        if(Looper.myLooper()!=null){
            Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
        }else{
            Looper.prepare();
            Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }


    }

    public static void showToast(Context context, String content, int length) {
        if(Looper.myLooper()!=null){
            Toast.makeText(context, content, length).show();
        }else{
            Looper.prepare();
            Toast.makeText(context, content, length).show();
            Looper.loop();
        }

    }
}
