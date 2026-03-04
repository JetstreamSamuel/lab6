package org.models;

public class Coordinates {
    private Long x;
    private float y;

    public Coordinates(Long x, float y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {return x;}
    public float getY() {return y;}

    public void setX(Long x) {this.x = x;}
    public void setY(float y) {this.y = y;}
}
