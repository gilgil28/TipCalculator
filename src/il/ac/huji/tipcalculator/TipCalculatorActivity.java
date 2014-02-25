package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class TipCalculatorActivity extends Activity {

	private EditText _billAmountET;
	private EditText _tipAmountET;
	private EditText _tipTotalET;
	private EditText _totalET;
	private CheckBox _roundET;

	private double billAmount;
	private double tipAmount;
	private boolean round;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);

		_billAmountET = (EditText)findViewById(R.id.billEditText);
		_tipAmountET = (EditText)findViewById(R.id.tipEditText);
		_totalET = (EditText)findViewById(R.id.totalEditText);
		_tipTotalET = (EditText)findViewById(R.id.tipTotalEditText);
		_roundET = (CheckBox)findViewById(R.id.round);

		billAmount = 100.0;
		tipAmount = 12.0;
		round = false;

		updateTotal();

		_billAmountET.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {

				try{
					billAmount = Double.parseDouble(arg0.toString());
				}
				catch(NumberFormatException e){
					billAmount = 0.0f;
				}
				updateTotal();
			}
		});

		_tipAmountET.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {

				try{
					tipAmount = Double.parseDouble(arg0.toString());
				}
				catch(NumberFormatException e){
					tipAmount = 0.0f;
				}
				updateTotal();
			}
		});

		_roundET.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

				round = isChecked;
				updateTotal();
			}
		});

	}

	private void updateTotal(){

		double tip = tipAmount * billAmount / 100.0f;
		double totalWithTip = tip + billAmount;
		totalWithTip = round ? Math.round(totalWithTip) : totalWithTip;
		_tipTotalET.setText(String.format("%.02f", tip));
		_totalET.setText(String.format("%.02f", totalWithTip));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}
