package pl.mowk.nastka;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        parseArgs(args);
    }

    private static void parseArgs(String[] args) throws FileNotFoundException {
        String alg = args[0];
        String order = args[1];
        String dataPath = args[2];
        String resPath = args[3];
        String statPath = args[4];
        FileOptions files = new FileOptions();
        int table[][] = files.FileReader(dataPath);
        int height = files.getHeight(dataPath);
        int width = files.getWidth(dataPath);
        int[][] solution = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

        State state = new State(table);
        state.setHeight(height);
        state.setWidth(width);
        State finalState = new State(solution);
        BFS bfs = new BFS();
        DFS dfs = new DFS();
        Astar astr = new Astar();
        MannhatanDistance manh = new MannhatanDistance();
        EuclideanDistance euclid = new EuclideanDistance();
        Vector<Direction> result;

        if (alg.equals("bfs")) {
            result = bfs.findPath(state,finalState);
            StringBuilder test = new StringBuilder();
            for (Direction d : result){
                test.append(d);
            }
            files.saveToFile(resPath,result.size(),test.toString());
        }
        if (alg.equals("dfs")) {
            result = dfs.findPath(state, finalState);
            StringBuilder test1 = new StringBuilder();
            for (Direction d : result){
                test1.append(d);
            }
            files.saveToFile(resPath,result.size(),test1.toString());
        }
        if (alg.equals("astr")) {
            if (order.equals("manh")){
                result = astr.findPath(state,finalState,manh);
                StringBuilder test1 = new StringBuilder();
                for (Direction d : result){
                    test1.append(d);
                }
                files.saveToFile(resPath,result.size(),test1.toString());
            }
            if (order.equals("hamm")){
                result = astr.findPath(state,finalState,euclid);
                StringBuilder test1 = new StringBuilder();
                for (Direction d : result){
                    test1.append(d);
                }
                files.saveToFile(resPath,result.size(),test1.toString());
            }

        }
    }
}

