package pl.mowk.nastka;

import java.util.*;

public class BFS {
    Queue<State> queue = new LinkedList<>();
    List<State> visited = new ArrayList<>();
    Map<State, State> parents = new HashMap<>();
    int vistedStates = 0;
    int processedStates = 0;



    public Report findPath(State state, State finalState, String permutationTable) {
        Report report = new Report();
        Vector<Direction> directions = new Vector<>();
        long timeStart = System.nanoTime();
        State tmp = solve(state, finalState, permutationTable);
        long timeStop = System.nanoTime();
        if (tmp != null) {
            while (!tmp.equals(state)) {
                directions.add(
                        parents.get(tmp).directionToState(tmp));
                tmp = parents.get(tmp);
            }
            Collections.reverse(directions);
            report.setPath(directions);
            report.setMaxDepht(directions.size());
        }
        report.setProcessedStates(processedStates);
        report.setVistedStates(vistedStates);
        report.setTime(timeStop - timeStart);
        return report;
    }


    public State solve(State state, State finalState, String directions) {
        Vector<Direction> order;
        FileOptions file = new FileOptions();
        order = file.changeOrder(directions);
        queue.add(state);
        visited.add(state);
        while (!queue.isEmpty()) {
            State current = queue.remove();
            processedStates++;
            List<State> neighbours = current.getNeighbours(order);
            for (State neighbour :
                    neighbours) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                    parents.put(neighbour, current);
                    vistedStates++;
                    if (neighbour.equals(finalState)) return neighbour;
                }
            }
        }
        return null;
    }


}
