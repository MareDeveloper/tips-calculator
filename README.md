# Tips calculator
Android application for percentage calculation of tips for waiters after bill collection.

MAIN ACTIVITY java class

Assign Android widgets:

    private EditText enteredMount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView precentagesView;
    private int seekBarPercentage;
    private float enterdBillFloat;
    private TextView totalBillTv;
    
Creating String precentage that will be userd later in the code.

    String precentage;

Get ID's of elements from XML file

    enteredMount = findViewById(R.id.text);
    seekBar = findViewById(R.id.procentageSlider);
    calculateButton = findViewById(R.id.calculateButton);
    totalResultTextView = findViewById(R.id.text2);
    precentagesView = findViewById(R.id.procent_view);
    precentage = "%";
    totalBillTv = findViewById(R.id.totalBillTv);
    
Set click listener for action button:

    calculateButton.setOnClickListener(this);
    
Method used for following slider activities and watchig progress(), if slider is changes getProgress() of slider.

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
        
calculate() method takes the total amount of the bill and divided with a given precentage

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

on calculate button clicked get precentage of total sum.

    @Override
    public void onClick(View v) 
    {
      calculate();
    }
