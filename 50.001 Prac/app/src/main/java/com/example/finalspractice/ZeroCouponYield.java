package com.example.finalspractice;

public class ZeroCouponYield implements YieldCalculation {

    @Override
    public double yieldToMaturity(double sellingPrice, double faceValue, double interestPayment, double duration) {
        return Math.pow((faceValue/sellingPrice), 1/duration) - 1;
    }
}
