package com.tongtong.testottobus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tongtong.testottobus.BusProvider;
import com.tongtong.testottobus.TestEvent1;
import com.tongtong.testottobus.R;
import com.tongtong.testottobus.TestEvent2;
import com.tongtong.tonglib.util.LogUtil;
import com.tongtong.tonglib.util.Util;


public class FourFragment extends Fragment {

    private TextView mTv;
    private Button mBtn;
    private int mPlusNum = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup cotainer, Bundle savedInstanceState) {
        LogUtil.d("");

        View view = inflater.inflate(R.layout.fragment_four, cotainer, false);

        mTv = (TextView) view.findViewById(R.id.progressingText);
        mBtn = (Button) view.findViewById(R.id.btn);

        mTv.setText(Util.sprintf("[Four Fragment] num : %d", mPlusNum));

        mBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPlusNum ++ ;
                LogUtil.d("[Four Fragment] num : %d", mPlusNum);
                mTv.setText(Util.sprintf("[Four Fragment] num : %d", mPlusNum));
                // BusProvider.getInstance().post(Util.sprintf("%s %d", "Two Fragment", mPlusNum));
                // BusProvider.getInstance().post(new TestEvent1(Util.sprintf("%s %d", "Three Fragment", mPlusNum)));
                BusProvider.getInstance().post(new TestEvent2("Four Fragment", mPlusNum));
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        LogUtil.d("");

        super.onStart();
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
}