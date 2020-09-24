public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;
    public double getX() {
        return x;
    }
    public void setX(double newX) {
        x = newX;
    }
    public double getY() {
        return y;
    }
    public void setY(double newY) {
        y = newY;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double newWidth) {
        width = newWidth;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double newHeight) {
        height = newHeight;
    }
    public MyRectangle2D() {
        setX(0);
        setY(0);
        setWidth(1);
        setHeight(1);
    }
    public MyRectangle2D(double x, double y, double width, double height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }
    public double getArea() {
        return getWidth()*getHeight();
    }
    public double getPerimeter() {
        return 2*getWidth()+2*getHeight();
    }
    public boolean contains(double x, double y) {
        return x >= getX()-0.5*getWidth() & y >= getY()-0.5*getHeight() &
                x <= getX()+0.5*getWidth() & y <= getY()+0.5*getHeight();
    }
    public boolean contains(MyRectangle2D r) {
        return r.getX()-0.5*r.getWidth() >= getX()-0.5*getWidth() &
                r.getY()-0.5*r.getHeight() >= getY()-0.5*getHeight() &
                r.getX()+0.5*r.getWidth() <= getX()+0.5*getWidth() &
                r.getY()+0.5*r.getHeight() <= getY()+0.5*getHeight();
    }
    public boolean overlaps(MyRectangle2D r) {
        return (r.getX()-0.5*r.getWidth() <= getX()+0.5*getWidth() &
                r.getY()+0.5*r.getHeight() >= getY()-0.5*getHeight()) &
                (r.getY()-0.5*r.getHeight() <= getY()+0.5*getHeight() &
                        r.getX()+0.5*r.getWidth() >= getX()-0.5*getWidth()) &
                (r.getX()+0.5*r.getWidth() >= getX()-0.5*getWidth() &
                        r.getY()-0.5*r.getHeight() <= getY()+0.5*getHeight()) &
                (r.getY()+0.5*r.getHeight() >= getY()-0.5*getHeight() &
                        r.getX()-0.5*r.getWidth() <= getX()+0.5*getWidth());
    }
}
