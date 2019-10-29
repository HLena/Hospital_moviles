package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;

public class InfoHospitalActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_hospital);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        name = getIntent().getStringExtra("item_name");

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragment(), "Citas");
        adapter.addFragment(new TabFragment(), "Doctores");
        adapter.addFragment(new TabFragment(), "Pacientes");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.especialidad_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.doctor_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.paciente_icon);

        /*tabLayout.setOnTabSelectedListener(new OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                int position = tab.getPosition();
            }
        });*/
    }


}
