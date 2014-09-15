package phdcci.in.home;

import phdcci.in.R;
import phdcci.in.finance.Finance_msme;
import phdcci.in.finance.Finance_niesbud;
import phdcci.in.finance.Finance_nisc;
import phdcci.in.finance.Finance_phd;
import phdcci.in.finance.Finance_sidbi;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class Home_finance extends SherlockFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.all_finances, container,
				false);
		FrameLayout fr4 = (FrameLayout) rootView.findViewById(R.id.Fmsme);
		FrameLayout fr3 = (FrameLayout) rootView.findViewById(R.id.Fsidbi);
		FrameLayout fr2 = (FrameLayout) rootView.findViewById(R.id.Fniesbud);
		FrameLayout fr = (FrameLayout) rootView.findViewById(R.id.Fphd);
		FrameLayout fr1 = (FrameLayout) rootView.findViewById(R.id.Fnsic);

		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Finance_phd firstFragment = new  Finance_phd();
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
				Finance_nisc firstFragment = new  Finance_nisc();
				firstFragment.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment).addToBackStack(null).commit();
			}
		});
		fr2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Finance_niesbud firstFragment = new  Finance_niesbud();
				firstFragment.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment).addToBackStack(null).commit();
			}
		});
		fr3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Finance_sidbi firstFragment = new  Finance_sidbi();
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
				Finance_msme firstFragment = new  Finance_msme();
				firstFragment.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment).addToBackStack(null).commit();
			}
		});
		return rootView;
	}

 

}
