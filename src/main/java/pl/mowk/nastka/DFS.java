package pl.mowk.nastka;

import java.util.*;

public class DFS implements GrafSearchAlgo{
    List<State> visited = new ArrayList<>();
    Map<State, State> parents = new HashMap<>();
    int limit = 40;


    public Vector<Direction> findPath(State state, State finalState) {
        Vector<Direction> directions = new Vector<>();
        State tmp = solve(state, finalState);
        if (tmp == null) return null;
        while (!tmp.equals(state)) {
            directions.add(
                    parents.get(tmp).directionToState(tmp));
            tmp = parents.get(tmp);
        }
        Collections.reverse(directions);
        return directions;
    }

    public State solve(State start, State finalState){
        return DLS(start, finalState, limit);
    }

    private State DLS(State current, State finalState, int depth) {
        if (depth == 0 || current.equals(finalState)) {
            return current;
        }
        visited.add(current);
        if (depth > 0) {
            for (State child : current.getNeighbours()) {
                if (!visited.contains(child)) {
                    parents.put(child, current);
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
