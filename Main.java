package com.ag.ml.clustering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DBSCAN dbscan = new DBSCAN();
        ArrayList<DataPoint> edps;
        try {
            edps= ReadFromFile(args[0], 4); // args contains file path for the csv data
            // N is number of features
            dbscan.setDataSet(edps);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        dbscan.runAlgorithm(3, 0.5);
        ArrayList<ArrayList<DataPoint>> clusters = dbscan.getClusters();
        for(ArrayList<DataPoint> cluster : clusters){
            System.out.println("Cluster " + cluster.size());
        }
        System.out.println("Outlier : " + dbscan.noise.size());

    }

    public static ArrayList<DataPoint> ReadFromFile(String path, int N ) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(path));
        String l = br.readLine();
        ArrayList<DataPoint> edps = new ArrayList<>();
        while((l = br.readLine()) != null){
            String[] data = l.split(",");
            EuclideanDataPoint edp = new EuclideanDataPoint();
            edp.setCoordinates(StringToDoubleArray(data, N));
            edps.add(edp);
        }
        return edps;
    }
    public static double[] StringToDoubleArray(String[] data, int N){
     double[] D = new double[N];
     for( int i = 0 ; i < N ; ++i){
         D[i] = Double.parseDouble(data[i]);
     }
     return D;
    }
}
