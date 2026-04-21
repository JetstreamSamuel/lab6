package org.utils;

import org.models.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Set;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.utils.adapters.XmlDateAdapter;
@XmlRootElement(name="context")
@XmlAccessorType(XmlAccessType.FIELD)
public class Context {
    @XmlElement(name="creationDate")
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    private final LocalDateTime creationDate;

    @XmlElementWrapper(name = "movies")
    @XmlElement(name = "movie")
    private HashMap<String, Movie> collection;

    public Context() {
        collection = new HashMap<>();
        creationDate = LocalDateTime.now();
    }

    public void clear() {collection.clear();}

    public void add(String key, Movie movie) {collection.put(key, movie);}

    public void show() {
        StringBuilder builder = new StringBuilder();
        for (var key : collection.keySet()) {
            Movie movie = collection.get(key);
            builder.append(key + ": " + movie.toString() + "\n");
        }
        System.out.println(builder);
    }

    public Set<String> getKeys() {return collection.keySet();}

    public Movie getElem(String key) {return collection.get(key);}

    public void removeKey(String key) {collection.remove(key);}


    public String getInfo() {
        return "Информация о коллекции:\n" +
                "Тип: Movie\n" +
                "Дата создания: " + creationDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")) + "\n" +
                "Количество элементов: " + collection.values().toArray().length;
    }
}
