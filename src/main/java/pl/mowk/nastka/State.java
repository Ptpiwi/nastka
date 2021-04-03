package pl.mowk.nastka;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Vector;

@Getter
@Setter
@ToString
public class State {
    int[][] table;
    int sizeOftable;

    public State(int sizeOftable){
        this.sizeOftable=sizeOftable;
        this.table= new int[sizeOftable][sizeOftable];

    }
    public State(int[][] table){
        this.sizeOftable=table.length;
        this.table=table;
    }
    public boolean isDone(){
        int[][] finalState = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        return Arrays.deepEquals(table, finalState);
    };
    
    public Vector<Direction> getAvabileMoves(){
        return getAvabileMovesFor(getBlank());
    }

    public Coordinates getBlank(){
        for (int i=0; i<sizeOftable; i++){
            for (int j=0; j<sizeOftable; j++){
                if (table[i][j]==0) {
                    return new Coordinates(i,j);
                }
            }
        }
        System.out.println("To nie powinno się wyświetlić w tablicy nie ma zera");
        return new Coordinates();
    }

    public Vector<Direction> getAvabileMovesFor(Coordinates coordinates){
        Vector<Direction> directions = new Vector<>();
        if (0<coordinates.getX() && coordinates.getX() <= sizeOftable-1) directions.add(Direction.U);
        if (0<=coordinates.getX() && coordinates.getX()<sizeOftable-1) directions.add(Direction.D);
        if (0<=coordinates.getY() && coordinates.getY() < sizeOftable-1) directions.add(Direction.R);
        if (0<coordinates.getY() && coordinates.getY()<=sizeOftable-1) directions.add(Direction.L);
        return directions;
    }


    
    public void move(Direction direction){
        switch (direction){
            case L:
                if (isPosibleToMove(direction)) {
                    Coordinates c = getBlank();
                    table[c.getX()][c.getY()] = table[c.getX()][c.getY() - 1];
                    table[c.getX()][c.getY() - 1] = 0;
                    break;
                }
                break;
            case R:
                if (isPosibleToMove(direction)) {
                    Coordinates c = getBlank();
                    table[c.getX()][c.getY()] = table[c.getX()][c.getY() + 1];
                    table[c.getX()][c.getY() + 1] = 0;
                    break;
                }
                break;
            case U:
                if (isPosibleToMove(direction)) {
                    Coordinates c = getBlank();
                    table[c.getX()][c.getY()] = table[c.getX()-1][c.getY()];
                    table[c.getX()-1][c.getY()] = 0;
                    break;
                }
                break;
            case D:
                if (isPosibleToMove(direction)) {
                    Coordinates c = getBlank();
                    table[c.getX()][c.getY()] = table[c.getX()+1][c.getY()];
                    table[c.getX()+1][c.getY()] = 0;
                    break;
                }
                break;
            default:
                // code block
        }

    }

    private boolean isPosibleToMove(Direction d) {
        return getAvabileMovesFor(getBlank()).contains(d);
    }


}
