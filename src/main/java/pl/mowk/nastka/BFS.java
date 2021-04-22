package pl.mowk.nastka;

import java.util.*;

public class BFS {
    Queue<State> queue = new LinkedList<>();
    List<State> visited = new ArrayList<>();
    Map<State, State> parents = new HashMap<>();
    int counter = 0;
    public BFS(){

    }



    public Vector<Direction> findPath(State state, State finalState){
        State key = solve(state, finalState);
        Vector<Direction> directions = new Vector<>();
        if (key != null){
            while (!state.equals(key)){
                State tmp = parents.get(key);
                directions.add(
                        key.roadToFather(tmp));
                key = tmp;
            }
        }
        return directions;
    }
    public State solve(State state, State finalState){
        queue.add(state);
        visited.add(state);
        while (!queue.isEmpty()){
            State current = queue.remove();
            List<State> neighbours = current.getNeighbours();
            for (State neighbour:
                 neighbours) {
                if (!visited.contains(neighbour)){
                    queue.add(neighbour);
                    visited.add(neighbour);
                    parents.put(neighbour, current);
                    counter ++;
                    if (neighbour.isEqual(finalState)) return neighbour;
                }
            }
        }
        return null;
    }


}
