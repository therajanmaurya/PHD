package phdcci.in.home;

import phdcci.in.R;
import phdcci.in.about.About_Sidbi;
import phdcci.in.about.About_msme;
import phdcci.in.about.About_niesbud;
import phdcci.in.about.About_nsic;
import phdcci.in.about.About_phd_champber;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class Home_About extends SherlockFragment {
	View linear;
	View rootView1;
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.about_all_screen, container, false);
		
		FrameLayout fr = (FrameLayout) rootView.findViewById(R.id.phd);
		FrameLayout fr1 = (FrameLayout) rootView.findViewById(R.id.niesbud);
		FrameLayout fr2 = (FrameLayout) rootView.findViewById(R.id.sidbi);
		FrameLayout fr3 = (FrameLayout) rootView.findViewById(R.id.msme);
		FrameLayout fr4 = (FrameLayout) rootView.findViewById(R.id.nsic);
		
		
		fr4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 
			    
				About_nsic firstFragment2 = new  About_nsic();
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
			 
			    
				About_Sidbi firstFragment2 = new  About_Sidbi();
				firstFragment2.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
				
						.replace(R.id.content_frame, firstFragment2).addToBackStack(null).commit();			
			}
		});
		
		fr3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 
			    
				About_msme firstFragment3 = new  About_msme();
				firstFragment3.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
				
						.replace(R.id.content_frame, firstFragment3).addToBackStack(null).commit();			
			}
		});
		
		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 
			    
				About_phd_champber firstFragment = new  About_phd_champber();
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
				About_niesbud firstFragment1 = new  About_niesbud();
				firstFragment1.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment1).addToBackStack(null).commit(); 
			}
		});
		
		
		return rootView;
	}
	
}
