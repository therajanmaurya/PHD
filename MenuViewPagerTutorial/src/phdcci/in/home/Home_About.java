package phdcci.in.home;

import phdcci.in.R;
import phdcci.in.news.New_sub_niesbud;
import phdcci.in.news.News_sidbi;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class Home_About extends SherlockFragment {
	View linear;
	View rootView;
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.about_all_screen, container, false);
		
		FrameLayout fr = (FrameLayout) rootView.findViewById(R.id.PhdFram);
		FrameLayout fr1 = (FrameLayout) rootView.findViewById(R.id.niesbud);

		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				if (rootView != null) {
//					
//					rootView = inflater.inflate(R.layout.fragment_about_sidbi, container, false);
//					return ;
//			    }
/*				Fragment f = new Fragment();
				f.getActivity().addContentView(view, params)
//				f.getLayoutInflater(R.layout.fragment_about_niesbud);
				//f.onCreateView(inflater, container, savedInstanceState);
				 
				f.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, f).commit();
*/			
			}
		});

		fr1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 
			}
		});
		
		
		return rootView;
	}
	
}
