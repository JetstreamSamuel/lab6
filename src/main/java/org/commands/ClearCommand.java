package org.commands;

import org.utils.Context;
import java.util.Scanner;

public class ClearCommand extends Command{
    public ClearCommand() {super("clear");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {context.clear();}

    @Override
    public String description() {return "clear : очистить коллекцию";}
}
