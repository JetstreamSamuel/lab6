package org.commands;

import org.utils.Context;
import org.models.Movie;
import java.util.Scanner;

public class MaxByNameCommand extends Command{
    public MaxByNameCommand() {super("max_by_name");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        Movie target = context.getElem((String) context.getKeys().toArray()[0]);
        for (var key : context.getKeys()) {
            Movie prev = context.getElem(key);
            if (prev.getName().compareTo(target.getName()) > 0) {target = prev;}
        }
        System.out.println(target);
    }

    @Override
    public String description() {return "max_by_name : вывести любой объект из коллекции, " +
            "значение поля name которого является максимальным";}
}
