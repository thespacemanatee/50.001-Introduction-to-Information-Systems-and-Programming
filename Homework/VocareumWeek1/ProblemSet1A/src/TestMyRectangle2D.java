public class TestMyRectangle2D {
    public static void main(String[] args) {
        MyRectangle2D a = new MyRectangle2D(3,4,2,2);
        MyRectangle2D r = new MyRectangle2D(5,4,2,2);
        System.out.println(a.getArea());
        System.out.println(a.getPerimeter());
        System.out.println(a.getX());
        System.out.println(a.getY());
        System.out.println(a.getHeight());
        System.out.println(a.getWidth());
        System.out.println(a.contains(r));
        System.out.println(a.contains(4,5));
        System.out.println(a.overlaps(r));
    }
}