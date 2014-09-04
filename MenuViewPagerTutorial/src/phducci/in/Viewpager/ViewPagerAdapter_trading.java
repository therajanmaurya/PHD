package phducci.in.Viewpager;

import phdcci.in.Marketing;
import phdcci.in.News;
import phdcci.in.Schemes;
import phdcci.in.about.About_phd_champber;
import phdcci.in.finance.Finance_phd;
import phdcci.in.trading.Trading_msme;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter_trading extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 6;
	private String titles[] = new String[] { "About", "Finance", "Marketing",
			"Trading", "Schemes", "News" };

	public ViewPagerAdapter_trading(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

		// Open FragmentTab1.java
		case 0:
			About_phd_champber about = new About_phd_champber();
			return about;
			// Open FragmentTab2.java
		case 1:
			Finance_phd finance = new Finance_phd();
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