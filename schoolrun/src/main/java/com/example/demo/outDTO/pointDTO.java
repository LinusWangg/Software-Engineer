package com.example.demo.outDTO;

public class pointDTO {

    private float latitude;

    private float longitude;

    public pointDTO(float latitude, float longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public pointDTO() {
        super();
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "pointDTO{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
