package phdcci.in.news;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import phdcci.in.R;
import phdcci.in.Adapter.Adapter_niesbud_traning;
import phdcci.in.Adapter.Adapter_niesbud_workshop;
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
import com.teamDPSR.util.ServiceHandler;

public class New_niesbud_traning extends SherlockFragment {
	int n;
	public static final int INITIAL_DELAY_MILLIS = 300;
	public static ArrayList<String> contactList = new ArrayList<String>();
	public static ArrayList<String> contactList2 = new ArrayList<String>();
	Adapter_niesbud_traning mGoogleCardsAdapter;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	ProgressDialog pDialog;
	Context context;
	static DisplayImageOptions options;
	String url = "http://pa1pal.tk/niesbud_training.txt";
	ListView listView;
	int nn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		final View view = inflater.inflate(R.layout.fragment_news, container,
				false);
		listView = (ListView) view
				.findViewById(R.id.activity_googlecards_listview);

		GetContacts news = new GetContacts();
		news.execute();

//		listView.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				// TODO Auto-generated method stub
//				final TextView textview = (TextView) view
//						.findViewById(R.id.activity_googlecards_card_imageview);
		
//
//				if (textview.getVisibility() == View.GONE) {
//
//					ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
//					anim.setDuration(300);
//					anim.setFillAfter(true);
//					textview.startAnimation(anim);
//					anim.setAnimationListener(new AnimationListener() {
//
//						@Override
//						public void onAnimationEnd(Animation animation) {
//							// TODO Auto-generated method stub
//
//						}
//
//						@Override
//						public void onAnimationRepeat(Animation animation) {
//							// TODO Auto-generated method stub
//
//						}
//
//						@Override
//						public void onAnimationStart(Animation animation) {
//							// TODO Auto-generated method stub
////							if (textview.getVisibility() == View.GONE) {
////								textview
////										.setVisibility(View.VISIBLE);
////							} else {
////								textview.setVisibility(View.GONE);
////							}
//							textview
//							.setVisibility(View.VISIBLE);
//						}
//
//					});
//
//				} else {
//					ScaleAnimation anim = new ScaleAnimation(1, 1, 1, 0);
//					anim.setDuration(500);
//					anim.setFillAfter(true);
//					textview.startAnimation(anim);
//					anim.setAnimationListener(new AnimationListener() {
//
//						@Override
//						public void onAnimationStart(Animation animation) {
//						}
//
//						@Override
//						public void onAnimationRepeat(Animation animation) {
//						}
//
//						@Override
//						public void onAnimationEnd(Animation animation) {
//							textview.setVisibility(View.GONE);
//						}
//					});
//				}
//
//			}
//		});

		return view;
	}

	public class GetContacts extends AsyncTask<Void, Void, Void> {

		private static final String TAG_ID = "title";
		private static final String TAG_dec = "description";

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			// pDialog=ProgressDialog.show(, title, message)
			// pDialog = new ProgressDialog(context);
			// pDialog.setMessage("Please wait...");
			// pDialog.setCancelable(false);
			// pDialog.show();

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
			// pDialog.dismiss();
			mGoogleCardsAdapter = new Adapter_niesbud_traning(getActivity()
					.getApplicationContext(), R.layout.niesbud_workshop,
					options, contactList2, contactList);
			listView.setAdapter(mGoogleCardsAdapter);

		}

	}

}
