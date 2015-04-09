/*
 * Copyright (C) 2014-2016  福建星网视易信息系统有限公司
 * All rights reserved by  福建星网视易信息系统有限公司
 *
 *  Modification History:
 *  Date        Author      Version     Description
 *  -----------------------------------------------
 *  2015-4-1     "zhouxinghua"     1.0         [修订说明]
 *
 */

package com.zxh.demos.home;

import java.util.ArrayList;
import java.util.List;

import com.zxh.demos.R;
import com.zxh.demos.activity.LifeCycleActivity;
import com.zxh.demos.activity.RomeoActivity;
import com.zxh.demos.helloworld.HelloWorldActivity;
import com.zxh.demos.service.StartServiceActivity;
import com.zxh.demos.widget.BaseAdapterHelper;
import com.zxh.demos.widget.QuickAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * [功能说明]
 */
public class HomeActivity extends Activity {
    
    private List<ActivityItem> mItems = new ArrayList<ActivityItem>();
    
    private ListView mListView;
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_home_lay);
        
        initData();
        
        mListView = (ListView) findViewById(R.id.lv);
        
        QuickAdapter<ActivityItem> adapter = new QuickAdapter<ActivityItem>(this, 
                R.layout.home_list_item, mItems) {
            @Override
            protected void convert(BaseAdapterHelper helper, ActivityItem item,
                    int position) {
                helper.setText(R.id.tv, item.name);
            }
        };
        
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                ActivityItem item = (ActivityItem) parent.getAdapter().getItem(position);
                if (item == null) {
                    return;
                }
                gotoAC(item.aClass);
            }
        });
        
    }
    
    private void initData() {
        mItems.add(new ActivityItem("hello world", HelloWorldActivity.class));
        mItems.add(new ActivityItem("start activity mode", LifeCycleActivity.class));
        mItems.add(new ActivityItem("start activity for result", RomeoActivity.class));
        mItems.add(new ActivityItem("life cycle", LifeCycleActivity.class));
        mItems.add(new ActivityItem("start service", StartServiceActivity.class));
    }
    
    private void gotoAC(Class<? extends Activity> aClass) {
        Intent intent = new Intent(HomeActivity.this, aClass);
        startActivity(intent);
    }

}
