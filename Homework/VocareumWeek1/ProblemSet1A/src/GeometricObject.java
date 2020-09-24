import java.util.Date;

class GeometricObject
{
    public String color;
    public boolean filled;
    public Date dateCreated;

    public GeometricObject() {
        this.color = "white";
        this.filled = false;
        this.dateCreated = new Date();
    }

    public GeometricObject(final String color, final boolean filled) {
        this.color = "white";
        this.filled = false;
        this.dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(final boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    @Override
    public String toString() {
        return "color: " + this.color + "\\nfilled: " + this.filled;
    }
}
