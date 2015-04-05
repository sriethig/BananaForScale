package com.bananaforscale;

import com.bananaforscale.R.color;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
	
	static private final String URL = "http://www.9gag.com";
	static private final String CHOOSER_TEXT = "Load " + URL + " with:";
	
	private FragmentAdapter mFragmentAdapter;
	private ViewPager mViewPager;
	private ActionBar mActionBar;
	
	private String color_yellow = "#f1f211";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		mActionBar = getSupportActionBar();
		mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(color_yellow)));;
		
		mFragmentAdapter = new FragmentAdapter(
				getSupportFragmentManager(), this);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mFragmentAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_overflow) {
			open9GagWithChooser();
            return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void open9GagWithChooser(){		
		Intent open9Gag =  new Intent(Intent.ACTION_VIEW,
				Uri.parse(URL));
		Intent chooserIntent = Intent.createChooser(open9Gag,
				CHOOSER_TEXT);
		if(open9Gag.resolveActivity(getPackageManager()) != null){
			startActivity(chooserIntent);
		}		
	}
	
}
