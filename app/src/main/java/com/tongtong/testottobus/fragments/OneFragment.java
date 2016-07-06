package com.tongtong.testottobus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Subscribe;
import com.tongtong.testottobus.BusProvider;
import com.tongtong.testottobus.TestEvent1;
import com.tongtong.testottobus.R;
import com.tongtong.testottobus.TestEvent2;
import com.tongtong.tonglib.util.LogUtil;
import com.tongtong.tonglib.util.Util;


public class OneFragment extends Fragment {

    private Button mBtn;
    private int mPlusNum = 0;

    private TextView mTv;
    private String mText = "";

    private boolean isRegister = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup cotainer, Bundle savedInstanceState) {
        LogUtil.d("");

        View view = inflater.inflate(R.layout.fragment_one, cotainer, false);
        mTv = (TextView) view.findViewById(R.id.test_num);

        initUi();
        initEvent();

        return view;
    }

    void initUi() {
        LogUtil.d("");
        mTv.setText(mText);
    }

    void initEvent() {
        LogUtil.d("");
        registerEventBus();
    }

    @Subscribe
    public void getMessageEvent(String message){
        LogUtil.d("String >>> %s", message);

        mText = message;
        mTv.setText(mText);
    }

    @Subscribe
    public void getMessageEvent(TestEvent1 event){
        LogUtil.d("TestEvent1 >>> %s", event.getMessage());

        mText = event.getMessage();
        mTv.setText(mText);
    }

    @Subscribe
    public void getMessageEvent(TestEvent2 event){
        LogUtil.d("TestEvent2 >>> %s %d", event.getTransFrom(), event.getTransNum());

        mText = Util.sprintf("%s %d", event.getTransFrom(), event.getTransNum());
        mTv.setText(mText);
    }

    @Override
    public void onStart() {
        LogUtil.d("");

        super.onStart();
        registerEventBus();
    }

    @Override
    public void onStop() {
        LogUtil.d("");

        super.onStop();
    }

    @Override
    public void onResume() {
        LogUtil.d("");

        super.onResume();
    }

    @Override
    public void onPause() {
        LogUtil.d("");

        super.onPause();
    }

    void registerEventBus() {
        LogUtil.d("isRegister %b", isRegister);

        if(!isRegister) {
            BusProvider.getInstance().register(this);
            isRegister = true;
        }
    }
}