package phducci.in.Viewpager;

import phdcci.in.Marketing;
import phdcci.in.News;
import phdcci.in.Schemes;
import phdcci.in.about.About_niesbud;
import phdcci.in.finance.Finance_niesbud;
import phdcci.in.trading.Trading_msme;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewpagerAdapter_marketing extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 6;
	private String titles[] = new String[] { "About", "Finance","Marketing","Trading","Schemes","News" };

	public ViewpagerAdapter_marketing(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

			// Open FragmentTab1.java
		case 0:
			About_niesbud about = new About_niesbud();
			return about;
			// Open FragmentTab2.java
		case 1:
			Finance_niesbud finance = new Finance_niesbud();
			return finance;
		
		case 2:
			Marketing Marketing = new Marketing();
			return Marketing;
			
		case 3:
			Trading_msme trading = new Trading_msme();
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