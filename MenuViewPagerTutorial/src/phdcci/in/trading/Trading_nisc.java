package phdcci.in.trading;

import phdcci.in.ConnectionDetector;
import phdcci.in.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class Trading_nisc extends SherlockFragment {
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
		 
		WebSettings webSettings = web.getSettings();
		webSettings.setJavaScriptEnabled(true);
		cd = new ConnectionDetector(getActivity().getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		if (isInternetPresent) {
			web.loadUrl("http://www.nsic.co.in/tenders.asp");

		} else {

			Toast.makeText(getActivity(),
					"Network Error", Toast.LENGTH_SHORT)
					.show();
		}
		
		web.getSettings().setLoadWithOverviewMode(true);
		web.getSettings().setAppCacheEnabled(false);
		webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		web.getSettings().setUseWideViewPort(true);
		web.getSettings().setBuiltInZoomControls(true);
		web.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view,
					String url) {
				view.loadUrl(url);
				return true;
			}
		});
		return view;
	}
}
