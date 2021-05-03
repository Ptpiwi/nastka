import org.junit.Assert;
import org.junit.Test;
import pl.mowk.nastka.*;

public class BFSTest {

    @Test
    public void copyConstructor() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 0, 7}, {9, 10, 11, 8}, {13, 14, 15, 12}};
        int[][] table2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        // int[][] table2 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        // int[][] table = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        State state = new State(table);
        State finalState = new State(table2);
        Astar bfs = new Astar();
        Heuristic h = new MannhatanDistance();
        System.out.println(bfs.solve(state, finalState, h));

    }
}
