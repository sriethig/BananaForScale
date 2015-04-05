package com.bananaforscale;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {
	
	protected Context mContext;

	public FragmentAdapter(FragmentManager fm, Context context) {
		super(fm);
		mContext = context;
	}

	public Fragment getItem(int position) {
		switch(position){
		case 0: return new FragmentLength();
		case 1: return new FragmentWeight();
		}
		return null;
	}

	public int getCount() {
		return 2;
	}
	
	public CharSequence getPageTitle(int position){
		switch(position){
		case 0: return "length";
		case 1: return "weight";
		}
		return null;
	}

}

