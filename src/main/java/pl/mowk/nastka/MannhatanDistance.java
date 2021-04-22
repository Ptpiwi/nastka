package pl.mowk.nastka;

import static java.lang.Math.abs;

public class MannhatanDistance implements Heuristic {

    public double calculateDistance(State s1, State s2) {
        double distance = 0;
        for (int i = 0; i < s1.getHeight(); i++) {
            for (int j = 0; j < s1.getWidth(); j++) {
                distance = distance + (calculateDistancePoints(
                        new Coordinates(i, j), s2.getCorByValue(s1.getFieldValue(i, j)
                        )));
            }
        }
        return distance;
    }

    public double calculateDistancePoints(Coordinates c1, Coordinates c2) {
        return abs(c1.getX() - c2.getX()) + abs(c1.getY() - c2.getY());
    }
}
