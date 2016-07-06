package com.tongtong.testottobus;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.tongtong.testottobus.fragments.FourFragment;
import com.tongtong.testottobus.fragments.OneFragment;
import com.tongtong.testottobus.fragments.ThreeFragment;
import com.tongtong.testottobus.fragments.TwoFragment;
import com.tongtong.tonglib.adpater.TabFragementAdapter;
import com.tongtong.tonglib.util.Util;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // BusProvider.getInstance().register(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Util.setContext(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        setupTabs();
    }


    /**
     * Adding fragments to ViewPager
     * Adding custom view to tab
     */
    private void setupTabs() {
        TabFragementAdapter adapter = new TabFragementAdapter(this, getSupportFragmentManager(), tabLayout, viewPager);

        adapter.addTab(new OneFragment(), R.drawable.renew_tabitem_home, R.string.tab_name_home, R.drawable.renew_tabitem_titlelabel_selector);
        adapter.addTab(new TwoFragment(), R.drawable.renew_tabitem_store, R.string.tab_name_store, R.drawable.renew_tabitem_titlelabel_selector);
        adapter.addTab(new ThreeFragment(), R.drawable.renew_tabitem_coupon, R.string.tab_name_coupon, R.drawable.renew_tabitem_titlelabel_selector);
        adapter.addTab(new FourFragment(), R.drawable.renew_tabitem_more, R.string.tab_name_more, R.drawable.renew_tabitem_titlelabel_selector);

        viewPager.setAdapter(adapter);

        adapter.createTabs();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
