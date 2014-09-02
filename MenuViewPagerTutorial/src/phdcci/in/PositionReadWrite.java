package phdcci.in;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.content.Context;
import android.util.Log;

public class PositionReadWrite  {

	FileOutputStream fos;
	static String FILENAME = "ItemNumber";
	static String TAG = "position written sucessfully";
	static int ItemPosition ;
	String TAG_ = "SORRY";
	public static void PositionWrite(int position,Context C) {

		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					C.openFileOutput(FILENAME, Context.MODE_PRIVATE));
			outputStreamWriter.write(position);
			outputStreamWriter.close();
		} catch (IOException e) {
			Log.e(TAG, "File write failed: " + e.toString());
		}
		
	}
	
	public static int PositionRead(Context c){
		
		try {
			InputStream inputStream =c.openFileInput(FILENAME);

			if (inputStream != null) {
				InputStreamReader inputStreamReader = new InputStreamReader(
						inputStream);
				BufferedReader bufferedReader = new BufferedReader(
						inputStreamReader);
				String receiveString = "";
				StringBuilder stringBuilder = new StringBuilder();

				while ((receiveString = bufferedReader.readLine()) != null) {
					stringBuilder.append(receiveString);
				}

				inputStream.close();
				ItemPosition =Integer.parseInt(stringBuilder.toString());

			}
		} catch (FileNotFoundException e) {
			Log.e(TAG, "File not found: " + e.toString());
		} catch (IOException e) {
			Log.e(TAG, "Can not read file: " + e.toString());
		}
		
		
		
		return ItemPosition;
	}
	
	
}