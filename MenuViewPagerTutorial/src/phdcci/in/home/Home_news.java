package phdcci.in.home;

import phdcci.in.R;
import phdcci.in.news.New_sub_niesbud;
import phdcci.in.news.News_phd;
import phdcci.in.news.News_sidbi;
import phducci.in.Viewpager.Viewpager_news;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class Home_news extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater
				.inflate(R.layout.company_news, container, false);
		FrameLayout fr = (FrameLayout) rootView.findViewById(R.id.PhdFram);
		FrameLayout fr1 = (FrameLayout) rootView.findViewById(R.id.niesbud);

		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				News_sidbi firstFragment = new  News_sidbi();
				firstFragment.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment).commit();
			}
		});

		fr1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				New_sub_niesbud firstFragment1 = new New_sub_niesbud();
				firstFragment1.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment1).commit();
			}
		});

		return rootView;
	}

}
