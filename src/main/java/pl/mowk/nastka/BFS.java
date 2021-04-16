package pl.mowk.nastka;

import java.util.*;

public class BFS {
    Queue<State> queue = new LinkedList<>();
    Map<State, Boolean> visited = new HashMap<>();
    Map<State, State> parents = new HashMap<>();
    public BFS(State startState){
        queue.add(startState);
    }

    public void findPath(State state, State finalState){
        solve(state, finalState);
    }
    public void solve(State state, State finalState){
        queue.add(state);
        visited.put(state, true);
        while (!queue.isEmpty()){
            State current = queue.remove();
            List<State> neighbours = current.getNeighbours();
            for (State neighbour:
                 neighbours) {
                if (!visited.get(neighbour)){
                    queue.add(neighbour);
                    visited.put(neighbour, true);
                    parents.put(neighbour, current);
                    //if (neighbour.isEqual(finalState)) return;
                }
            }
        }
        return;
    }
    private boolean visitNeighbors(State state){

        for (Direction d:
             state.getAvailableMoves()) {
            State tmp = state.move(d);
            //if (tmp.isDone()) ;

        }
           return false;
    }

}
