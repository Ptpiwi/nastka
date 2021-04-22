package pl.mowk.nastka;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Coordinates {
    int x, y;
    public Coordinates(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Coordinates(){}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
