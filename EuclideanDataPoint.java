package com.ag.ml.clustering;


public class EuclideanDataPoint extends DataPoint {
    double[] coordinates;

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public double distanceFrom(DataPoint dp) {
        double dist = 0.0;
        EuclideanDataPoint edp = (EuclideanDataPoint) dp;
        if(edp.getCoordinates().length != coordinates.length){
            System.out.println("Dimensions of data points mismatch!!");
            return Double.MAX_VALUE;
        }
        for(int i = 0 ;i < coordinates.length ; i++){
            double d = (coordinates[i] - edp.getCoordinates()[i]);
            d = d*d;
            dist += d;
        }

        return Math.sqrt(dist);
    }


}
