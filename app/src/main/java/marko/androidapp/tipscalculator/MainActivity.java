package marko.androidapp.tipscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enteredMount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView precentagesView;
    private int seekBarPercentage;
    private float enterdBillFloat;
    private TextView totalBillTv;

    String precentage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredMount = findViewById(R.id.text);
        seekBar = findViewById(R.id.procentageSlider);
        calculateButton = findViewById(R.id.calculateButton);
        totalResultTextView = findViewById(R.id.text2);
        precentagesView = findViewById(R.id.procent_view);
        precentage = "%";
        totalBillTv = findViewById(R.id.totalBillTv);

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                precentagesView.setText(String.valueOf(seekBar.getProgress()) + precentage);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekBarPercentage = seekBar.getProgress();
            }
        });
    }

    @Override
    public void onClick(View v) {
        calculate();
    }

    public void calculate()
    {
        float result = 0.0f;

        if(!enteredMount.getText().toString().equals(""))
        {
            enterdBillFloat = Float.parseFloat(enteredMount.getText().toString());
            result = enterdBillFloat * seekBarPercentage / 100;
            totalResultTextView.setText("Your tip will be " + " $" + String.valueOf(result));
            totalBillTv.setText("Total bill: " +  " $" +String.valueOf(enterdBillFloat + result));
        }
        else
        {
            Toast.makeText(MainActivity.this, "Please enter a bill amount", Toast.LENGTH_LONG).show();
        }

    }
}