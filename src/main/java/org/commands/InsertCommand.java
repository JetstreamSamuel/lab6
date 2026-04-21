package org.commands;

import org.models.Movie;
import org.utils.Context;
import org.utils.ContextCreateHelper;
import java.util.Scanner;

public class InsertCommand extends Command{
    public InsertCommand() {super("insert");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        String key = String.join(" ", args);
        if (!context.getKeys().contains(key)) {
            Movie newMovie = new ContextCreateHelper(scanner).createMovie(context);
            context.add(key, newMovie);
            System.out.println("Фильм успешно добавлен!");
        } else System.out.println("Такой ключ уже присутствует в коллекции!");
    }

    @Override
    public String description() {return "insert null {elemnt} : добавить новый элемент с заданным ключом";}
}
