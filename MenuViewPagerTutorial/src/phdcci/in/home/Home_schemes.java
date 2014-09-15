package phdcci.in.home;

import phdcci.in.R;
import phdcci.in.marketing.Marketing_msme;
import phdcci.in.marketing.Marketing_niesbud;
import phdcci.in.marketing.Marketing_nisc;
import phdcci.in.marketing.Marketing_phd;
import phdcci.in.marketing.Marketing_sidbi;
import phdcci.in.news.News_sidbi;
import phdcci.in.schemes.Schemes_msme;
import phdcci.in.schemes.Schemes_niesbud;
import phdcci.in.schemes.Schemes_nisc;
import phdcci.in.schemes.Schemes_phd;
import phdcci.in.schemes.Schemes_sidbi;
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
		FrameLayout fr = (FrameLayout) rootView.findViewById(R.id.Sphd);
		FrameLayout fr2 = (FrameLayout) rootView.findViewById(R.id.Sniesbud);
		FrameLayout fr3 = (FrameLayout) rootView.findViewById(R.id.Ssidbi);
		FrameLayout fr4 = (FrameLayout) rootView.findViewById(R.id.Smsme);
		FrameLayout fr1 = (FrameLayout) rootView.findViewById(R.id.Snsic);
		
		
		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 
			    
				Schemes_phd firstFragment2 = new  Schemes_phd();
				firstFragment2.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
				
						.replace(R.id.content_frame, firstFragment2).addToBackStack(null).commit();			
			}
		});
		
		fr1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 
			    
				Schemes_nisc firstFragment2 = new  Schemes_nisc();
				firstFragment2.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
				
						.replace(R.id.content_frame, firstFragment2).addToBackStack(null).commit();			
			}
		});
		
		fr2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 
			    
				Schemes_niesbud firstFragment3 = new  Schemes_niesbud();
				firstFragment3.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
				
						.replace(R.id.content_frame, firstFragment3).addToBackStack(null).commit();			
			}
		});
		
		fr3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 
			    
			     Schemes_sidbi firstFragment = new Schemes_sidbi();
				firstFragment.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
				
						.replace(R.id.content_frame, firstFragment).addToBackStack(null).commit();			
			}
		});

		fr4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Schemes_msme firstFragment1 = new  Schemes_msme();
				firstFragment1.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment1).addToBackStack(null).commit(); 
			}
		});
		return rootView;
	}
	
}
