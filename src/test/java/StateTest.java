import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.mowk.nastka.Direction;
import pl.mowk.nastka.State;

import java.util.Arrays;

public class StateTest {

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void euclideanDistance() {
        int[][] table = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        State state = new State(table);
        System.out.println(state.toString());
        System.out.println(state.isDone());
        state.move(Direction.U);
        state.move(Direction.L);
        state.move(Direction.D);
        System.out.println(state);
    }
}
