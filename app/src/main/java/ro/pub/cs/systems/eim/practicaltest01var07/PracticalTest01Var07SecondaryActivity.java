package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ro.pub.cs.systems.eim.practicaltest01var07.Constants;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    private EditText firstEditText;
    private EditText secondEditText;
    private EditText thirdEditText;
    private EditText fourthEditText;

    private Button sum;
    private Button product;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int firstNr = Integer.parseInt(firstEditText.getText().toString());
            int secondNr = Integer.parseInt(secondEditText.getText().toString());
            int thirdNr = Integer.parseInt(thirdEditText.getText().toString());
            int fourtNr = Integer.parseInt(fourthEditText.getText().toString());
            switch (view.getId()) {
                case R.id.sum_button:
                    int sum = firstNr + secondNr + thirdNr + fourtNr;
                    Toast.makeText( PracticalTest01Var07SecondaryActivity.this,"Sum is here: " + sum,  Toast.LENGTH_LONG).show();
                    break;
                case R.id.product_button:
                    int prod = firstNr * secondNr * thirdNr * fourtNr;
                    Toast.makeText(PracticalTest01Var07SecondaryActivity.this, "Product is here: " + prod,  Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        firstEditText = (EditText)findViewById(R.id.first_edit_text_2);
        secondEditText = (EditText)findViewById(R.id.second_edit_text_2);
        thirdEditText = (EditText)findViewById(R.id.third_edit_text_2);
        fourthEditText = (EditText)findViewById(R.id.fourth_edit_text_2);

        sum = (Button)findViewById(R.id.sum_button);
        sum.setOnClickListener(buttonClickListener);

        product = (Button)findViewById(R.id.product_button);
        product.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.FIRST_NR)) {
            int firstNr = intent.getIntExtra(Constants.FIRST_NR, -1);
            int secondNr = intent.getIntExtra(Constants.SECOND_NR, -1);
            int thirdNr = intent.getIntExtra(Constants.THIRD_NR, -1);
            int fourthNr = intent.getIntExtra(Constants.FOURTH_NR, -1);

            firstEditText.setText(String.valueOf(firstNr));
            secondEditText.setText(String.valueOf(secondNr));
            thirdEditText.setText(String.valueOf(thirdNr));
            fourthEditText.setText(String.valueOf(fourthNr));
        }
    }
}
