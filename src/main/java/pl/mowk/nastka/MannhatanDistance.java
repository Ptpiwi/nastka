package pl.mowk.nastka;

import static java.lang.Math.abs;

public class MannhatanDistance implements Heuristic {

    public double calculateDistance(State s1, State s2) {
        double distance = 0;
        for (byte i = 0; i < s1.getHeight(); i++) {
            for (byte j = 0; j < s1.getWidth(); j++) {
                int s1value = s1.getFieldValue(i, j);
                if (s1value != 0)
                {
                Coordinates c1 = new Coordinates(i, j);
                Coordinates c2 = s2.getCorByValue(s1value);
                distance = distance + abs(c1.getX() - c2.getX()) + abs(c1.getY() - c2.getY());
                }
            }
        }
        return distance;
    }
}
