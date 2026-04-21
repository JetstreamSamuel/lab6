package org.models;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name="coordinates")
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    @XmlElement(name="X")
    private Long x;

    @XmlElement(name="Y")
    private float y;

    public Coordinates() {}

    public Coordinates(Long x, float y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {return x;}
    public float getY() {return y;}

    public void setX(Long x) {this.x = x;}
    public void setY(float y) {this.y = y;}

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
}
