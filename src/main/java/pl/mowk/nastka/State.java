package pl.mowk.nastka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

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

    public Direction directionToState(State father){
        for (Direction d:
                getAvailableMoves()) {
            if (father.equals(move(d))) return d;
        }
        System.out.println("To nie powinno się pojawić błąd w drodze do syna xD");
        return null;
    }

    private void deepcopyTable(int[][] newTable) {
        for (int i = 0; i < height; i++) {
            if (width >= 0) System.arraycopy(newTable[i], 0, this.table[i], 0, width);
        }
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof State)) {
            return false;
        }
        State s = (State) o;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (table[i][j] != s.getTable()[i][j]) return false;
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

    public Coordinates getCorByValue(int value) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (table[i][j] == value) {
                    return new Coordinates(i, j);
                }
            }
        }
        System.out.println("To nie powinno się wyświetlić w tablicy nie ma zera");
        return new Coordinates();
    }

    public Vector<Direction> getAvailableMovesFor(Coordinates coordinates) {
        Vector<Direction> directions = new Vector<>();

        if (0 <= coordinates.getX() && coordinates.getX() < height - 1) directions.add(Direction.D);
        if (0 < coordinates.getX() && coordinates.getX() <= height - 1) directions.add(Direction.U);
        if (0 <= coordinates.getY() && coordinates.getY() < width - 1) directions.add(Direction.R);
        if (0 < coordinates.getY() && coordinates.getY() <= width - 1) directions.add(Direction.L);
        return directions;
    }

    private void setField(int x, int y, int value) {
        table[x][y] = value;
    }
    public int getFieldValue(int x, int y) {
        return  table[x][y];
    }

    public List<State> getNeighbours() {
        List<State> neighbours = new ArrayList<>();
        for (Direction d :
                getAvailableMoves()) {
            neighbours.add(move(d));
        }
        return neighbours;
    }

    private boolean isPosibleToMove(Direction d) {
        return getAvailableMovesFor(getBlank()).contains(d);
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

    public int[][] getTable() { return table; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public void setTable(int[][] table) { this.table = table; }

    public void setWidth(int width) { this.width = width; }

    public void setHeight(int height) { this.height = height; }

    @Override
    public String toString() {
        return "State{" +
                "table=" + Arrays.toString(table) +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}

