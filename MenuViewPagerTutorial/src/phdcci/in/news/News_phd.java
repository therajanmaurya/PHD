package phdcci.in.news;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import phdcci.in.ConnectionDetector;
import phdcci.in.R;
import phdcci.in.ServiceHandler;
import phdcci.in.Adapter.Adapter_phd_news;
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
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class News_phd extends SherlockFragment {
	int n;
	public static final int INITIAL_DELAY_MILLIS = 300;
	public static ArrayList<String> contactList;

	Adapter_phd_news mGoogleCardsAdapter;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	ProgressDialog pDialog;
	Context context;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	static DisplayImageOptions options;
	String url = "http://pa1pal.tk/phd_latest.txt";
	ListView listView;
	int nn;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		view = inflater.inflate(R.layout.fragment_news, container, false);
		listView = (ListView) view
				.findViewById(R.id.activity_googlecards_listview);
		contactList = null;
		contactList = new ArrayList<String>();

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

		private static final String TAG_ID = "news";

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			// pDialog=ProgressDialog.show(, title, message)
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

						contactList.add(id);

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
			mGoogleCardsAdapter = new Adapter_phd_news(getActivity(), n,
					options, contactList);
			listView.setAdapter(mGoogleCardsAdapter);
			// Toast.makeText(getActivity(), "text"+contactList.size(),
			// Toast.LENGTH_SHORT).show();
			// Toast.makeText(getActivity(), "image"+contactList2.size(),
			// Toast.LENGTH_SHORT).show();

		}

	}

	public void EventImageloder() {

		@SuppressWarnings("deprecation")
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

	// @Override
	// public void onDetach() {
	// super.onDetach();
	// getActivity().getSupportFragmentManager().popBackStack();
	// }
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		context().getSupportFragmentManager().popBackStack();
	}
}
