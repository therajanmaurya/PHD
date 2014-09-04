package phdcci.in.schemes;

import phdcci.in.MainActivity;
import phdcci.in.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class Schemes_news extends SherlockFragment {
    int n =  MainActivity.ItemNumber;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.fragment_schemes, container, false);
		 
		return view;
	}
}
