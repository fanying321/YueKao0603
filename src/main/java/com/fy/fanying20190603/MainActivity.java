package com.fy.fanying20190603;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;

import com.fy.fanying20190603.fragment.CarFragment;
import com.fy.fanying20190603.fragment.DingFragment;
import com.fy.fanying20190603.fragment.MeFragment;
import com.fy.fanying20190603.fragment.QuanFragment;
import com.fy.fanying20190603.fragment.ShouFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private RadioGroup radio_group;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = findViewById(R.id.viewpager);
        radio_group = findViewById(R.id.radio_group);
        list = new ArrayList<>();
        list.add(new ShouFragment());
        list.add(new QuanFragment());
        list.add(new CarFragment());
        list.add(new DingFragment());
        list.add(new MeFragment());
        viewpager.setAdapter(new Adapter(getSupportFragmentManager()));
        viewpager.setOffscreenPageLimit(5);
        //点击事件
        viewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                    viewpager.setCurrentItem(0,false);
                    break;
                    case R.id.rb2:
                        viewpager.setCurrentItem(1,false);
                        break;
                    case R.id.rb3:
                        viewpager.setCurrentItem(2,false);
                        break;
                    case R.id.rb4:
                        viewpager.setCurrentItem(3,false);
                        break;
                    case R.id.rb5:
                        viewpager.setCurrentItem(4,false);
                        break;
                }
            }
        });
    }
    private class Adapter extends FragmentPagerAdapter {
        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
