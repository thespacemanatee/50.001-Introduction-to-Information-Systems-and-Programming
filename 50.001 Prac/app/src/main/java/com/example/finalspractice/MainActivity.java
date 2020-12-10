package com.example.finalspractice;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText faceValue, sellingPrice, annualInterestPayment, bondDuration;
    Button calculate;
    TextView result;
    String SHARED_PREFS = "mainPrefs";
    String FACE_VALUE = "faceValue";
    String SELLING_PRICE = "sellingPrice";
    String INTEREST = "interest";
    String DURATION = "duration";
    SharedPreferences mPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        faceValue = findViewById(R.id.faceValue);
        sellingPrice = findViewById(R.id.sellingPrice);
        annualInterestPayment = findViewById(R.id.annualInterestPayment);
        bondDuration = findViewById(R.id.bondDuration);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);

        faceValue.setText(mPrefs.getString(FACE_VALUE, ""));
        sellingPrice.setText(mPrefs.getString(SELLING_PRICE, ""));
        annualInterestPayment.setText(mPrefs.getString(INTEREST, ""));
        bondDuration.setText(mPrefs.getString(DURATION, ""));

        calculate.setOnClickListener(new View.OnClickListener() {
            private static final String TAG = "MainActivity";

            @Override
            public void onClick(View v) {
                double faceValueChosen;
                double sellingPriceChosen;
                double interestChosen;
                double durationChosen;

                Bond.BondBuilder bondBuilder = new Bond.BondBuilder();

                try {
                    faceValueChosen = Double.parseDouble(faceValue.getText().toString());
                    sellingPriceChosen = Double.parseDouble(sellingPrice.getText().toString());
                    interestChosen = Double.parseDouble(annualInterestPayment.getText().toString());
                    durationChosen = Double.parseDouble(bondDuration.getText().toString());
                    Bond bond = bondBuilder.createBond(sellingPriceChosen, faceValueChosen, interestChosen, durationChosen);
                    bond.setYieldCalculation(new WithCouponYield());
                    Log.d(TAG, "onClick: " + bond.toString());

                    Calculate calculate = new Calculate();
                    calculate.execute(bond);
                } catch (NumberFormatException a) {
                    Toast.makeText(getApplicationContext(), "Cannot leave empty", Toast.LENGTH_SHORT).show();
                } catch (IllegalArgumentException b) {
                    Toast.makeText(getApplicationContext(), "Illegal numbers detected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class Calculate extends AsyncTask<Bond, String, Double> {

        String TAG = "Calculate";

        @Override
        protected Double doInBackground(Bond... bonds) {
            publishProgress("Calculating...");
            return bonds[0].calculateYTM();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            result.setText(values[0]);
        }

        @Override
        protected void onPostExecute(Double aDouble) {
            super.onPostExecute(aDouble);
            Log.d(TAG, "onPostExecute: " + aDouble);
            String finalResult = String.valueOf(aDouble * 100);
            result.setText(finalResult.substring(0, 4) + "%");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(FACE_VALUE, faceValue.getText().toString());
        editor.putString(SELLING_PRICE, sellingPrice.getText().toString());
        editor.putString(INTEREST, annualInterestPayment.getText().toString());
        editor.putString(DURATION, bondDuration.getText().toString());
        editor.apply();
    }
}
