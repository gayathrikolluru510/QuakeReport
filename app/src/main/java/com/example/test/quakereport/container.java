package com.example.test.quakereport;


public class container {

    private String mnameOfLocation;

    private long mtime;

    private double mintensity;





    public container(double intensity,String location,long time) {
        mnameOfLocation=location;
        mtime=time;
        mintensity=intensity;

    }

    public String getlocation() {
        return mnameOfLocation;
    }

    public long gettime()
    {


        return mtime;

    }

    public double getMintensity(){return mintensity;}

}