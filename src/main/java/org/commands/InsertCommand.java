package org.commands;

import org.models.Movie;
import org.utils.Context;
import org.utils.ContextCreateHelper;

public class InsertCommand extends Command{
    public InsertCommand() {super("insert");}

    @Override
    public void execute(Context context, String[] args) {
        StringBuilder builder = new StringBuilder();
        for (var arg : args) {builder.append(arg + " ");}
        String key = builder.toString();
        Movie newMovie = ContextCreateHelper.createMovie();
        context.add(key, newMovie);
    }

}
