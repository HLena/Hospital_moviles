package com.example.hospital;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class InfoHospitalActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_hospital);

        //adapter = new TabAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.especialidad_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.doctor_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.paciente_icon);
        Fragment tabFragment = new TabFragment();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){


            @Override
            public void onTabSelected(TabLayout.Tab tab){
                //System.out.println(" aqiiiiiiiiiiii: " + tab.getPosition());
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

}



