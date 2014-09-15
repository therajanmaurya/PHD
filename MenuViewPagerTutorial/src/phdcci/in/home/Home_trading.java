package phdcci.in.home;

import phdcci.in.R;
import phdcci.in.trading.Trading_msme;
import phdcci.in.trading.Trading_niesbud;
import phdcci.in.trading.Trading_nisc;
import phdcci.in.trading.Trading_phd;
import phdcci.in.trading.Trading_sidbi;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class Home_trading extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater
				.inflate(R.layout.all_trading, container, false);
		FrameLayout fr = (FrameLayout) rootView.findViewById(R.id.Tphd);
		FrameLayout fr2 = (FrameLayout) rootView.findViewById(R.id.Tniesbud);
		FrameLayout fr3 = (FrameLayout) rootView.findViewById(R.id.Tsidbi);
		FrameLayout fr4 = (FrameLayout) rootView.findViewById(R.id.Tmsme);
		FrameLayout fr1 = (FrameLayout) rootView.findViewById(R.id.Tnsic);

		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Trading_phd firstFragment2 = new Trading_phd();
				firstFragment2.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()

				.replace(R.id.content_frame, firstFragment2)
						.addToBackStack(null).commit();
			}
		});

		fr1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Trading_nisc firstFragment2 = new Trading_nisc();
				firstFragment2.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()

				.replace(R.id.content_frame, firstFragment2)
						.addToBackStack(null).commit();
			}
		});

		fr2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Trading_niesbud firstFragment3 = new Trading_niesbud();
				firstFragment3.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()

				.replace(R.id.content_frame, firstFragment3)
						.addToBackStack(null).commit();
			}
		});

		fr3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Trading_sidbi firstFragment = new Trading_sidbi();
				firstFragment.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()

				.replace(R.id.content_frame, firstFragment)
						.addToBackStack(null).commit();
			}
		});

		fr4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			     Trading_msme firstFragment1 = new Trading_msme();
				firstFragment1.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment1)
						.addToBackStack(null).commit();
			}
		});
		return rootView;
	}

}
