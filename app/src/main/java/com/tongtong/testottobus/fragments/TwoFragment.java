package com.tongtong.testottobus.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tongtong.testottobus.BusProvider;
import com.tongtong.testottobus.EventBusCallTest;
import com.tongtong.testottobus.R;
import com.tongtong.tonglib.util.LogUtil;
import com.tongtong.tonglib.util.Util;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class TwoFragment extends Fragment {

    private TextView mTv;
    private Button mBtn;
    private int mPlusNum = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup cotainer, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, cotainer, false);

        mTv = (TextView) view.findViewById(R.id.progressingText);
        mBtn = (Button) view.findViewById(R.id.btn);

        mTv.setText(Util.sprintf("[Two Fragment] num : %d", mPlusNum));

        mBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPlusNum ++ ;
                LogUtil.d("[Two Fragment] num : %d", mPlusNum);
                mTv.setText(Util.sprintf("[Two Fragment] num : %d", mPlusNum));
                EventBus.getDefault().post(new EventBusCallTest(mPlusNum));

            }
        });

        return view;
    }

    @Subscribe
    public void onEventMainThread(EventBusCallTest event){

    }

    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}