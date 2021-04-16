package pl.mowk.nastka;

import java.util.*;

public class Astar {
    public static State aStar(State start, Heuristic target){
        PriorityQueue<State> closedList = new PriorityQueue<>();
        PriorityQueue<State> openList = new PriorityQueue<>();
        start.f = start.g + start.calculateHeuristic(target);
        openList.add(start);
        while(!openList.isEmpty()){
            State n = openList.peek();
            for(State.Edge edge : n.neighbors){
                State m = edge.state;
                double totalWeight = n.g + edge.weight;

                if(!openList.contains(m) && !closedList.contains(m)){
                    m.parent = n;
                    m.g = totalWeight;
                    m.f = m.g + m.calculateHeuristic(target);
                    openList.add(m);
                } else {
                    if(totalWeight < m.g){
                        m.parent = n;
                        m.g = totalWeight;
                        m.f = m.g + m.calculateHeuristic(target);

                        if(closedList.contains(m)){
                            closedList.remove(m);
                            openList.add(m);
                        }
                    }
                }
            }
            openList.remove(n);
            closedList.add(n);
        }
        return null;
    }

    public static void printPath(State target){
        State n = target;
        if(n==null)
            return;
        List<Integer> ids = new ArrayList<>();
        while(n.parent != null){
            ids.add(n.id);
            n = n.parent;
        }
        ids.add(n.id);
        Collections.reverse(ids);

    }
}
