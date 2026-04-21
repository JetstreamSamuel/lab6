package org.commands;

import org.utils.Context;
import java.util.Scanner;

public class ExitCommand extends Command{
    public ExitCommand() {super("exit");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        System.exit(0);
    }

    @Override
    public String description() {return "exit : завершить программу (без сохранения в файл)";}
}
