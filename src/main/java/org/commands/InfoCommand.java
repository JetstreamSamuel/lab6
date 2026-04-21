package org.commands;

import org.utils.Context;
import java.util.Scanner;

public class InfoCommand extends Command{
    public InfoCommand() {super("info");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {System.out.println(context.getInfo());}

    @Override
    public String description() {return "info : вывести в стандартный поток вывода информацию о коллекции";}
}
