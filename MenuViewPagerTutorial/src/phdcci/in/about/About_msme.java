package phdcci.in.about;

import phdcci.in.ConnectionDetector;
import phdcci.in.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class About_msme extends SherlockFragment {

	ConnectionDetector cd;
	Boolean isInternetPresent = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab2.xml
		View view = inflater.inflate(R.layout.fragment_my, container, false);
		
		Button button = (Button)view.findViewById(R.id.Bmsme);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cd = new ConnectionDetector(getActivity().getApplicationContext());
				isInternetPresent = cd.isConnectingToInternet();
				if (isInternetPresent) {
					Intent myWebLink = new Intent(
							android.content.Intent.ACTION_VIEW, Uri
									.parse("http://dcmsme.gov.in/sido/sidocperson.htm"));
					startActivity(myWebLink);
				} else {

					Toast.makeText(getActivity(),
							"Network Error", Toast.LENGTH_SHORT)
							.show();
				}
				
				
			}
		});
		return view;
		
	}
}
