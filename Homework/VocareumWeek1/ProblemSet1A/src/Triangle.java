class Triangle extends GeometricObject {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-this.side1)*(p-this.side2)*(p-this.side3));
    }

    public double getPerimeter() {
        return this.side1+this.side2+this.side3;
    }

    public String toString() {
        return "Triangle: side1 = "+this.side1+" side2 = "+this.side2+" side3 = "+this.side3;
    }
}
