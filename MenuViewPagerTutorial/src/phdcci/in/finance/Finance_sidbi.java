package phdcci.in.finance;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import phdcci.in.ConnectionDetector;
import phdcci.in.R;
import phdcci.in.ServiceHandler;
import phdcci.in.Adapter.Adapter_finance_sidbi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class Finance_sidbi extends SherlockFragment {
	int n;
	public static final int INITIAL_DELAY_MILLIS = 300;
	public static ArrayList<String> description = new ArrayList<String>();
	public static ArrayList<String> date ;
	public static ArrayList<String> pdfurl ;
	Adapter_finance_sidbi mGoogleCardsAdapter;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	ProgressDialog pDialog;
	Context context;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	static DisplayImageOptions options;
	String url = "http://pa1pal.tk/sidbi_finance.txt";
	ListView listView;
	int nn;
	 

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		savedInstanceState = null;
		// Get the view from fragmenttab1.xml
		final View view = inflater.inflate(R.layout.fragment_news, container,
				false);
		Toast.makeText(getActivity(), "For more Detail Click on item", Toast.LENGTH_SHORT).show();
		date = null;
		pdfurl = null;
		date = new ArrayList<String>();
		pdfurl = new ArrayList<String>();
		listView = (ListView) view
				.findViewById(R.id.activity_googlecards_listview);

		cd = new ConnectionDetector(getActivity().getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		if (isInternetPresent) {
			GetContacts news = new GetContacts();
			news.execute();

			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					// TODO Auto-generated method stub
					if (pdfurl.get(position) != "null") {
						Intent myWebLink = new Intent(
								android.content.Intent.ACTION_VIEW, Uri
										.parse(pdfurl.get(position)));
						startActivity(myWebLink);
					}

				}
			});

		} else {

			Toast toast = Toast.makeText(getActivity(),
					"internet connection Error", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);		
			toast.show();
		}
		
		

		return view;
	}
	 
	
//	public boolean onKey(View v, int keyCode, KeyEvent event) {
//	    // TODO Auto-generated method stub
//	    if( keyCode == KeyEvent.KEYCODE_BACK ){
//	            // back to previous fragment by tag
//	    	getActivity().getFragmentManager().popBackStack();
//	            return true;
//	        }
//	        return false;
//	    }



	public class GetContacts extends AsyncTask<Void, Void, Void> {

		private static final String TAG_title = "title";
		private static final String TAG_urlgoto = "url";

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = ProgressDialog.show(getActivity(), null,
					"Loading ........", true);
			pDialog.setCancelable(true);

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// Creating service handler class instance
			ServiceHandler sh = new ServiceHandler();

			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

			Log.d("Response: ", "> " + jsonStr);

			if (jsonStr != null) {
				try {
					JSONArray jsonObj = new JSONArray(jsonStr);
					// contacts=jsonObj.getJSONArray(jsonStr);
					Log.d("Response007: ", "> " + jsonObj.toString());
					for (int i = 0; i < jsonObj.length(); i++) {
						JSONObject c = jsonObj.getJSONObject(i);
						String urlgoto = c.getString(TAG_urlgoto);

						String title = c.getString(TAG_title);
						Log.e("fuck007", urlgoto);
						date.add(title);
						pdfurl.add(urlgoto);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the url");
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// Dismiss the progress dialog
			// if (pDialog.isShowing())
			 pDialog.dismiss();
			mGoogleCardsAdapter = new Adapter_finance_sidbi(getActivity()
					.getApplicationContext(), R.layout.niesbud_workshop,
					options, date);
			listView.setAdapter(mGoogleCardsAdapter);

		}

	}

}
