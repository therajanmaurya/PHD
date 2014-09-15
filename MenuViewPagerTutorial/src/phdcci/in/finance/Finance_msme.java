package phdcci.in.finance;

import phdcci.in.ConnectionDetector;
import phdcci.in.R;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

@SuppressLint("SetJavaScriptEnabled")
public class Finance_msme extends SherlockFragment {
 
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.finance_msme, container,
				false);
		cd = new ConnectionDetector(getActivity().getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		if (isInternetPresent) {
			Intent myWebLink = new Intent(
					android.content.Intent.ACTION_VIEW, Uri
							.parse("http://msme.gov.in/WriteReadData/DocumentFile/OUTCOMEBUDGET%202013-14.pdf"));
			startActivity(myWebLink);

		} else {

			Toast toast = Toast.makeText(getActivity(),
					"internet connection Error", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);		
			toast.show();
		}
		

		return view;
	}
}
