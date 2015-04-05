package com.bananaforscale;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class FragmentLength extends Fragment {
	
	EditText mInput;
	Spinner mLengthSpinner;
	Button mCalculateBtn;
	TextView mOutput;
	
	private String color_yellow = "#f1f211";
	private String color_lightbrown = "#a3a574";
	private String color_brown = "#989a6d";

	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState){
		
		View lengthFragmentView = inflater.inflate(R.layout.length_fragment, container, false);
		
		mInput = (EditText) lengthFragmentView.findViewById(R.id.input);
		mLengthSpinner = (Spinner) lengthFragmentView.findViewById(R.id.choose_unity_length);
		mCalculateBtn = (Button) lengthFragmentView.findViewById(R.id.calculate);
		mOutput = (TextView) lengthFragmentView.findViewById(R.id.output);
		
		//mCalculateBtn.setBackgroundDrawable(new ColorDrawable(Color.parseColor(color_lightbrown)));
		mCalculateBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				calculate();
			}			
		});
		
		return lengthFragmentView;
	}
	
	public void calculate(){
		double inputByOperator;
		double inputValue;
		double[] inputValuesArray = {100000.0, 100.0, 1.0, 160934.4, 30.48, 2.54};
		int spinnerPosition = mLengthSpinner.getSelectedItemPosition();
		
		double inputInCm;
		double cmToBananaFactor = 17.5;
		double bananaResult;
		
		if(mInput.getText().length() < 1){
			mOutput.setText(getResources().getText(R.string.invalid_value));
		} else {
			inputByOperator = Double.parseDouble(mInput.getText().toString());
			inputValue = inputValuesArray[spinnerPosition];
			
			//refactor the input values to banana size
			inputInCm = inputByOperator * inputValue;
			inputInCm = inputInCm / cmToBananaFactor;
			
			//round to whole bananas and create output
			bananaResult = Math.round(inputInCm * 100.0) / 100.0;
			mOutput.setText(String.valueOf(bananaResult) + " average bananas");
		}
	
	}

}
