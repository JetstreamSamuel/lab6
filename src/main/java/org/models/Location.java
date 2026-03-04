package org.models;

public class Location {
    private Long x;
    private float y;
    private Float z;
    private String name;

    public Location(Long x, float y, Float z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public Long getX() {return x;}
    public float getY() {return y;}
    public Float getZ() {return  z;}
    public String getName() {return name;}

    public void setX(Long x) {this.x = x;}
    public void setY(float y) {this.y = y;}
    public void setZ(Float z) {this.z = z;}
    public void setName(String name) {this.name = name;}
}
