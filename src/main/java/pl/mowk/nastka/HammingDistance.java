package pl.mowk.nastka;

import static java.lang.Math.sqrt;

public class HammingDistance implements Heuristic{

    @Override
    public double calculateDistance(State s1, State s2) {
        double distance = 0;
        for (byte i = 0; i < s1.getHeight(); i++) {
            for (byte j = 0; j < s1.getWidth(); j++) {
                int s1value = s1.getFieldValue(i, j);
                if (s1value != 0)
                {
                    if (s1value != s2.getFieldValue(i, j)) distance++;
                }
            }
        }
        return distance;
    }


}
