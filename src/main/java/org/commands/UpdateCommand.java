package org.commands;

import org.models.Movie;
import org.utils.Context;
import org.utils.ContextCreateHelper;

import java.util.Scanner;

public class UpdateCommand extends Command {
    public UpdateCommand() {super("update");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        int id;
        try {
            id = Integer.parseInt(args[0]);
        } catch (Exception e) {throw new ArgumentException("id должно быть int");}
        for (var key : context.getKeys()) {
            Movie prev = context.getElem(key);

            if (prev.getId().equals(id)) {
                Movie newMovie = new ContextCreateHelper(scanner).createMovie(context);
                prev.setCoordinates(newMovie.getCoordinates());
                prev.setDirector(newMovie.getDirector());
                prev.setName(newMovie.getName());
                prev.setTagline(newMovie.getTagline());
                prev.setMpaaRating(newMovie.getMpaaRating());
                prev.setOscarsCount(newMovie.getOscarsCount());
                prev.setUsaBoxOffice(newMovie.getUsaBoxOffice());
            }
        }
    }

    @Override
    public String description() {return "update id {element} : " +
            "обновить значение элемента коллекции, id которого равен заданному";}
}
