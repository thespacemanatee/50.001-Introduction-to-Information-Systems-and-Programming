package com.cheung.lib2018midterm;

public class TestCircle {
    public static void main(String[] args) {
        Circle c = new Circle();


        System.out.println(c.contains(1,0));

        System.out.println(c.contains( new Circle(0.5, 0, 0.3)));

        System.out.println(c.contains(new Circle(0,0,1)));

        System.out.println(c.contains(new Circle(0,0.5,0.6)));


        System.out.println(c.overlaps(new Circle(1.5,0,1)));
        System.out.println(c.overlaps(new Circle(0,2,0.5)));

        Circle c2 = new Circle(1,1,1);
        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());

        System.out.println(c2.contains(2,1.1));

        Circle c3 = new Circle(0,0,10);
        System.out.println(c3.getArea());

/*
true
true
true
false
true
false
3.141592653589793
6.283185307179586
false
314.1592653589793
 */
// be careful with numerical issue when comparison, maybe round this first?

    }
}
