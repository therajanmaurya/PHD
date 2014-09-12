package phdcci.in.news;

import phdcci.in.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class New_sub_niesbud extends SherlockFragment {
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.niesbud_news, container, false);
		 FrameLayout PhdFram = (FrameLayout)view.findViewById(R.id.workshopnews);
		 FrameLayout traning = (FrameLayout)view.findViewById(R.id.traning);
		 FrameLayout workshop = (FrameLayout)view.findViewById(R.id.pressnews);
		 PhdFram.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				New_niesbud_workshop firstFragment1 = new New_niesbud_workshop();
				firstFragment1.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment1).addToBackStack(null).commit();
			}
		});
		 
		 traning.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					New_niesbud_traning firstFragment1 = new New_niesbud_traning();
					firstFragment1.setArguments(getActivity().getIntent()
							.getExtras());
					getActivity().getSupportFragmentManager().beginTransaction()
							.replace(R.id.content_frame, firstFragment1).addToBackStack(null).commit();
				}
			});
		 workshop.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					New_niesbud_pressnews firstFragment1 = new New_niesbud_pressnews();
					firstFragment1.setArguments(getActivity().getIntent()
							.getExtras());
					getActivity().getSupportFragmentManager().beginTransaction()
							.replace(R.id.content_frame, firstFragment1).addToBackStack(null).commit();
				}
			});
		
		
		
		return view;
	}
}
