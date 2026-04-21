package org.commands;

import org.utils.Context;
import java.util.Scanner;

public class ShowCommand extends Command{
    public ShowCommand() {super("show");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {context.show();}

    @Override
    public String description() {return "show : вывести в стандартный поток вывода все элементы коллекции";}
}
