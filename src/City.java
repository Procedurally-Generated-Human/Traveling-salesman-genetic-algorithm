import java.awt.geom.Point2D;
import java.util.Random;

public class City {
    private int x;
    private int y;
    private char id;

    public City(int x, int y){
        setX(x);
        setY(y);
        char c = generateId();
        setId(c);
    }

    private char generateId(){
        Random r = new Random();
        return (char)(r.nextInt(26) + 'a');
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
    public void setId(char id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public char getId() {
        return id;
    }

    public String toString(){
        return ""+this.id;
    }
}
