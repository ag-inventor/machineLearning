package com.ag.ml.clustering;

import java.util.ArrayList;

public class DBSCAN {
    ArrayList<DataPoint> noise;
    ArrayList<DataPoint> dataSet;
    ArrayList<ArrayList<DataPoint>> clusters = new ArrayList<>();
    int N = 0;

    public ArrayList<DataPoint> getDataSet() {
        return dataSet;
    }

    public void setDataSet(ArrayList<DataPoint> dataSet) {
        this.dataSet = dataSet;
    }

    public ArrayList<ArrayList<DataPoint>> getClusters() {
        return clusters;
    }

    public void setClusters(ArrayList<ArrayList<DataPoint>> clusters) {
        this.clusters = clusters;
    }

    public void runAlgorithm(int K, double Epsilon){
        if(dataSet == null){
            return;
        }
        ArrayList<DataPoint> unvisited = new ArrayList<>();
        noise = new ArrayList<>();

        for(DataPoint dp : dataSet){
            unvisited.add(dp);
        }

        while(unvisited.size() > 0){
            int mid = unvisited.size()/2;
            DataPoint dp = unvisited.remove(mid);
            ArrayList<DataPoint> Cluster = new ArrayList<>();
            FormCluster(dp, K, Epsilon, Cluster, unvisited);
            if(Cluster.size() == 1){
                noise.add(dp);
            }
            else {
                N++;
                clusters.add(Cluster);
            }

        }



    }

    public void FormCluster(DataPoint dp, int K,
                                              double Epsilon, ArrayList<DataPoint> Cluster,
                            ArrayList<DataPoint> unvisited){

        ArrayList<DataPoint> ENN  = dp.getEpsilonNeighbours(dataSet, Epsilon);
        Cluster.add(dp);
        dp.visited = true;
        System.out.println(Cluster.size() + " : " + N + " :: " + ENN.size() );
        if(ENN.size() > K){

            for(DataPoint dpi : ENN){
                    unvisited.remove(dpi);

                if(!Cluster.contains(dpi))
                    FormCluster(dpi, K, Epsilon, Cluster, unvisited);
            }
        }

    }

}
