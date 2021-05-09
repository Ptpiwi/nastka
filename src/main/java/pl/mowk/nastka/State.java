package pl.mowk.nastka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class State {
    byte[][] table;
    int width, height;

    public State(byte[][] table) {
        this.height = table.length;
        this.width = table[0].length;
        this.table = new byte[height][width];
        deepcopyTable(table);
    }

    public State(State state) {
        this.width = state.getWidth();
        this.height = state.getHeight();
        this.table = new byte[height][width];
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

    private void deepcopyTable(byte[][] newTable) {
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
        for (byte i = 0; i < height; i++) {
            for (byte j = 0; j < width; j++) {
                if (table[i][j] == 0) {
                    return new Coordinates(i, j);
                }
            }
        }
        System.out.println("To nie powinno się wyświetlić w tablicy nie ma zera");
        return new Coordinates();
    }

    public Coordinates getCorByValue(int value) {
        for (byte i = 0; i < height; i++) {
            for (byte j = 0; j < width; j++) {
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

        if (coordinates.getX() != height - 1) directions.add(Direction.D);
        if (0 != coordinates.getX() ) directions.add(Direction.U);
        if ( coordinates.getY() != width - 1) directions.add(Direction.R);
        if (0 != coordinates.getY() ) directions.add(Direction.L);
        return directions;
    }

    private void setField(byte x, byte y, byte value) {
        table[x][y] = value;
    }
    public int getFieldValue(byte x, byte y) {
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

    public List<State> getNeighbours(Vector<Direction> permutation) {
        List<State> neighbours = new ArrayList<>();
        Vector<Direction> possibleMoves = getAvailableMoves();
        for (Direction d :
                permutation) {
            if (possibleMoves.contains(d)) {
                neighbours.add(move(d));
            }
        }
        return neighbours;
    }


    public State move(Direction direction) {
        State nextState = new State(this);
        Coordinates c = getBlank();
        switch (direction) {
            case L:
                    nextState.setField(c.getX(), c.getY(), table[c.getX()][c.getY() - 1]);
                    nextState.setField(c.getX(), (byte) (c.getY() - 1), (byte) 0);
                break;
            case R:
                    nextState.setField(c.getX(), c.getY(), table[c.getX()][c.getY() + 1]);
                    nextState.setField(c.getX(), (byte) (c.getY() + 1), (byte) 0);
                break;
            case U:
                    nextState.setField(c.getX(), c.getY(), table[c.getX() - 1][c.getY()]);
                    nextState.setField((byte) (c.getX() - 1), c.getY(), (byte) 0);
                break;
            case D:
                    nextState.setField(c.getX(), c.getY(), table[c.getX() + 1][c.getY()]);
                    nextState.setField((byte) (c.getX() + 1), c.getY(), (byte) 0);

                break;
            default:
                // code block
        }
        return nextState;
    }

    public byte[][] getTable() { return table; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

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

