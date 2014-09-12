package phdcci.in;

import java.io.FileOutputStream;

import phdcci.in.home.Home_About;
import phdcci.in.home.Home_finance;
import phdcci.in.home.Home_marketing;
import phdcci.in.home.Home_news;
import phdcci.in.home.Home_schemes;
import phdcci.in.home.Home_trading;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockFragmentActivity {

	// Declare Variables
	Context c;
	DrawerLayout mDrawerLayout;
	ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;
	MenuListAdapter mMenuAdapter;
	String[] title;
	String[] subtitle;
	int[] icon;
	Fragment fragment1 = new Home_About();
	Fragment fragment2 = new Home_finance();
	Fragment fragment3 = new Home_marketing();
	Fragment fragment4 = new Home_trading();
	Fragment fragment5 = new Home_schemes();
	Fragment fragment6 = new Home_news();
	 
	
	//PositionReadWrite RW = new PositionReadWrite();
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	FileOutputStream fos;
	public static int ItemNumber;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Custom Action Bar
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.action_bar);
		
		
		// Get the view from drawer_main.xml
		setContentView(R.layout.drawer_main);

		// Get the Title
		mTitle = mDrawerTitle = getTitle();

		// Generate title
		title = new String[] { "About", "Finance", "Marketing", "Trading",
				"Schemes","News" };

		// Generate subtitle
		//subtitle = new String[] { "About the app", "msme.gov.in", "sidbi.com",
			//	"phdcci.in", "niesbud.nic.in" };

		// Generate icon
		icon = new int[] { R.drawable.icon_about,R.drawable.icon_finance,
				R.drawable.icon_marketing, R.drawable.icon_trading,R.drawable.icon_schems,
				R.drawable.icon_news };

		// Locate DrawerLayout in drawer_main.xml
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		// Locate ListView in drawer_main.xml
		mDrawerList = (ListView) findViewById(R.id.listview_drawer);

		// Set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Pass string arrays to MenuListAdapter
		mMenuAdapter = new MenuListAdapter(MainActivity.this, title, subtitle,
				icon);

		// Set the MenuListAdapter to the ListView
		mDrawerList.setAdapter(mMenuAdapter);

		// Capture listview menu item click
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(view);
			}

			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				// Set the title on the action when drawer open
				getSupportActionBar().setTitle(mDrawerTitle);
				super.onDrawerOpened(drawerView);
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			selectItem(0);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == android.R.id.home) {

			if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
				mDrawerLayout.closeDrawer(mDrawerList);
			} else {
				mDrawerLayout.openDrawer(mDrawerList);
			}
		}

		return super.onOptionsItemSelected(item);
	}

	// ListView click listener in the navigation drawer
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ItemNumber = position;
		    selectItem(position);
		}
	}

	private void selectItem(int position) {

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		// Locate Position

		switch (position) {
		case 0:

			ft.replace(R.id.content_frame, fragment1);
			break;
		case 1:
			ft.replace(R.id.content_frame, fragment2);
			break;
		case 2:
			ft.replace(R.id.content_frame, fragment3);
			break;
		case 3:
			ft.replace(R.id.content_frame, fragment4);
			break;
		case 4:
			ft.replace(R.id.content_frame, fragment5);
			break;
		case 5:
			ft.replace(R.id.content_frame, fragment6);
			break;
		}
		ft.commit();
		mDrawerList.setItemChecked(position, true);
		// Get the title followed by the position
		setTitle(title[position]);
		// Close drawer
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}

	@Override
	public void onBackPressed() {

		FragmentManager manager = getSupportFragmentManager();
		if (manager.getBackStackEntryCount() > 0) {
			// If there are back-stack entries, leave the FragmentActivity
			// implementation take care of them.
			manager.popBackStack();

		} else {
			// Otherwise, ask user if he wants to leave :)
			super.onBackPressed();
		}
	}
	
	@SuppressLint("NewApi")
	public void drawerToggle(View view)
	{
		ImageButton drawer = (ImageButton)findViewById(R.id.navigationButton);
		if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
			mDrawerLayout.closeDrawer(mDrawerList);
			TranslateAnimation anim = new TranslateAnimation(-5, 0, 0, 0);
			anim.setDuration(300);
			anim.setFillAfter(true);
			view.startAnimation(anim);
		} else {
			mDrawerLayout.openDrawer(mDrawerList);
			TranslateAnimation anim = new TranslateAnimation(0, -5, 0, 0);
			anim.setDuration(300);
			anim.setFillAfter(true);
			view.startAnimation(anim);
		}
	}
	
	public void cardToggle(View view) throws InterruptedException
	{
		ImageView imageView = (ImageView)((View)((View) view.getParent()).getParent()).findViewById(R.id.activity_googlecards_card_imageview);
		
		if(imageView==null)
		{
			Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
			return;
		}
		
		if(imageView.getVisibility()==View.GONE)
		{
			ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
			anim.setDuration(300);
			anim.setFillAfter(true);
			imageView.startAnimation(anim);
			imageView.setVisibility(View.VISIBLE);
		}
		else
		{
			ScaleAnimation anim = new ScaleAnimation(1, 1, 1, 0);
			anim.setDuration(300);
			anim.setFillAfter(true);
			imageView.startAnimation(anim);
			anim.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {	}
				
				@Override
				public void onAnimationRepeat(Animation animation) { }
				
				@Override
				public void onAnimationEnd(Animation animation) {
					ImageView imageView1 = (ImageView)findViewById(R.id.activity_googlecards_card_imageview);
					imageView1.setVisibility(View.GONE);
				}
			});
		}
	}
	
	public void infoLayout(View view)
	{
/*		LinearLayout parentLayout = (LinearLayout)findViewById(R.layout.action_bar);
		LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(inflater==null)
			Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
		else
			parentLayout.addView(inflater.inflate(R.layout.action_bar, parentLayout, false), 1);*/
		setContentView(R.layout.action_bar);
	}
}
