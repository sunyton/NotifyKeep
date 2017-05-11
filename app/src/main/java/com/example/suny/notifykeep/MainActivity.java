package com.example.suny.notifykeep;

import android.content.Intent;
import android.provider.Settings;
import android.service.notification.NotificationListenerService;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.suny.notifykeep.adapter.ViewPagerAdapter;
import com.example.suny.notifykeep.fragment.FragmentApp;
import com.example.suny.notifykeep.fragment.FragmentKeep;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String string = Settings.Secure.getString(getContentResolver(),
                "enabled_notification_listeners");
        if (!string.contains(NotificationListenerService.class.getName())) {
            startActivity(new Intent(
                    "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        }

        mTabLayout = (TabLayout) findViewById(R.id.tabview);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mFragmentList.add(new FragmentKeep());
        mFragmentList.add(new FragmentApp());
        ViewPagerAdapter myadapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(myadapter);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_notifications_paused_white_24dp);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_adb_white_24dp);

    }
}
