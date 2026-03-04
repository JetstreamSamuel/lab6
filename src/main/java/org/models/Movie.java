package org.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Movie {
    private int id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private long oscarsCount;
    private long usaBoxOffice;
    private String tagline;
    private MpaaRating mpaaRating;
    private Person director;

    public Movie(String name, Coordinates coordinates, long oscarsCount, long usaBoxOffice,
                 String tagline, MpaaRating mpaaRating, Person director) {
        this.name = name;
        this.coordinates = coordinates;
        this.oscarsCount = oscarsCount;
        this.usaBoxOffice = usaBoxOffice;
        this.tagline = tagline;
        this.mpaaRating = mpaaRating;
        this.director = director;

        id = UUID.randomUUID().hashCode();
        creationDate = LocalDateTime.now();

    }

    public Integer getId() {return id;}
    public String getName() {return name;}
    public Coordinates getCoordinates() {return coordinates;}
    public LocalDateTime getCreationDate() {return creationDate;}
    public long getOscarsCount() {return oscarsCount;}
    public long getUsaBoxOffice() {return usaBoxOffice;}
    public String getTagline() {return tagline;}
    public MpaaRating getMpaaRating() {return mpaaRating;}
    public Person getDirector() {return director;}

    public void setName(String name) {this.name = name;}
    public void setCoordinates(Coordinates coordinates) {this.coordinates = coordinates;}
    public void setOscarsCount(long oscarsCount) {this.oscarsCount = oscarsCount;}
    public void setTagline(String tagline) {this.tagline = tagline;}
    public void setMpaaRating(MpaaRating mpaaRating) {this.mpaaRating = mpaaRating;}
    public void setUsaBoxOffice(long usaBoxOffice) {this.usaBoxOffice = usaBoxOffice;}
    public void setDirector(Person director) {this.director = director;}

    //TODO
    @Override
    public String toString() {
        return id + " какой-то фильм";
    }
}
