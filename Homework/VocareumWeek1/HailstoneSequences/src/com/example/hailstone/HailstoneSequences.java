package com.example.hailstone;

import java.util.ArrayList;

public class HailstoneSequences {
    public static ArrayList<Integer> hailstone(int x) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(x);
        do {
            if (x%2==0) {
                x = x/2;
            } else {
                x = x*3 + 1;
            }
            a.add(x);

        } while (x != 1);
        return a;
    }
}
