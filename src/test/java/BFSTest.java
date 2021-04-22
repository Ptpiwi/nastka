import org.junit.Assert;
import org.junit.Test;
import pl.mowk.nastka.BFS;
import pl.mowk.nastka.Direction;
import pl.mowk.nastka.State;

public class BFSTest {

    @Test
    public void copyConstructor() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        int[][] table2 = {{1, 2, 3, 4}, {5, 6, 0, 7}, {9, 10, 11, 8}, {13, 14, 15, 12}};
        State state = new State(table);
        State copy = new State(table2);
        BFS bfs = new BFS();
        System.out.println(bfs.findPath(state, copy));

    }
}
