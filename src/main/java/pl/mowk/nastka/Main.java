package pl.mowk.nastka;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Vector;

public class Main {
/*
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
        byte[][] solution = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

        State state = new State(table);
        state.setHeight(height);
        state.setWidth(width);
        State finalState = new State(solution);
        BFS bfs = new BFS();
        DFS dfs = new DFS();
        Astar astr = new Astar();
        MannhatanDistance manh = new MannhatanDistance();
        EuclideanDistance euclid = new EuclideanDistance();
        Report result;
        if (alg.equals("bfs")) {
            result = bfs.findPath(state,finalState,order);
            files.saveToFile(resPath,result.getPath().size(),result.toString());
            files.saveToFile2(statPath,result.generateReport());
        }
        if (alg.equals("dfs")) {
            result = dfs.findPath(state, finalState,order);
            files.saveToFile(resPath,result.getPath().size(),result.toString());
            files.saveToFile2(statPath,result.generateReport());
        }
        if (alg.equals("astr")) {
            if (order.equals("manh")){
                result = astr.findPath(state,finalState,manh);
                if (result.getPath() != null)   {
                    files.saveToFile(resPath,result.getPath().size(),result.toString());
                } else {
                    files.saveToFile(resPath,0,"");
                }
                files.saveToFile2(statPath,result.generateReport());
            }
            if (order.equals("hamm")){
                result = astr.findPath(state,finalState,euclid);
                files.saveToFile(resPath,result.getPath().size(),result.toString());
                files.saveToFile2(statPath,result.generateReport());
            }

        }
    }

 */
}



