public class Octagon implements Comparable<Octagon> {
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }

    @Override
    public int compareTo(Octagon o) {
        if (side > o.side) {
            return 1;
        } else if (side < o.side) {
            return -1;
        }
        return 0;
    }
}

