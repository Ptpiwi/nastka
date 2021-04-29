package pl.mowk.nastka;

import java.util.*;

public class DFS {
    List<State> visited = new ArrayList<>();
    Map<State, State> parents = new HashMap<>();
    Stack<State> stack = new Stack<>();
    State finalState;
    int depth = 0, limit = 5;

    public Vector<Direction> findPath(State state, State finalState){
        this.finalState = finalState;
        State key = solve(state);
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

    public State solve(State state){
        stack.add(state);
        depth = 0;
        while(!stack.isEmpty()){
            State tmp = stack.pop();
            if (!visited.contains(tmp)) {
                visited.add(tmp);
                if (depth <= limit) {
                    List<State> neigbours = tmp.getNeighbours();
                    for (State s:
                         neigbours) {
                        parents.put(s, tmp);
                        if (!visited.contains(s)) stack.add(s);
                    }
                    depth++;
                }
                if (tmp.isEqual(finalState)) return tmp;
            }
        }

        return null;
    }


}
