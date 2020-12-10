package com.example.finalspractice;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void withCouponYield_isCorrect() {
        Bond.BondBuilder bondBuilder = new Bond.BondBuilder();
        Bond bond = bondBuilder.createBond(900, 1000, 10, 4);
        bond.setYieldCalculation(new WithCouponYield());
        assertEquals(0.0374, bond.calculateYTM(),0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentException_isCorrect() {
        Bond.BondBuilder bondBuilder = new Bond.BondBuilder();
        assertEquals(bondBuilder.createBond(), bondBuilder.createBond(1, 1, -1, 1));
    }
}