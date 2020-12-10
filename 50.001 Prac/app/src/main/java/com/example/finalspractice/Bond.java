package com.example.finalspractice;

import androidx.annotation.NonNull;

public class Bond {
    private double sellingPrice;
    private double faceValue;
    private double interestPayment;
    private double duration;
    private YieldCalculation yieldCalculation;
    private Bond(double sellingPrice, double faceValue, double interestPayment,
                 double duration) throws IllegalArgumentException {

        if (sellingPrice <= 0 || faceValue <= 0 || interestPayment < 0 || duration <= 0) {
            throw new IllegalArgumentException();
        }
        this.sellingPrice = sellingPrice;
        this.faceValue = faceValue;
        this.interestPayment = interestPayment;
        this.duration = duration;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }

    public double getInterestPayment() {
        return interestPayment;
    }

    public void setInterestPayment(double interestPayment) {
        this.interestPayment = interestPayment;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setYieldCalculation(YieldCalculation yieldCalculation) {
        this.yieldCalculation = yieldCalculation;
    }

    double calculateYTM() {
        return yieldCalculation.yieldToMaturity(sellingPrice, faceValue, interestPayment, duration);
    }

    @NonNull
    @Override
    public String toString() {
        return faceValue + " " + sellingPrice + " " + interestPayment + " " + duration;
    }

    static class BondBuilder {
        Bond createBond() throws IllegalArgumentException {
            return new Bond(1000, 1000, 10, 1);
        }
        Bond createBond(double sellingPrice, double faceValue, double interestPayment,
                        double duration) throws IllegalArgumentException {
            return new Bond(sellingPrice, faceValue, interestPayment, duration);
        }
    }
}
