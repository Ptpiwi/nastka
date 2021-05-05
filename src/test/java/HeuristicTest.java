import org.junit.Assert;
import org.junit.Test;
import pl.mowk.nastka.*;

public class HeuristicTest {

    @Test
    public void eucildeanDistanceTest() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        int[][] table2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 0}, {13, 14, 15, 12}};
        State state = new State(table);
        State copy = new State(table2);
        Heuristic heuristic = new EuclideanDistance();
        Assert.assertEquals(1, heuristic.calculateDistance(state, copy), 0.01);

    }
    @Test
    public void manhatanDistanceTest() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        int[][] table2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 0}, {13, 14, 15, 12}};
        State state = new State(table);
        State copy = new State(table2);
        Heuristic heuristic = new MannhatanDistance();
        Assert.assertEquals(1, heuristic.calculateDistance(state, copy), 0.01);

    }
    @Test
    public void hammingDistanceTest() {
        int[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        int[][] table2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 0}, {13, 14, 15, 12}};
        State state = new State(table);
        State copy = new State(table2);
        Heuristic heuristic = new MannhatanDistance();
        Assert.assertEquals(1, heuristic.calculateDistance(state, copy), 0.01);

    }
}