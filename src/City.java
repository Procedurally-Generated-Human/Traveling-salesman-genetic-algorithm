import java.awt.geom.Point2D;
import java.util.concurrent.atomic.AtomicInteger;

public class City {

    static AtomicInteger nextId = new AtomicInteger();
    private int x;
    private int y;
    private int id;

    public City(int x, int y){
        setX(x);
        setY(y);
        setId(generateId());
    }

    private int generateId(){
        return nextId.incrementAndGet();
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
    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getId() {
        return id;
    }

    public String toString(){
        return ""+this.id+"|";
    }
}
