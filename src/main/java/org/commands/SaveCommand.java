package org.commands;

import org.utils.Context;
import org.utils.FileManager;

import java.util.Scanner;

public class SaveCommand extends Command{
    public SaveCommand() {super("save");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        String path = String.join(" ", args);
        try {
            FileManager.writeXML(context, path);
            System.out.println("Коллекция успешно сохранена в файл " + path);
        } catch (Exception e) {System.out.println(e.getMessage());}
    }

    @Override
    public String description() {return "save : сохранить коллекцию в файл";}
}
