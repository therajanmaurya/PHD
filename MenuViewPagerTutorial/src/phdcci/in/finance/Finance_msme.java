package phdcci.in.finance;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;

import phdcci.in.ConnectionDetector;
import phdcci.in.MainActivity;
import phdcci.in.R;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.teamDPSR.util.GetContacts;

public class Finance_msme extends SherlockFragment {

	FileInputStream fis;
	int n = MainActivity.ItemNumber;

	// EventSQL db;
	private static final String ARG_SECTION_NUMBER = "section_number";
	Context context;
	static DisplayImageOptions options;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	ProgressDialog progress;
	EventAdapter adp;
	ProgressBar Pevent;
	// ConnectionDetector cd;
	Boolean isInternetPresent = false;
	private static String urljson = "http://pa1pal.tk/LE.json";
	private static final String TAG_Latest = "Latest";
	private static final String TAG_TITLE = "Title";
	private static final String TAG_Date = "Date";
	private static final String TAG_Venue = "Venue";
	private static final String TAG_Description = "Description";
	private static final String TAG_ImageLink = "link";
	JSONArray Latest = null;
	ArrayList<String> TitleS = new ArrayList<String>();
	ArrayList<String> DateS = new ArrayList<String>();
	ArrayList<String> VenueS = new ArrayList<String>();
	ArrayList<String> Ldesc = new ArrayList<String>();
	ArrayList<String> ImageLink = new ArrayList<String>();
    ConnectionDetector cd;
	ExpandableListView expand;

	ArrayList<String> urlf = new ArrayList<String>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.fragment_finance, container,
				false);
		Toast.makeText(getActivity(), "" + n, Toast.LENGTH_LONG).show();
		//Pevent = (ProgressBar) view.findViewById(R.id.progressBar1);

		context = getActivity().getApplicationContext();
		//db = new EventSQL(context);
		EventImageloder();
		expand = (ExpandableListView) view.findViewById(R.id.eventExpandlist);
		cd = new ConnectionDetector(getActivity().getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		new xfuck().execute();

		return view;
	}

private class xfuck extends AsyncTask<Void, Void, Void>{
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		
		super.onPreExecute();
		GetContacts Ldata = new GetContacts(getActivity());
		//context.deleteDatabase("EventDB");
		Ldata.execute();
	}
	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		return null;
	}
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		adp = new EventAdapter(getActivity(),options,GetContacts.contactList2, GetContacts.contactList);
		expand.setAdapter(adp);
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

class EventAdapter extends BaseExpandableListAdapter {
	Context context;
	Typeface type;

	protected ImageLoader imageloder = ImageLoader.getInstance();
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
	DisplayImageOptions option;

	
	ArrayList<String> desT = new ArrayList<String>();
	ArrayList<String> Im_link = new ArrayList<String>();

	protected LayoutInflater inflater = null;

	public EventAdapter(Context context, DisplayImageOptions options,
			ArrayList<String> ldesc,
			ArrayList<String> imageLink) {
		// TODO Auto-generated constructor stub
		
		desT = ldesc;
		Im_link = imageLink;

		this.context = context;
		option = options;

	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return desT.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	public class Holder {
		TextView tv, tv1;
		ImageView img;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.latestlistitem, null);
		}
		ImageView im = (ImageView) convertView.findViewById(R.id.latestimg);
		TextView venue = (TextView) convertView.findViewById(R.id.latestvenue);
		imageloder.displayImage(Im_link.get(groupPosition), im, option,animateFirstListener);

		venue.setText(desT.get(groupPosition).substring(1, 10));
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.childlist, null);
		}
		final TextView des = (TextView) convertView
				.findViewById(R.id.textViewChild);
		des.setText(desT.get(groupPosition));

		return convertView;

	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

	public static class AnimateFirstDisplayListener extends
			SimpleImageLoadingListener {

		static final List<String> displayedImages = Collections
				.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}

}
