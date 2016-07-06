package com.tongtong.testottobus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tongtong.testottobus.EventBusCallTest;
import com.tongtong.testottobus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class OneFragment extends Fragment {

    private Button mBtn;
    private int mPlusNum = 0;

    private TextView mTv;
    private String mText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup cotainer, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, cotainer, false);

        mTv = (TextView) view.findViewById(R.id.test_num);

        return view;
    }

    @Subscribe
    public void onEventMainThread(EventBusCallTest event){
        mText = event.getTransNum() + "";
        mTv.setText(mText);
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