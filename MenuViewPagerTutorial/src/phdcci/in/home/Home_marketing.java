package phdcci.in.home;

import phdcci.in.R;
import phdcci.in.about.About_Sidbi;
import phdcci.in.about.About_msme;
import phdcci.in.about.About_niesbud;
import phdcci.in.about.About_nsic;
import phdcci.in.about.About_phd_champber;
import phdcci.in.marketing.Marketing_msme;
import phdcci.in.marketing.Marketing_niesbud;
import phdcci.in.marketing.Marketing_nisc;
import phdcci.in.marketing.Marketing_phd;
import phdcci.in.marketing.Marketing_sidbi;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class Home_marketing extends SherlockFragment {
	
	 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.all_marketing, container, false);
		
		FrameLayout fr = (FrameLayout) rootView.findViewById(R.id.Mphd);
		FrameLayout fr2 = (FrameLayout) rootView.findViewById(R.id.Mniesbud);
		FrameLayout fr3 = (FrameLayout) rootView.findViewById(R.id.Msidbi);
		FrameLayout fr4 = (FrameLayout) rootView.findViewById(R.id.Mmsme);
		FrameLayout fr1 = (FrameLayout) rootView.findViewById(R.id.Mnsic);
		
		
		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 
			    
				Marketing_phd firstFragment2 = new  Marketing_phd();
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
			 
			    
				Marketing_nisc firstFragment2 = new  Marketing_nisc();
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
			 
			    
				Marketing_niesbud firstFragment3 = new  Marketing_niesbud();
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
			 
			    
			     Marketing_sidbi firstFragment = new  Marketing_sidbi();
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
				Marketing_msme firstFragment1 = new  Marketing_msme();
				firstFragment1.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment1).addToBackStack(null).commit(); 
			}
		});
		
		
		
		return rootView;
	}
	
}
