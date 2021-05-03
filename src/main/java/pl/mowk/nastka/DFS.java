package pl.mowk.nastka;

import java.util.*;

public class DFS {
    List<State> visited = new ArrayList<>();
    int limit = 5;

    public State DLS(State current, State finalState, int depth) {
        if (depth == 0 && current.isEqual(finalState)) {
            return current;
        }
        visited.add(current);
        if (depth > 0) {
            for (State child : current.getNeighbours()) {
                if (!visited.contains(child)) {
                    State found = DLS(child, finalState, depth - 1);
                    if (found != null) {
                        return found;
                    }
                }
            }
        }
        return null;
    }



}
