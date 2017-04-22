package com.project.lx.baseapplication.utils;

import android.util.Log;

import com.project.lx.baseapplication.constants.Constants;

/**
 * @author: X_Meteor
 * @description: 日志打印工具类,当打生产版本时可将debugVer改为false
 * @version:
 * @date: 2017/3/22 0022 14:41
 * @company:
 * @email: lx802315@163.com
 */
public class LogUtils {
	public static final int TYPE_LOG = 0;
	public static final int TYPE_CONSOLE = 1;
	public static final int TYPE_CRASH_EXCEPTION = 2;

	public static void print(String msg) {
		print(TYPE_LOG, msg);
	}

	public static void print(int logType, String msg) {
		if (!Constants.isShowLog || null == msg) {
			return;
		}

		switch (logType) {
			case TYPE_LOG:
				Log.i("XXXIuLive", msg);
				break;
			case TYPE_CONSOLE:
				System.out.println(msg);
				break;
			case TYPE_CRASH_EXCEPTION:
				Log.e("XXXIuLive", msg);
				break;
		}
	}


}
