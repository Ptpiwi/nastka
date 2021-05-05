import org.junit.Assert;
import org.junit.Test;
import pl.mowk.nastka.*;

import java.util.Vector;

public class BFSTest {

    @Test
    public void copyConstructor() {
        int[][] table = {{1, 2, 6, 3}, {4, 5, 0, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        int[][] table2 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        // int[][] table2 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        // int[][] table = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        State state = new State(table);
        State finalState = new State(table2);
        Astar dfs = new Astar();
        Heuristic h = new MannhatanDistance();
        Vector<Direction> d = new Vector<>();

        d.add(Direction.R);
        d.add(Direction.L);
        d.add(Direction.D);
        d.add(Direction.U);

        Report r = dfs.findPath(state, finalState, h);
        System.out.println(r.generateReport());
    }


    @Test
    public void copr() {
        Report report = new Report();
        Vector<Direction> d = new Vector<>();
        d.add(Direction.D);
        d.add(Direction.L);
        report.setPath(d);
        report.setProcessedStates(123);
        report.setVistedStates(11);
        report.setMaxDepht(23);
        System.out.println(report.toString());

    }
}
