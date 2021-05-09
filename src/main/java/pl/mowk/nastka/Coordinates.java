package pl.mowk.nastka;

public class Coordinates {
    byte x, y;
    public Coordinates(byte x, byte y){
        this.x=x;
        this.y=y;
    }
    public Coordinates(){}

    public byte getX() {
        return x;
    }

    public byte getY() {
        return y;
    }

    public void setX(byte x) { this.x = x; }
    public void setY(byte y) { this.y = y; }
}
