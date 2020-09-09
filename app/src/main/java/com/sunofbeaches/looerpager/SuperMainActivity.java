package com.sunofbeaches.looerpager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sunofbeaches.looerpager.views.PagerItem;
import com.sunofbeaches.looerpager.views.SobLooperPager;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SuperMainActivity extends AppCompatActivity {

    private SobLooperPager mLooperPager;

    private List<PagerItem> mData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suer_main);
        initData();
        initView();
        initEvent();
        String url = "http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg";
    }

    private void initEvent() {
        if(mLooperPager != null) {
            mLooperPager.setOnItemClickListener(new SobLooperPager.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(SuperMainActivity.this,"点击了第" + (position + 1) + "个item",Toast.LENGTH_SHORT).show();
                    //todo:根据交互业务去实现具体逻辑
                }
            });
        }
    }

    private void initData() {
        mData.add(new PagerItem("第一个图片",R.mipmap.pic0));
        mData.add(new PagerItem("第2个图片",R.mipmap.pic1));
        mData.add(new PagerItem("第三个图片",R.mipmap.pic2));
        mData.add(new PagerItem("第4个图片",R.mipmap.pic3));
//        mData.add(new PagerItem("第一个图片", "http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg"));
//        mData.add(new PagerItem("第二个图片", "http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg"));
//        mData.add(new PagerItem("第三个图片", "http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg"));
//        mData.add(new PagerItem("第四个图片", "http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg"));

    }

    private SobLooperPager.InnerAdapter mInnerAdapter = new SobLooperPager.InnerAdapter() {
        @Override
        protected int getDataSize() {
            return mData.size();
        }

        @Override
        protected View getSubView(ViewGroup container,int position) {
            ImageView iv = new ImageView(container.getContext());
//            iv.setImageResource(mData.get(position).getPicResId());
            Glide.with(SuperMainActivity.this).load(mData.get(position).getPicResId()).into(iv);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            return iv;
        }
    };

    private void initView() {
        mLooperPager = this.findViewById(R.id.sob_looper_pager);
        mLooperPager.setData(mInnerAdapter,new SobLooperPager.BindTitleListener() {
            @Override
            public String getTitle(int position) {
                return mData.get(position).getTitle();
            }
        });
    }
}
