package com.example.hospital;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {
    public String names_sections[] = {"CITAS", "DOCTORES", "PACIENTES"};
    private Fragment[] childFragments;

    public TabAdapter(FragmentManager fm) {
        super(fm);
        childFragments = new Fragment[] {
                new Appointment(), //0
                new Doctors(), //1
                new patients() //2
        };
    }

    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }

    @Override
    public int getCount() {
        return childFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return names_sections[position];
    }
}