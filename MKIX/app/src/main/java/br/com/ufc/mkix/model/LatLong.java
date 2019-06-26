package br.com.ufc.mkix.model;

public class LatLong {

    private double latitide;
    private double longitude;

    public LatLong(){

    }

    public LatLong(double latitide, double longitude){
        this.latitide=latitide;
        this.longitude=longitude;
    }

    public double getLatitide() {
        return latitide;
    }

    public void setLatitide(double latitide) {
        this.latitide = latitide;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String toString(){
        return "Long"+ this.longitude + "Lat" +this.longitude;
    }

}

