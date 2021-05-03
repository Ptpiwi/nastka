package pl.mowk.nastka;

import java.util.*;

public class BFS {
    Queue<State> queue = new LinkedList<>();
    List<State> visited = new ArrayList<>();
    Map<State, State> parents = new HashMap<>();


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


    public State solve(State state, State finalState) {
        queue.add(state);
        visited.add(state);
        while (!queue.isEmpty()) {
            State current = queue.remove();
            List<State> neighbours = current.getNeighbours();
            for (State neighbour :
                    neighbours) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                    parents.put(neighbour, current);
                    if (neighbour.equals(finalState)) return neighbour;
                }
            }
        }
        return null;
    }


}
