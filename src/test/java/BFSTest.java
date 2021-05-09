import org.junit.Assert;
import org.junit.Test;
import pl.mowk.nastka.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BFSTest {

    @Test
    public void copyConstructor() {
        List<Report> reportList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            byte[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 0}, {13, 14, 15, 12}};
            byte[][] table2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
            // int[][] table2 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
            // int[][] table = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
            State state = new State(table);
            State finalState = new State(table2);
            DFS dfs = new DFS();
            Heuristic h = new MannhatanDistance();
            String d = "LUDR";
            reportList.add(dfs.findPath(state, finalState, d));
        }
        double time = 0;
        for (Report r :
                reportList) {
        time = time + r.getTime();
        }
        System.out.println("Czas = " + time);
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
