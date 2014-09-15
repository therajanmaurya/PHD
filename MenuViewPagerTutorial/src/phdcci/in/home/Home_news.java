package phdcci.in.home;

import phdcci.in.R;
import phdcci.in.news.New_sub_niesbud;
import phdcci.in.news.News_msme;
import phdcci.in.news.News_phd;
import phdcci.in.news.News_sidbi;
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
		FrameLayout fr2 = (FrameLayout) rootView.findViewById(R.id.msme);
		FrameLayout fr3 = (FrameLayout) rootView.findViewById(R.id.Nsidbi);
		fr2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				News_sidbi firstFragment = new  News_sidbi();
				firstFragment.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment).addToBackStack(null).commit();
			}
		});
		
		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				News_phd firstFragment = new  News_phd();
				firstFragment.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment).addToBackStack(null).commit();
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
						.replace(R.id.content_frame, firstFragment1).addToBackStack(null).commit();
			}
		});

		fr3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				News_msme firstFragment1 = new News_msme();
				firstFragment1.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment1).addToBackStack(null).commit();
			}
		});
		return rootView;
	}

}
