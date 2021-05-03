package pl.mowk.nastka;

import java.util.*;

public class Astar {
    List<State> openset = new ArrayList<>();
    List<State> closedset = new ArrayList<>();
    Map<State, Double> gScore = new HashMap<>();
    Map<State, Double> fScore = new HashMap<>();
    Map<State, State> parents = new HashMap<>();

    /*
    function reconstruct_path(cameFrom, current)
    total_path := {current}
    while current in cameFrom.Keys:
    current := cameFrom[current]
            total_path.prepend(current)
            return total_path

    // A* finds a path from start to goal.
// h is the heuristic function. h(n) estimates the cost to reach goal from node n.
   */

    public Vector<Direction> findPath(State start, State finalState){
        return null;
    }

    public State solve(State start, State finalState, Heuristic h){
        openset.add(start);
        gScore.put(start, 0.0);
        fScore.put(start, gScore.get(start) + h.calculateDistance(start, finalState));
        while(!openset.isEmpty()){
            State current = findClosestState(h, finalState);
            if (current.isEqual(finalState)) return current;
            openset.remove(current);
            for (State neighbor:
                 current.getNeighbours()) {
                double tenativeGScore = gScore.get(current)+1;
                if (tenativeGScore<gScore.getOrDefault(neighbor, Double.MAX_VALUE)){
                    parents.put(neighbor, current);
                    gScore.put(neighbor, tenativeGScore);
                    fScore.put(neighbor, tenativeGScore + h.calculateDistance(neighbor, finalState));
                    if (!openset.contains(neighbor)) openset.add(neighbor);
                }
            }
        }
        return null;
    }

    private State findClosestState(Heuristic h, State finalState){
        double min = Double.MAX_VALUE;
        State firsborn = null;
        for (State state:
             openset) {
            double tmp = fScore.getOrDefault(state, Double.MAX_VALUE);
            if (tmp<min) {
                min = tmp;
                firsborn = state;
            }
        }
        return firsborn;
    }





    /*
    public State solve(State start, State finalState, Heuristic h){
        State tmp = start;
        if (start.isEqual(finalState)) return start;
        while (!tmp.isEqual(finalState)) {
            visited.add(tmp);
            tmp = findCloseNeighbour(finalState, start.getNeighbours(), h);
        }
        if (tmp.isEqual(finalState)) return tmp;
        return null;
    }
*/


   /*
    function A_Star(start, goal, h)
    // The set of discovered nodes that may need to be (re-)expanded.
    // Initially, only the start node is known.
    // This is usually implemented as a min-heap or priority queue rather than a hash-set.
    openSet := {start}

    // For node n, cameFrom[n] is the node immediately preceding it on the cheapest path from start
    // to n currently known.
    cameFrom := an empty map

    // For node n, gScore[n] is the cost of the cheapest path from start to n currently known.
    gScore := map with default value of Infinity
    gScore[start] := 0

    // For node n, fScore[n] := gScore[n] + h(n). fScore[n] represents our current best guess as to
    // how short a path from start to finish can be if it goes through n.
    fScore := map with default value of Infinity
    fScore[start] := h(start)

    while openSet is not empty
    // This operation can occur in O(1) time if openSet is a min-heap or a priority queue
    current := the node in openSet having the lowest fScore[] value
        if current = goal
            return reconstruct_path(cameFrom, current)

        openSet.Remove(current)
            for each neighbor of current
    // d(current,neighbor) is the weight of the edge from current to neighbor
    // tentative_gScore is the distance from start to the neighbor through current
    tentative_gScore := gScore[current] + d(current, neighbor)
            if tentative_gScore < gScore[neighbor]
    // This path to neighbor is better than any previous one. Record it!
    cameFrom[neighbor] := current
    gScore[neighbor] := tentative_gScore
    fScore[neighbor] := gScore[neighbor] + h(neighbor)
                if neighbor not in openSet
                    openSet.add(neighbor)

            // Open set is empty but goal was never reached
            return failure
    */
}
