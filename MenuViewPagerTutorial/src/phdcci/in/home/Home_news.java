package phdcci.in.home;

import phdcci.in.R;
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
				.inflate(R.layout.companyname, container, false);
		FrameLayout fr = (FrameLayout) rootView.findViewById(R.id.PhdFram);
		fr.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Viewpager_news firstFragment = new Viewpager_news();
				firstFragment.setArguments(getActivity().getIntent().getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment).commit();
			}
		});
		 
		
		return rootView;
	}

	
}
