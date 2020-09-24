package com.cheung.lib2018midterm;

// starting code

/*
public class Circle {

}

 */

public class Circle {
    private double x,y;
    private double radius;

    public Circle() {
        x=y=0;
        radius=1;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2* radius * Math.PI;
    }

    public boolean contains(double x, double y) {

        double dist2 = Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2);
        return dist2 <= Math.pow(this.radius, 2);

    }

    public boolean contains(Circle c) {
        double dist2 = (this.x - c.x ) * (this.x - c.x) + (this.y - c.y) *(this.y - c.y);
        double dist = Math.pow(dist2, 0.5);


        if (this.radius < c.radius)
            return false;
        else
            return dist <= (this.radius - c.radius);



    }

    public boolean overlaps(Circle c) {
        double dist2 = (this.x - c.x ) * (this.x - c.x) + (this.y - c.y) *(this.y - c.y);
        double dist = Math.pow(dist2, 0.5);

        return dist <= c.radius + this.radius;


    }

}
