import java.util.ArrayList;

public class Position {

    public Position(int _x, int _y){
        x = _x;
        y = _y;
    }

    public void setX(int _x) {
        x = _x;
    }

    public void setY(int _y){
        y = _y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;
}
