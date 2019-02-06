package com.ag.ml.clustering;

import java.util.ArrayList;

public abstract class DataPoint {
    boolean visited;
    int cluster = -1;
    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public abstract double distanceFrom(DataPoint dp);

    public ArrayList<DataPoint> getEpsilonNeighbours(ArrayList<DataPoint> dps, double Epsilon) {
        ArrayList<DataPoint> epsilonNN = new ArrayList<DataPoint>();
        for(DataPoint dp : dps){
            if(distanceFrom(dp) < Epsilon){
                epsilonNN.add(dp);
            }
        }
        return epsilonNN;
    }

}
