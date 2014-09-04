package phdcci.in.news;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import phdcci.in.R;
import phdcci.in.Adapter.GoogleCardsAdapter;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.teamDPSR.util.ServiceHandler;

public class News_niesbud extends SherlockFragment {
	int n ;
	public static final int INITIAL_DELAY_MILLIS = 300;
	public static ArrayList<String> contactList = new ArrayList<String>();
	public static ArrayList<String> contactList2 = new ArrayList<String>();
	GoogleCardsAdapter mGoogleCardsAdapter;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
    ProgressDialog pDialog;
	Context context;
	static DisplayImageOptions options;
	String url="http://pa1pal.tk/msme_latest.txt";
	ListView listView;
	int nn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.fragment_news, container, false);
		listView = (ListView) view
				.findViewById(R.id.activity_googlecards_listview);
		EventImageloder();
		
		GetContacts news = new GetContacts();
		news.execute();

		
		
		return view;
	}
	
	
	public class GetContacts extends AsyncTask<Void, Void, Void> {
		
	 
		private static final String TAG_ID = "image_url";
		private static final String TAG_dec = "description";
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			//pDialog=ProgressDialog.show(, title, message)
//			pDialog = new ProgressDialog(context);
//			pDialog.setMessage("Please wait...");
//			pDialog.setCancelable(false);
//			pDialog.show();

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
					//contacts=jsonObj.getJSONArray(jsonStr);
					Log.d("Response007: ", "> " +jsonObj.toString());
					for (int i = 0; i < jsonObj.length(); i++) {
						JSONObject c = jsonObj.getJSONObject(i);
						String id = c.getString(TAG_ID);
						String id1=c.getString(TAG_dec);
						Log.e("fuck007",id);
						Log.d("fuck007",id1);
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
//			if (pDialog.isShowing())
//				pDialog.dismiss();
			mGoogleCardsAdapter = new GoogleCardsAdapter(getActivity(), n,options,contactList2,contactList);
			listView.setAdapter(mGoogleCardsAdapter);
			 
			 
		}

	}
	
	public void EventImageloder() {

		DisplayImageOptions displayimageOptions = new DisplayImageOptions.Builder()
				.cacheInMemory().cacheOnDisc().build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getActivity().getApplicationContext())
				.defaultDisplayImageOptions(displayimageOptions).build();
		ImageLoader.getInstance().init(config);

		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_launcher)
				.showImageForEmptyUri(R.drawable.ic_launcher)
				.showImageOnFail(R.drawable.ic_launcher).cacheInMemory(true)
				.cacheOnDisk(true).considerExifParams(true)
				.displayer(new RoundedBitmapDisplayer(20)).build();

	}
	
}
