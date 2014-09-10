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
public class Adapter_niesbud_traning extends ArrayAdapter<Integer> {

	 
	
	public Context mContext;
	public final BitmapCache mMemoryCache;
	ArrayList<String> Ldesc = new ArrayList<String>();
	ArrayList<String> ImageLink = new ArrayList<String>();

	public Adapter_niesbud_traning(Context context, int in,
			DisplayImageOptions options, ArrayList<String> contactList2,
			ArrayList<String> contactList) {
		super(context, in);
		mContext = context;
		Ldesc = contactList2;
		ImageLink = contactList;
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
		return ImageLink.size();
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

			viewHolder.imageView = (TextView) view
					.findViewById(R.id.activity_googlecards_card_imageview);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
         TextView im = new TextView(getContext());
         im = viewHolder.imageView;
         
		viewHolder.textView.setText(ImageLink.get(position));
		viewHolder.imageView.setText(Ldesc.get(position));
		viewHolder.imageView.setVisibility(View.GONE);
		
		view.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(viewHolder.imageView.getVisibility() == View.GONE){
					
					ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
					anim.setDuration(300);
					anim.setFillAfter(true);
					viewHolder.imageView.startAnimation(anim);
					anim.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationEnd(Animation animation) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onAnimationRepeat(Animation animation) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onAnimationStart(Animation animation) {
							// TODO Auto-generated method stub
							if(viewHolder.imageView.getVisibility() == View.GONE){
								viewHolder.imageView.setVisibility(View.VISIBLE);	
							}else{
								viewHolder.imageView.setVisibility(View.GONE);
							}
						}
						 
					});
					
					
					}else{
						ScaleAnimation anim = new ScaleAnimation(1, 1, 1, 0);
						anim.setDuration(500);
						anim.setFillAfter(true);
						viewHolder.imageView.startAnimation(anim);	
						anim.setAnimationListener(new AnimationListener() {
							
							@Override
							public void onAnimationStart(Animation animation) {	}
							
							@Override
							public void onAnimationRepeat(Animation animation) { }
							
							@Override
							public void onAnimationEnd(Animation animation) {
								viewHolder.imageView.setVisibility(View.GONE);
							}
						});
					}
				
			}
		});
		return view;
	}

	@SuppressWarnings({ })
	private static class ViewHolder {
		TextView textView;
		TextView imageView;
	}
 

}