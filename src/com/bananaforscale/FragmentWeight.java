package com.bananaforscale;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class FragmentWeight extends Fragment {
	
	EditText mInput;
	Spinner mWeightSpinner;
	Button mCalculateBtn;
	TextView mOutput;
	
	private String color_yellow = "#f1f211";
	private String color_lightbrown = "#a3a574";
	private String color_brown = "#989a6d";
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState){

		View weightFragmentView = inflater.inflate(R.layout.weight_fragment, container, false);
		
		mInput = (EditText) weightFragmentView.findViewById(R.id.input);
		mWeightSpinner = (Spinner) weightFragmentView.findViewById(R.id.choose_unity_weight);
		mCalculateBtn = (Button) weightFragmentView.findViewById(R.id.calculate);
		mOutput = (TextView) weightFragmentView.findViewById(R.id.output);
		
		//mCalculateBtn.setBackgroundDrawable(new ColorDrawable(Color.parseColor(color_lightbrown)));
		mCalculateBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				calculate();
			}			
		});
		
		return weightFragmentView;
	}
	
	public void calculate(){
		double inputByOperator;
		Double inputValue;
		Double[] inputValuesArray = {1000.0, 1.0, 0.0022046};
		int spinnerPosition = mWeightSpinner.getSelectedItemPosition();
		
		double inputInG;
		double gToBananaFactor = 120.0;
		double bananaResult;
		
		if(mInput.getText().length() < 1){
			mOutput.setText(getResources().getText(R.string.invalid_value));
		} else {
			inputByOperator = Double.parseDouble(mInput.getText().toString());
			inputValue = inputValuesArray[spinnerPosition];
			
			//refactor the input values to banana size
			inputInG = inputByOperator * inputValue;
			inputInG = inputInG / gToBananaFactor;
			
			//round to whole bananas and create output
			bananaResult = Math.round(inputInG * 100.0) / 100.0;
			mOutput.setText(String.valueOf(bananaResult) + " average bananas");	
		}
		
	}

}
