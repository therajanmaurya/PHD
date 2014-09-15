package phdcci.in.news;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import phdcci.in.ConnectionDetector;
import phdcci.in.R;
import phdcci.in.ServiceHandler;
import phdcci.in.Adapter.Adapter_niesbud_workshop;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class New_niesbud_workshop extends SherlockFragment {
	int n;
	public static final int INITIAL_DELAY_MILLIS = 300;
	public static ArrayList<String> contactList ;
	public static ArrayList<String> contactList2 ;
	Adapter_niesbud_workshop mGoogleCardsAdapter;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	ProgressDialog pDialog;
	ProgressBar pro;
	Context context;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;

	static DisplayImageOptions options;
	String url = "http://pa1pal.tk/niesbud_workshop.txt";
	ListView listView;
	int nn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		final View view = inflater.inflate(R.layout.fragment_news, container,
				false);
		contactList = null;
		contactList2 = null;
		contactList = new ArrayList<String>();
		contactList2 = new ArrayList<String>();
		listView = (ListView) view
				.findViewById(R.id.activity_googlecards_listview);

		cd = new ConnectionDetector(getActivity().getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		if (isInternetPresent) {
			GetContacts news = new GetContacts();
			news.execute();

		} else {

			Toast toast = Toast.makeText(getActivity(),
					"internet connection Error", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);		
			toast.show();
		}
		

 
		return view;
	}

	public class GetContacts extends AsyncTask<Void, Void, Void> {

		private static final String TAG_ID = "title";
		private static final String TAG_dec = "description";

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pro = new ProgressBar(getActivity());
			pro.setVisibility(View.VISIBLE);
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
						String id = c.getString(TAG_ID);
						String id1 = c.getString(TAG_dec);
						Log.e("fuck007", id);
						Log.d("fuck007", id1);
						// adding contact to contact list
						contactList.add(id);
						contactList2.add(id1);
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
			pro.setVisibility(View.GONE);
			mGoogleCardsAdapter = new Adapter_niesbud_workshop(getActivity()
					.getApplicationContext(), R.layout.niesbud_workshop,
					options, contactList2, contactList);
			listView.setAdapter(mGoogleCardsAdapter);

		}

	}

}
