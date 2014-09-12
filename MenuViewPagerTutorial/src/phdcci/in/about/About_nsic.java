package phdcci.in.about;

import phdcci.in.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragment;

public class About_nsic extends SherlockFragment {
 

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab2.xml
		View view = inflater.inflate(R.layout.fragment_about_nsic, container, false);
		Button button = (Button)view.findViewById(R.id.Bnsic);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent myWebLink = new Intent(
						android.content.Intent.ACTION_VIEW, Uri
								.parse(""));
				startActivity(myWebLink);
				
			}
		});
		
		return view;
	}
}