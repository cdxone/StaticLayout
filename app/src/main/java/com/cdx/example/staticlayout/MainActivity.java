package com.cdx.example.staticlayout;

import android.view.View;

import com.cdx.example.staticlayout.activity.Test1Activity;

import java.util.ArrayList;

import apis.amapv2.com.listviewlibrary.activity.BaseListActivty;
import apis.amapv2.com.listviewlibrary.bean.ItemObject;

public class MainActivity extends BaseListActivty {

    @Override
    protected void initData() {
        mTvTitle.setVisibility(View.VISIBLE);
        mTvTitle.setText("StaticLayout的相关例子");

        ArrayList<ItemObject> data = new ArrayList<>();
        data.add(new ItemObject("StaticLayout实现文字绘制+换行",Test1Activity.class));
        mMyListView.setData(data);
    }
}
