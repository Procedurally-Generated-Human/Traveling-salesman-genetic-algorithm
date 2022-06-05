import java.awt.geom.Point2D;

public class City {
    private int x;
    private int y;

    public City(int x, int y){
        setX(x);
        setY(y);
    }

    public double distanceTo(City b){
        return Point2D.distance(x, y, b.getX(), b.getY());
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
