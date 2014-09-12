package phdcci.in.home;

import phdcci.in.R;
import phdcci.in.news.News_sidbi;
import phdcci.in.schemes.Schemes_msme;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class Home_schemes extends SherlockFragment {
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.all_schemes, container, false);
		FrameLayout fr = (FrameLayout) rootView.findViewById(R.id.Smsme);
		//FrameLayout fr1 = (FrameLayout) rootView.findViewById(R.id.niesbud);

		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Schemes_msme firstFragment = new  Schemes_msme();
				firstFragment.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment).addToBackStack(null).commit();
			}
		});
		return rootView;
	}
	
}
