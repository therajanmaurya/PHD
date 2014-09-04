package com.teamDPSR.util;

//package com.teamDPSR.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class GetContacts extends AsyncTask<Void, Void, Void> {
	private ProgressDialog pDialog;
	Context context;
	String url="http://pa1pal.tk/msme_latest.txt";
	public static ArrayList<String> contactList;
	public static ArrayList<String> contactList2;
//	public GetContacts(int position) {
//		// TODO Auto-generated constructor stub
//	switch(position){
//	
//	}
//	}
public GetContacts(Context c) {
	// TODO Auto-generated constructor stub
	context=c;
}
	private static final String TAG_ID = "image_url";
	private static final String TAG_dec = "description";
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		// Showing progress dialog
		//pDialog=ProgressDialog.show(, title, message)
//		pDialog = new ProgressDialog(context);
//		pDialog.setMessage("Please wait...");
//		pDialog.setCancelable(false);
//		pDialog.show();
		contactList = new ArrayList<String>();
		contactList2 = new ArrayList<String>();

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
					//String name = c.getString(TAG_NAME);
					//String email = c.getString(TAG_EMAIL);
					//String address = c.getString(TAG_ADDRESS);
					//String gender = c.getString(TAG_GENDER);

					// Phone node is JSON Object
					//JSONObject phone = c.getJSONObject(TAG_PHONE);
					//String mobile = phone.getString(TAG_PHONE_MOBILE);
					//String home = phone.getString(TAG_PHONE_HOME);
					//String office = phone.getString(TAG_PHONE_OFFICE);

					// tmp hashmap for single contact
					//HashMap<String, String> contact = new HashMap<String, String>();

					// adding each child node to HashMap key => value
					//contact.put(TAG_ID, id);
					//contact.put(TAG_NAME, name);
					//contact.put(TAG_EMAIL, email);
					//contact.put(TAG_PHONE_MOBILE, mobile);
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
//		if (pDialog.isShowing())
//			pDialog.dismiss();
		/**
		 * Updating parsed JSON data into ListView
		 * */
		
//		ListAdapter adapter = new SimpleAdapter(
//				MainActivity.this, contactList,
//				R.layout.list_item, new String[] { TAG_NAME, TAG_EMAIL,
//						TAG_PHONE_MOBILE }, new int[] { R.id.name,
//						R.id.email, R.id.mobile });
//
//		setListAdapter(adapter);
	}

}