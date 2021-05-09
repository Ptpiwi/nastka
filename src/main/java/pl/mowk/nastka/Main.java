package pl.mowk.nastka;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        try {
            parseArgs(args);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void parseArgs(String[] args) throws FileNotFoundException {
        String alg = args[0];
        String order = args[1];
        String dataPath = args[2];
        String resPath = args[3];
        String statPath = args[4];
        FileOptions files = new FileOptions();
        byte[][] table = files.fileReader(dataPath);
        int height = table.length;
        int width = table[0].length;
        byte[][] solution = new byte[height][width];
        for (byte i = 0; i < height; i++) {
            for (byte j = 0; j < width; j++) {
                solution[i][j]=(byte) ((i*height+j+1)%(height*width));
            }
        }
        System.out.println(Arrays.deepToString(table));
        State state = new State(table);
        State finalState = new State(solution);
        Report result;
        if (alg.equals("bfs")) {
            BFS bfs = new BFS();
            result = bfs.findPath(state,finalState,order);
            if (result.getPath() != null)   {
                files.saveToFile(resPath,result.getPath().size(),result.toString());
            } else {
                files.saveToFile2(resPath,"-1");
            }
            files.saveToFile2(statPath,result.generateReport());
        }
        if (alg.equals("dfs")) {
            DFS dfs = new DFS();
            result = dfs.findPath(state, finalState,order);
            if (result.getPath() != null)   {
                files.saveToFile(resPath,result.getPath().size(),result.toString());
            } else {
                files.saveToFile2(resPath,"-1");
            }
            files.saveToFile2(statPath,result.generateReport());
        }
        if (alg.equals("astr")) {
            Astar astr = new Astar();
            if (order.equals("manh")){
                MannhatanDistance manh = new MannhatanDistance();
                result = astr.findPath(state,finalState,manh);
                if (result.getPath() != null)   {
                    files.saveToFile(resPath,result.getPath().size(),result.toString());
                } else {
                    files.saveToFile2(resPath,"-1");
                }
                files.saveToFile2(statPath,result.generateReport());
            }
            if (order.equals("hamm")){
                EuclideanDistance euclid = new EuclideanDistance();
                result = astr.findPath(state,finalState,euclid);
                if (result.getPath() != null)   {
                    files.saveToFile(resPath,result.getPath().size(),result.toString());
                } else {
                    files.saveToFile2(resPath,"-1");
                }
                files.saveToFile2(statPath,result.generateReport());
            }


        }
    }




}



