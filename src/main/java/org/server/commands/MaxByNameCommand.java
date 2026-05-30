package org.server.commands;

import org.server.service.Context;
import org.models.Movie;

public class MaxByNameCommand extends Command{
    private Context context = Context.getInstance();
    public MaxByNameCommand() {super("max_by_name");}

    @Override
    public String execute() {
        Movie target = context.getElem((String) context.getKeys().toArray()[0]);
        for (var key : context.getKeys()) {
            Movie prev = context.getElem(key);
            if (prev.getName().compareTo(target.getName()) > 0) {target = prev;}
        }
        return target.toString();
    }

    @Override
    public String description() {return "max_by_name : вывести любой объект из коллекции, " +
            "значение поля name которого является максимальным";}
}
