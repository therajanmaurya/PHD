package phdcci.in.Adapter;

import phdcci.in.AppController;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import phdcci.in.BitmapCache;
import phdcci.in.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.toolbox.NetworkImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class Animation extends ArrayAdapter<Integer> {

	protected ImageLoader imageloder = ImageLoader.getInstance();
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
	DisplayImageOptions option;
	public Context mContext;
	public final BitmapCache mMemoryCache;
	ArrayList<String> Ldesc = new ArrayList<String>();
	ArrayList<String> ImageLink = new ArrayList<String>();
	com.android.volley.toolbox.ImageLoader imageLoader = AppController.getInstance().getImageLoader();
	public Animation(Context context, int in,
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
		ViewHolder viewHolder;
		View view = convertView;
		if (view == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.animationadapter, parent, false);

			viewHolder = new ViewHolder();
			viewHolder.textView = (TextView) view
					.findViewById(R.id.activity_googlecards_card_textview);
//			viewHolder.imageView = (ImageView) view
//					.findViewById(R.id.activity_googlecards_card_imageview);
			viewHolder.imgNetWorkView = (NetworkImageView) view
					.findViewById(R.id.activity_googlecards_card_imageview);
			
			view.setTag(viewHolder);

			
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
         ImageView im = new ImageView(getContext());
         im = viewHolder.imgNetWorkView;
         //Toast.makeText(getContext(), ImageLink.size() , Toast.LENGTH_SHORT).show();
		viewHolder.textView.setText(Ldesc.get(position));
//		imageloder.displayImage(ImageLink.get(position), im,
//				option, animateFirstListener);
		
		

		// If you are using NetworkImageView
		viewHolder.imgNetWorkView.setImageUrl(ImageLink.get(position), imageLoader);

		
		// If you are using normal ImageView
		/*imageLoader.get(Const.URL_IMAGE, new ImageListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e(TAG, "Image Load Error: " + error.getMessage());
			}

			@Override
			public void onResponse(ImageContainer response, boolean arg1) {
				if (response.getBitmap() != null) {
					// load image into imageview
					imageView.setImageBitmap(response.getBitmap());
				}
			}
		});*/

		// Loading image with placeholder and error image
//		ImageView imm = new ImageView(mContext);
//		imageLoader.get(ImageLink.get(position), ImageLoader.getImageListener(imm,
//				R.drawable.ic_launcher, R.drawable.ic_launcher));
		
		Cache cache = AppController.getInstance().getRequestQueue().getCache();
		Entry entry = cache.get(ImageLink.get(position));
		if(entry != null){
			try {
				String data = new String(entry.data, "UTF-8");
				// handle data, like converting it to xml, json, bitmap etc.,
			} catch (UnsupportedEncodingException e) {		
				e.printStackTrace();
			}
		}else{
			// cached response doesn't exists. Make a network call here
		}
		
		
		return view;
	}

	@SuppressWarnings({ })
	private static class ViewHolder {
		TextView textView;
		ImageView imageView;
		NetworkImageView imgNetWorkView;
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