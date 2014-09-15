package phdcci.in.marketing;

import phdcci.in.ConnectionDetector;
import phdcci.in.R;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class Marketing_nisc extends SherlockFragment {
	WebView web;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.webview, container, false);
		web = null;
		web = (WebView)view.findViewById(R.id.Fwebview);
		web.getSettings().setJavaScriptEnabled(true); 
		String pdf = "http://www.nsic.co.in/mkt2014scheme.pdf ";
		cd = new ConnectionDetector(getActivity().getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		if (isInternetPresent) {
			web.loadUrl("https://docs.google.com/gview?embedded=true&url=" + pdf);

		} else {

			Toast toast = Toast.makeText(getActivity(),
					"internet connection Error", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);		
			toast.show();
		}
		
		return view;
	}
}
