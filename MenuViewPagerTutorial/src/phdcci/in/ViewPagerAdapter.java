package phdcci.in;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 6;
	private String titles[] = new String[] { "About", "Finance","Marketing","Trading","Schemes","News" };

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

			// Open FragmentTab1.java
		case 0:
			About about = new About();
			return about;
			// Open FragmentTab2.java
		case 1:
			Finance finance = new Finance();
			return finance;
		
		case 2:
			Marketing Marketing = new Marketing();
			return Marketing;
			
		case 3:
			Trading trading = new Trading();
			return trading;
			
		case 4:
			Schemes schemes = new Schemes();
			return schemes;
			
		case 5:
			News news = new News();
			return news;
		
		}
		return null;
	}

	public CharSequence getPageTitle(int position) {
		return titles[position];
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

}