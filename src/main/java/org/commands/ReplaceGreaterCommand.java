package org.commands;

import org.models.Movie;
import org.utils.Context;
import org.utils.ContextCreateHelper;

import java.util.Scanner;

public class ReplaceGreaterCommand extends Command{
    public ReplaceGreaterCommand() {super("replace_if_greater");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        String key = String.join(" ", args);
        if (context.getKeys().contains(key)) {
            Movie target = new ContextCreateHelper(scanner).createMovie(context);
            Movie prev = context.getElem(key);
            if (target.compareTo(prev) > 0) {context.add(key, target);}
        } else {System.out.println("Такого ключа нет!");}
    }

    @Override
    public String description() {
        return "replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого";
    }
}
