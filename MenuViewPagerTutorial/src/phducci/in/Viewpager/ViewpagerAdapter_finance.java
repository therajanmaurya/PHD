package phducci.in.Viewpager;

import phdcci.in.Marketing;
import phdcci.in.Schemes;
import phdcci.in.about.About_msme;
import phdcci.in.finance.Finance_msme;
import phdcci.in.news.News_msme;
import phdcci.in.trading.Trading_msme;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewpagerAdapter_finance extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 6;
	private String titles[] = new String[] { "About", "Finance","Marketing","Trading","Schemes","News" };

	public ViewpagerAdapter_finance(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

			// Open FragmentTab1.java
		case 0:
			About_msme about = new About_msme();
			return about;
			// Open FragmentTab2.java
		case 1:
			Finance_msme finance = new Finance_msme();
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
			News_msme news = new News_msme();
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