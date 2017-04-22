package com.project.lx.baseapplication.mvp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.lx.baseapplication.R;
import com.project.lx.baseapplication.base.BaseFragment;

/**
 * @author: X_Meteor
 * @description: 类描述
 * @version: V_1.0.0
 * @date: 2017/4/22 16:37
 * @company: 洛阳魅力文化传媒   http://www.fenglin.tv/
 * @email: lx802315@163.com
 */
public class homeFragment extends BaseFragment {
    @Override
    protected View initLayout(LayoutInflater inflater, ViewGroup container, boolean b) {
        View rootView = inflater.inflate(R.layout.activity_main, null);
        return rootView;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }
}
