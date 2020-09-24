class MyClass1 {

    public static void main(String[] args) {
        int n=5;
        Circle myCircle = new Circle(20);

        updateObject(myCircle, n);

        System.out.println(n);
        System.out.println(myCircle.getRadius());

    }

    public static void updateObject(Circle c, int b) {
        b = 1000;

        c.setRadius(1234);

    }
}



