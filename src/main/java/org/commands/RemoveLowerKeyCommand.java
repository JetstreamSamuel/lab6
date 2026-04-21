package org.commands;

import org.utils.Context;

import java.util.Scanner;

public class RemoveLowerKeyCommand extends Command{
    public RemoveLowerKeyCommand() {super("remove_lower_key");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        String bigKey = String.join(" ", args);
        for (var key : context.getKeys()) {
            if (bigKey.compareTo(key) > 0) {context.removeKey(key);}
        }
    }

    @Override
    public String description() {return "remove_lower_key null : " +
            "удалить из коллекции все элементы, ключ которых меньше, чем заданный";}
}
