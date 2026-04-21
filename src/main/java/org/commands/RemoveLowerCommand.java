package org.commands;

import org.utils.Context;
import org.utils.ContextCreateHelper;
import org.models.Movie;

import java.util.Scanner;

public class RemoveLowerCommand extends Command{
    public RemoveLowerCommand() {super("remove_lower");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        Movie target = new ContextCreateHelper(scanner).createMovie(context);
        for (var key : context.getKeys()) {
            if (target.compareTo(context.getElem(key)) > 0) {context.removeKey(key);}
        }
    }

    @Override
    public String description() {return "remove_lower {element} : " +
            "удалить из коллекции все элементы, меньшие, чем заданный";}
}
