package phdcci.in.Adapter;

import java.util.ArrayList;

import phdcci.in.BitmapCache;
import phdcci.in.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

@SuppressLint("ResourceAsColor")
public class Adapter_phd_news extends ArrayAdapter<Integer> {

	 
	
	public Context mContext;
	public final BitmapCache mMemoryCache;
	ArrayList<String> Ldesc = new ArrayList<String>();
	 

	public Adapter_phd_news(Context context, int in,
			DisplayImageOptions options, ArrayList<String> contactList2) {
		super(context, in);
		mContext = context;
		Ldesc = contactList2;
		mMemoryCache = new BitmapCache();
	}

	 

	@Override
	public Integer getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Ldesc.size();
	}

	@Override
	public View getView(final int position, final View convertView,
			final ViewGroup parent) {
		final ViewHolder viewHolder;
		View view = convertView;
		if (view == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.niesbud_workshop, parent, false);

			viewHolder = new ViewHolder();
			viewHolder.textView = (TextView) view
					.findViewById(R.id.activity_googlecards_card_textview);
			view.setTag(viewHolder);

 
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
          
         
		viewHolder.textView.setText(Ldesc.get(position));
		 
		return view;
	}

	@SuppressWarnings({ })
	private static class ViewHolder {
		TextView textView;
		TextView imageView;
	}
 

}