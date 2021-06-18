package pl.mowk.nastka;

import java.util.*;

public class DFS {
    Map<State, State> parents = new HashMap<>();
    List<Direction> permutationtable;
    int limit = 20;
    int vistedStates = 0;
    int processedStates = 0;
    int maxDepht = 0;


    public Report findPath(State state, State finalState, String permutationTable) {
        Report report = new Report();
        FileOptions file = new FileOptions();
        permutationtable = file.changeOrder(permutationTable);
        Vector<Direction> directions = new Vector<>();
        long timeStart = System.nanoTime();
        State tmp = solve(state, finalState);
        long timeStop = System.nanoTime();
        if (tmp != null) {
            while (!tmp.equals(state)) {
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
        report.setTime((timeStop - timeStart));
        return report;
    }

    public State solve(State start, State finalState){
        return DLS(start, finalState, limit);
    }

    private State DLS(State current, State finalState, int depth) {
        if (maxDepht < limit - depth) maxDepht = limit - depth;
        vistedStates++;
        if (current.equals(finalState)) {
            return current;
        }
        if (depth > 0) {
            processedStates++;
            for (State child : current.getNeighbours(this.permutationtable)) {

                    State found = DLS(child, finalState, depth - 1);
                    if (found != null) {
                        parents.put(child, current);
                        return found;
                    }

            }
        }
        return null;
    }



}
