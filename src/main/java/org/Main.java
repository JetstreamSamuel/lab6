package org;

import org.commands.*;
import org.utils.Context;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandExecuter commandExecuter = new CommandExecuter(new Context());
        Scanner scanner = new Scanner(System.in);

        setCommands(commandExecuter);

        while (true) {
            try {
                System.out.print("Ожидается ввод команды: ");
                String command = scanner.nextLine();
                System.out.println("Исполняется команда " + command);
                commandExecuter.execute(command);
            } catch (RuntimeException e) {System.out.println(e.getMessage());}
        }
    }

    private static void setCommands(CommandExecuter executer) {
        var exitCom = new ExitCommand();
        var clearCom = new ClearCommand();
        var saveCom = new SaveCommand();
        var showCom = new ShowCommand();
        var insertCom = new InsertCommand();

        executer.addCommand(exitCom);
        executer.addCommand(insertCom);
        executer.addCommand(showCom);
        executer.addCommand(clearCom);
    }
}