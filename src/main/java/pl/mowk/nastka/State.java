package pl.mowk.nastka;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

@Getter
@Setter
@ToString
public class State {
    int[][] table;
    int width, height;


    public State(int[][] table) {
        this.height = table.length;
        this.width = table[0].length;
        this.table = new int[height][width];
        deepcopyTable(table);
    }

    public State(State state) {
        this.width = state.getWidth();
        this.height = state.getHeight();
        this.table = new int[height][width];
        deepcopyTable(state.getTable());
    }

    private void deepcopyTable(int[][] newTable) {
        for (int i = 0; i < height; i++) {
            if (width >= 0) System.arraycopy(newTable[i], 0, this.table[i], 0, width);
        }
    }

    public boolean isEqual(State state){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (table[i][j] != state.getTable()[i][j]) return false;
            }
        }
        return true;
    }


    public Vector<Direction> getAvailableMoves() {
        return getAvailableMovesFor(getBlank());
    }

    public Coordinates getBlank() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (table[i][j] == 0) {
                    return new Coordinates(i, j);
                }
            }
        }
        System.out.println("To nie powinno się wyświetlić w tablicy nie ma zera");
        return new Coordinates();
    }

    public Vector<Direction> getAvailableMovesFor(Coordinates coordinates) {
        Vector<Direction> directions = new Vector<>();
        if (0 < coordinates.getX() && coordinates.getX() <= height - 1) directions.add(Direction.U);
        if (0 <= coordinates.getX() && coordinates.getX() < height - 1) directions.add(Direction.D);
        if (0 <= coordinates.getY() && coordinates.getY() < width - 1) directions.add(Direction.R);
        if (0 < coordinates.getY() && coordinates.getY() <= width - 1) directions.add(Direction.L);
        return directions;
    }

    private void setField(int x, int y, int value) {
        table[x][y] = value;
    }

    public List<State> getNeighbours() {
        List<State> neighbours = new ArrayList<>();
        for (Direction d :
                getAvailableMoves()) {
            neighbours.add(move(d));
        }
        return neighbours;
    }


    public State move(Direction direction) {
        State nextState = new State(this);
        switch (direction) {
            case L:
                if (isPosibleToMove(direction)) {
                    Coordinates c = getBlank();
                    nextState.setField(c.getX(), c.getY(), table[c.getX()][c.getY() - 1]);
                    nextState.setField(c.getX(), c.getY() - 1, 0);
                    break;
                }
                break;
            case R:
                if (isPosibleToMove(direction)) {

                    Coordinates c = getBlank();
                    nextState.setField(c.getX(), c.getY(), table[c.getX()][c.getY() + 1]);
                    nextState.setField(c.getX(), c.getY() + 1, 0);
                    break;
                }
                break;
            case U:
                if (isPosibleToMove(direction)) {
                    Coordinates c = getBlank();
                    nextState.setField(c.getX(), c.getY(), table[c.getX() - 1][c.getY()]);
                    nextState.setField(c.getX() - 1, c.getY(), 0);
                    break;
                }
                break;
            case D:
                if (isPosibleToMove(direction)) {
                    Coordinates c = getBlank();
                    nextState.setField(c.getX(), c.getY(), table[c.getX() + 1][c.getY()]);
                    nextState.setField(c.getX() + 1, c.getY(), 0);
                    break;
                }
                break;
            default:
                // code block
        }
        return nextState;
    }

    private boolean isPosibleToMove(Direction d) {
        return getAvailableMovesFor(getBlank()).contains(d);
    }

    public Direction getMoveBetween(State state){
        return Direction.D;
    }


}
