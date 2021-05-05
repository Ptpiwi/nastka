package pl.mowk.nastka;

import java.util.*;

public class Astar {
    List<State> openset = new ArrayList<>();
    Map<State, Double> gScore = new HashMap<>();
    Map<State, Double> fScore = new HashMap<>();
    Map<State, State> parents = new HashMap<>();
    int vistedStates = 0;
    int processedStates = 0;
    int maxDepht = 0;




    public Report findPath(State start, State finalState, Heuristic h){
        Vector<Direction> directions = new Vector<>();
        Report report = new Report();
        long timeStart = System.nanoTime();
        State tmp = solve(start, finalState, h);
        long timeStop = System.nanoTime();

        if (tmp != null) {
            while (!tmp.equals(start)) {
                directions.add(
                        parents.get(tmp).directionToState(tmp));
                tmp = parents.get(tmp);
            }
            Collections.reverse(directions);
            report.setPath(directions);
        }
        report.setProcessedStates(processedStates);
        report.setVistedStates(vistedStates);
        report.setMaxDepht(maxDepht);
        report.setTime(timeStop - timeStart);
        return report;
    }

    public State solve(State start, State finalState, Heuristic h){
        vistedStates++;
        openset.add(start);
        gScore.put(start, 0.0);
        fScore.put(start, gScore.get(start) + h.calculateDistance(start, finalState));
        while(!openset.isEmpty()){
            State current = findClosestState(h, finalState);
            openset.remove(current);
            processedStates++;
            for (State neighbor:
                 current.getNeighbours()) {
                double tentativeGScore = gScore.get(current)+1;
                if (tentativeGScore<gScore.getOrDefault(neighbor, Double.MAX_VALUE)){
                    parents.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, tentativeGScore + h.calculateDistance(neighbor, finalState));
                    vistedStates++;
                    if (neighbor.equals(finalState)) return neighbor;
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


}
