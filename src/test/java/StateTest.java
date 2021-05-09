import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.mowk.nastka.Coordinates;
import pl.mowk.nastka.Direction;
import pl.mowk.nastka.State;

import java.util.Arrays;
import java.util.Vector;

public class StateTest {

    @Before
    public void setUp() throws Exception {

    }



    @Test
    public void copyConstructor() {
        byte[][] table = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        State state = new State(table);
        State copy = new State(state);
        Assert.assertTrue(state.equals( copy));
    }

    @Test
    public void availableMoves() {
        byte[][] table = {{1, 2}, {3, 4}, {5, 0}};
        State state = new State(table);
        System.out.println(state.getAvailableMoves());
        byte[][] table2 = {{0}, {1}, {2}};
        State state2 = new State(table2);
        System.out.println(state2.getAvailableMoves());
    }
}
