package pl.mowk.nastka;

import java.util.*;

public class DFS {
    Map<State, Boolean> visited = new HashMap<>();
    Map<State, State> parents = new HashMap<>();

    public void findPath(State state){
        solve(state);
    }
    public void solve(State state) {
        List<State> neighbours = state.getNeighbours();
        visited.put(state, true);
        for (State neighbour : neighbours) {
            if (!visited.get(neighbour)) {
                solve(neighbour);
                //parents.put(neighbour, state);
            }
        }
    }

}
