package org.server.commands;

import org.server.service.Context;

import java.util.*;

public class PrintUniqueTaglineCommand extends Command{
    private Context context = Context.getInstance();
    public PrintUniqueTaglineCommand() {super("print_unique_tagline");}

    @Override
    public String execute() {
        Set<String> taglines = new HashSet<>();
        for (var key : context.getKeys()){
            taglines.add(context.getElem(key).getTagline());
        }
        return taglines.toString();
    }

    @Override
    public String description() {
        return "print_unique_tagline : вывести уникальные значения поля tagline всех элементов в коллекции";
    }
}
