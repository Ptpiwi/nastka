package pl.mowk.nastka;

import java.util.*;

public class BFS {
    Queue<State> queue = new LinkedList<>();
    List<State> visited = new ArrayList<>();
    Map<State, State> parents = new HashMap<>();
    int counter = 0;
    public BFS(){

    }


    public void findPath(State state, State finalState){
        State key = solve(state, finalState);
        if (key != null){

        }
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
private String reconstructPath(State start, State finalState){
        String path = "";
        State cur = finalState;
        while (cur != start){

            path= path;
        }

        return path;
}

}
