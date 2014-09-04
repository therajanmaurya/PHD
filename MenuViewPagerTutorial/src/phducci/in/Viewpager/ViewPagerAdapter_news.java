package phducci.in.Viewpager;

import phdcci.in.news.News_msme;
import phdcci.in.news.News_niesbud;
import phdcci.in.news.News_phd;
import phdcci.in.news.News_sidbi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter_news extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 5;
	private String titles[] = new String[] { "PHD Chamber News", "MSME News","Niesbud News","Sidbi News","Sidbi News" };

	public ViewPagerAdapter_news(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

			// Open FragmentTab1.java
		case 0:
			News_phd newphd = new News_phd();
			return newphd;
			// Open FragmentTab2.java
		case 1:
			News_msme newsmsme = new News_msme();
			return newsmsme;
		
		case 2:
			News_niesbud newsniesbud = new News_niesbud();
			return newsniesbud;
			
		case 3:
			News_sidbi  newssidbi = new News_sidbi();
			return newssidbi;
			
		case 4:
			News_sidbi  newssidb = new News_sidbi();
			return newssidb;
			
		 
		
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