import org.junit.Assert;
import org.junit.Test;
import pl.mowk.nastka.*;

public class BFSTest {

    @Test
    public void copyConstructor() {
        int[][] table = {{0, 5, 2, 3}, {1, 4, 10, 7}, {8, 6, 9, 11}, {12, 13, 14, 15}};
        int[][] table2 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        // int[][] table2 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        // int[][] table = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        State state = new State(table);
        State finalState = new State(table2);
        Astar dfs = new Astar();
        Heuristic h = new MannhatanDistance();
        System.out.println(dfs.findPath(state, finalState, h));

    }
}
