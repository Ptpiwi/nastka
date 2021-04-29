import org.junit.Assert;
import org.junit.Test;
import pl.mowk.nastka.BFS;
import pl.mowk.nastka.DFS;
import pl.mowk.nastka.Direction;
import pl.mowk.nastka.State;

public class BFSTest {

    @Test
    public void copyConstructor() {
      //  int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
      //  int[][] table2 = {{1, 2, 3, 4}, {5, 6, 0, 7}, {9, 10, 11, 8}, {13, 14, 15, 12}};
        int[][] table = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int[][] table2 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        State state = new State(table);
        State copy = new State(table2);
        DFS bfs = new DFS();
        System.out.println(bfs.findPath(copy, state));

    }
}
