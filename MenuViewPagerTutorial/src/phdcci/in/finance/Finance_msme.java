package phdcci.in.finance;

import phdcci.in.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.actionbarsherlock.app.SherlockFragment;

@SuppressLint("SetJavaScriptEnabled")
public class Finance_msme extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.finance_msme, container,
				false);
		
		WebView webview = (WebView) view.findViewById(R.id.Fwebview);
		webview.getSettings().setJavaScriptEnabled(true); 
		String pdf = "http://niesbud.nic.in/docs/press-release-of-international-programmes-7-8-14.pdf";
		webview.loadUrl("https://docs.google.com/gview?embedded=true&url=" + pdf);

		return view;
	}
}
