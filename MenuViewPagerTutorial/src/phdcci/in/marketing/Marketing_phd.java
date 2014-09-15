package phdcci.in.marketing;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import phdcci.in.ConnectionDetector;
import phdcci.in.R;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class Marketing_phd extends SherlockFragment {
	WebView web;
	ProgressDialog pDialog;
	String url = "http://phdcci.in/media_center.php";
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.webview, container, false);
		web = null;
		web = (WebView)view.findViewById(R.id.Fwebview);
		 
		cd = new ConnectionDetector(getActivity().getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		if (isInternetPresent) {
			new MyTask().execute();

		} else {

			Toast toast = Toast.makeText(getActivity(),
					"internet connection Error", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);		
			toast.show();
		}
		
		 
		return view;
	}
	 
	
	private class MyTask extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = ProgressDialog.show(getActivity(), null,
					"Loading ........", true);
			pDialog.setCancelable(true);

		}
		String html ;
		String mime ;
		String encoding;
	  @Override
	  protected String doInBackground(Void... params) {
		  Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements ele = doc.select("div.box-left");
			html = ele.toString();
			mime = "text/html";
			encoding = "utf-8";
			
			return null;
	  } 


	  @Override
	  protected void onPostExecute(String result) {        
	    //if you had a ui element, you could display the title
		  pDialog.dismiss();
		  web.loadData(html, mime, encoding);
		  web.requestFocus(View.OVER_SCROLL_NEVER);
		  
	  }
	}

}
