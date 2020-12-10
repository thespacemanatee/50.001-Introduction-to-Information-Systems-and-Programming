
// starting code

public class Circle {
    private double x;
    private double y;
    private double radius;

    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
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
        return Math.PI*Math.pow(radius,2);
    }

    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    public boolean contains(double px, double py) {
        return px <= this.x + radius && px >= this.x - radius
                && py <= this.y + radius && py >= this.y - radius;
    }

    public boolean contains(Circle c) {
        return c.getX() + c.getRadius() <= this.x + radius && c.getX() - c.getRadius() >= this.x - radius
                && c.getY() + c.getRadius() <= this.y + radius && c.getY() - c.getRadius() >= this.y - radius;
    }

    public boolean overlaps(Circle c) {
        return Math.sqrt(Math.pow(this.y-c.getY(),2) + Math.pow(this.x-c.getX(),2)) < this.radius + c.getRadius();
    }
}
