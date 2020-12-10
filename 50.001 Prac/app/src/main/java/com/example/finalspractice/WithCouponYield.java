package com.example.finalspractice;

import android.util.Log;

public class WithCouponYield implements YieldCalculation {

    double rUp = 1.0;
    double rDown = Math.pow(10,-10);
    double rMiddle;
    double delta = rUp - rDown;
    String TAG = "WithCouponYield";

    @Override
    public double yieldToMaturity(double sellingPrice, double faceValue, double interestPayment, double duration) {
//        Log.d(TAG, "preDelta: " + delta);
        while (delta > Math.pow(10,-5)) {
//            Log.d(TAG, "delta: " + delta);
            rMiddle= (1.0/2.0)*(rUp + rDown);
//            Log.d(TAG, "rMiddleStart: " + rMiddle);
            double rMiddle1 = iterativeMethod(rMiddle, sellingPrice, faceValue, interestPayment, duration);
//            Log.d(TAG, "rMiddle1: " + rMiddle1);
            double rUp1 = iterativeMethod(rUp, sellingPrice, faceValue, interestPayment, duration);
//            Log.d(TAG, "rUp1: " + rUp1);
            double rDown1 = iterativeMethod(rDown, sellingPrice, faceValue, interestPayment, duration);
//            Log.d(TAG, "rDown1: " + rDown1);
            if (rMiddle1*rUp1 > 0) {
                rUp = rMiddle;
//                Log.d(TAG, "rUp " + rUp);
            }
            if (rMiddle1*rDown1 > 0) {
                rDown = rMiddle;
//                Log.d(TAG, "rDown " + rDown);
            }
            delta = rUp - rDown;
        }
//        Log.d(TAG, "delta: " + delta);

        return (1.0/2.0)*(rUp + rDown);
    }

    private double iterativeMethod(double number, double sellingPrice, double faceValue, double interestPayment, double duration) {
        return sellingPrice - interestPayment*((1 - Math.pow((1/(1 + number)), duration)) / number) - (faceValue / Math.pow((1 + number), duration));
    }
}
