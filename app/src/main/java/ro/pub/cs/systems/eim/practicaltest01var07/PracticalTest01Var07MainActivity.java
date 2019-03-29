package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ro.pub.cs.systems.eim.practicaltest01var07.R;
import ro.pub.cs.systems.eim.practicaltest01var07.Constants;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private EditText firstEditText;
    private EditText secondEditText;
    private EditText thirdEditText;
    private EditText fourhEditText;

    private Button set;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        public boolean isNumeric(String s) {
            return s != null && s.matches("[-+]?\\d*\\.?\\d+");
        }

        @Override
        public void onClick(View view) {
            String firstNr = firstEditText.getText().toString();
            String secondNr = secondEditText.getText().toString();
            String thirdNr = thirdEditText.getText().toString();
            String fourtNr = fourhEditText.getText().toString();
            switch (view.getId()) {
                case R.id.set_button:
                    if(isNumeric(firstNr) && isNumeric(secondNr) && isNumeric(thirdNr) &&
                    isNumeric(fourtNr)) {
                        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                        intent.putExtra(Constants.FIRST_NR, Integer.parseInt(firstNr));
                        intent.putExtra(Constants.SECOND_NR, Integer.parseInt(secondNr));
                        intent.putExtra(Constants.THIRD_NR, Integer.parseInt(thirdNr));
                        intent.putExtra(Constants.FOURTH_NR, Integer.parseInt(fourtNr));
                        startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    }
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        firstEditText = (EditText)findViewById(R.id.first_edit_text);
        secondEditText = (EditText)findViewById(R.id.second_edit_text);
        thirdEditText = (EditText)findViewById(R.id.third_edit_text);
        fourhEditText = (EditText)findViewById(R.id.fourth_edit_text);

        firstEditText.setEnabled(true);
        secondEditText.setEnabled(true);
        thirdEditText.setEnabled(true);
        fourhEditText.setEnabled(true);


        set = (Button)findViewById(R.id.set_button);
        set.setOnClickListener(buttonClickListener);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(Constants.FIRST_NR, firstEditText.getText().toString());
        savedInstanceState.putString(Constants.SECOND_NR, secondEditText.getText().toString());
        savedInstanceState.putString(Constants.THIRD_NR, thirdEditText.getText().toString());
        savedInstanceState.putString(Constants.FOURTH_NR, fourhEditText.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.FIRST_NR)) {
            firstEditText.setText(savedInstanceState.getString(Constants.FIRST_NR));
        } else {
            firstEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey(Constants.SECOND_NR)) {
            secondEditText.setText(savedInstanceState.getString(Constants.SECOND_NR));
        } else {
            secondEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey(Constants.THIRD_NR)) {
            thirdEditText.setText(savedInstanceState.getString(Constants.THIRD_NR));
        } else {
            thirdEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey(Constants.FOURTH_NR)) {
            fourhEditText.setText(savedInstanceState.getString(Constants.SECOND_NR));
        } else {
            fourhEditText.setText(String.valueOf(0));
        }
    }
}
