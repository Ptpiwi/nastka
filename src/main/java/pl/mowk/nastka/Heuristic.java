package pl.mowk.nastka;

public interface Heuristic {

    //Retursn distance between two statese
    public double calculateDistance(State s1, State s2);
    public double calculateDistancePoints(Coordinates c1, Coordinates c2);
}
