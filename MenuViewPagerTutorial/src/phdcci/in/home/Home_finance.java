package phdcci.in.home;

import phdcci.in.R;
import phdcci.in.finance.Finance_msme;
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
		FrameLayout fr = (FrameLayout) rootView.findViewById(R.id.Fmsme);
		FrameLayout fr1 = (FrameLayout) rootView.findViewById(R.id.Fsidbi);

		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Finance_msme firstFragment = new  Finance_msme();
				firstFragment.setArguments(getActivity().getIntent()
						.getExtras());
				getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, firstFragment).commit();
			}
		});
		fr1.setOnClickListener(new View.OnClickListener() {

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
		return rootView;
	}

//	public boolean onKey(View v, int keyCode, KeyEvent event) {
//	    // TODO Auto-generated method stub
//	    if( keyCode == KeyEvent.KEYCODE_BACK ){
//	            // back to previous fragment by tag
//	             getActivity().finish();
//	            return true;
//	        }
//	        return false;
//	    }

}
