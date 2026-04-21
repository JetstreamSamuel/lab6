package org;

import org.commands.*;
import org.utils.FileManager;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Properties props = new Properties();
        try{
            props.load(new FileInputStream(".env"));
        } catch (Exception e) {System.out.println(e.getMessage());}
        String path = props.getProperty("PATH_TO_XML");
        try {
            CommandExecuter commandExecuter = new CommandExecuter(FileManager.loadXML(path));
            setCommands(commandExecuter);

            while (true) {
                try {
                    System.out.print("Ожидается ввод команды: ");
                    String command = scanner.nextLine();
                    commandExecuter.execute(command, scanner);
                } catch (RuntimeException e) {System.out.println(e.getMessage());}
            }
        } catch (Exception e) {System.out.println(e.getMessage());}
    }

    private static void setCommands(CommandExecuter executer) {
        var infoCom = new InfoCommand();
        var showCom = new ShowCommand();
        var insertCom = new InsertCommand();
        var updateCom = new UpdateCommand();
        var removeKeyCom = new RemoveKeyCommand();
        var clearCom = new ClearCommand();
        var saveCom = new SaveCommand();
        var executeCom = new ExecuteScriptCommand(executer);
        var exitCom = new ExitCommand();
        var removeLowerCom = new RemoveLowerCommand();
        var replaceCom = new ReplaceGreaterCommand();
        var removeLowerKeyCom = new RemoveLowerKeyCommand();
        var maxNameCom = new MaxByNameCommand();
        var taglineCom = new PrintUniqueTaglineCommand();
        var usaCom = new PrintUsaBoxOfficeCommand();

        executer.addCommand(infoCom);
        executer.addCommand(showCom);
        executer.addCommand(insertCom);
        executer.addCommand(updateCom);
        executer.addCommand(removeKeyCom);
        executer.addCommand(clearCom);
        executer.addCommand(saveCom);
        executer.addCommand(executeCom);
        executer.addCommand(exitCom);
        executer.addCommand(removeLowerCom);
        executer.addCommand(replaceCom);
        executer.addCommand(removeLowerKeyCom);
        executer.addCommand(maxNameCom);
        executer.addCommand(taglineCom);
        executer.addCommand(usaCom);
    }
}