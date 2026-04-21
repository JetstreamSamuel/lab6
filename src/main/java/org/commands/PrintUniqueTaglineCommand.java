package org.commands;

import org.utils.Context;

import java.util.*;

public class PrintUniqueTaglineCommand extends Command{
    public PrintUniqueTaglineCommand() {super("print_unique_tagline");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        Set<String> taglines = new HashSet<>();
        for (var key : context.getKeys()){
            taglines.add(context.getElem(key).getTagline());
        }
        taglines.forEach(System.out::print);
    }

    @Override
    public String description() {
        return "print_unique_tagline : вывести уникальные значения поля tagline всех элементов в коллекции";
    }
}
