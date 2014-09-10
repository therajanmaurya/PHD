package phdcci.in.Adapter;

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

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class GoogleCardsAdapter extends ArrayAdapter<Integer> {

	protected ImageLoader imageloder = ImageLoader.getInstance();
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
	DisplayImageOptions option;
	public Context mContext;
	public final BitmapCache mMemoryCache;
	ArrayList<String> Ldesc = new ArrayList<String>();
	ArrayList<String> ImageLink = new ArrayList<String>();

	public GoogleCardsAdapter(Context context, int in,
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
					R.layout.googlecardadapter, parent, false);

			viewHolder = new ViewHolder();
			viewHolder.textView = (TextView) view
					.findViewById(R.id.activity_googlecards_card_textview);
			viewHolder.imageView = (ImageView) view
					.findViewById(R.id.activity_googlecards_card_imageview);
			view.setTag(viewHolder);

			
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
         ImageView im = new ImageView(getContext());
         im = viewHolder.imageView;
        // Toast.makeText(getContext(), ImageLink.get(position), Toast.LENGTH_SHORT).show();
		viewHolder.textView.setText(Ldesc.get(position));
		imageloder.displayImage(ImageLink.get(position), im,
				option, animateFirstListener);
		
		return view;
	}

	@SuppressWarnings({ })
	private static class ViewHolder {
		TextView textView;
		ImageView imageView;
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