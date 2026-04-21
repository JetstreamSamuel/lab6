package org.commands;

import org.utils.Context;
import java.util.Scanner;

public class RemoveKeyCommand extends Command{
    public RemoveKeyCommand() {super("remove_key");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        String key = String.join(" ", args);
        context.removeKey(key);
    }

    @Override
    public String description() {return "remove_key null : удалить элемент из коллекции по его ключу";}
}
