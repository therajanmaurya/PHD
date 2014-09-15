package phdcci.in.schemes;

import phdcci.in.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.actionbarsherlock.app.SherlockFragment;

public class Schemes_sidbi extends SherlockFragment {
	WebView web;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.comingsoon, container, false);
//		web = null;
//		web = (WebView)view.findViewById(R.id.Fwebview);
//		 
//		WebSettings webSettings = web.getSettings();
//		webSettings.setJavaScriptEnabled(true);
//		web.loadUrl("http://www.google.com");
//		web.getSettings().setLoadWithOverviewMode(true);
//		web.getSettings().setAppCacheEnabled(false);
//		webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//		web.getSettings().setUseWideViewPort(true);
//		web.getSettings().setBuiltInZoomControls(true);
//		web.setWebViewClient(new WebViewClient() {
//			@Override
//			public boolean shouldOverrideUrlLoading(WebView view,
//					String url) {
//				view.loadUrl(url);
//				return true;
//			}
//		});
		return view;
	}
}
