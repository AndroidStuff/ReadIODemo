package com.example.readiodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView = (TextView) findViewById(R.id.textView);
	}

	private void clearText() {
		textView.setText("");
	}

	// onClick Event Handler or UI Button element
	public void readJSONFile(View v) {
		String json = readFileFromAssets("sample_data_array.json");
		clearText();
		textView.setText(json);
		try {
			JSONArray jsonArray = new JSONArray(json);
			Log.i(getClass().getSimpleName(), "Total JSON Objects : " + jsonArray.length());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				Log.i(getClass().getSimpleName(), "JSON Object " + i + " : " + jsonObject.toString());
			}
		} catch (JSONException e) {
		}
	}

	// onClick Event Handler or UI Button element
	public void readTextFile(View v) {
		String text = readFileFromAssets("sample_text.txt");
		clearText();
		textView.setText(text);
	}

	public String readFileFromAssets(String fileName) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder("");
		String line;
		try {
			final InputStream fileStream = getAssets().open(fileName);
			reader = new BufferedReader(new InputStreamReader(fileStream));
			while(true) {
				line = reader.readLine();
				if(line == null) break;
				sb.append(line).append("\n");
			}
			return sb.toString();
		} catch (IOException e) {
		} finally {
			try {
				reader.close();
			} catch (IOException e) {}
		}
		return "";
	}
}
