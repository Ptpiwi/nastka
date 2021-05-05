package pl.mowk.nastka;

import java.util.Vector;

public class Report {
    Vector<Direction> path = null;
    int vistedStates = 0;
    int processedStates = 0;
    int maxDepht = 0;
    long time = 0;




    public Vector<Direction> getPath() {
        return path;
    }

    public void setPath(Vector<Direction> path) {
        this.path = path;
    }

    public int getVistedStates() {
        return vistedStates;
    }

    public void setVistedStates(int vistedStates) {
        this.vistedStates = vistedStates;
    }

    public int getProcessedStates() {
        return processedStates;
    }

    public void setProcessedStates(int processedStates) {
        this.processedStates = processedStates;
    }

    public int getMaxDepht() {
        return maxDepht;
    }

    public void setMaxDepht(int maxDepht) {
        this.maxDepht = maxDepht;
    }

    public double getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String generateReport() {
        String tmp;
        if (path == null) {
            tmp = "There is no solution" + "\n";
            tmp = tmp + "Visted states = " + vistedStates + "\n";
            tmp = tmp + "Procesed states = " + processedStates + "\n";
            tmp = tmp + "Max depht = " + maxDepht + "\n";
            tmp = tmp + "Time = " + (time*10e-10) + "\n";
            return tmp;
        }
        tmp = "Path = " + path + "\n";
        tmp = tmp + "Path lenght = " + path.size() + "\n";
        tmp = tmp + "Visted states = " + vistedStates + "\n";
        tmp = tmp + "Procesed states = " + processedStates + "\n";
        tmp = tmp + "Max depht = " + maxDepht + "\n";
        tmp = tmp + "Time = " + (time*10e-10) + "\n";
        return tmp;
    }

}
