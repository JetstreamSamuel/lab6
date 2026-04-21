package org.commands;

import org.utils.Context;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class ExecuteScriptCommand extends Command{
    private CommandExecuter executer;
    public ExecuteScriptCommand(CommandExecuter executer) {
        super("execute_script");
        this.executer = executer;
    }

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        String fileName = String.join(" ", args);
        try {
            executer.executeScript(new Scanner(new FileInputStream(fileName)));
        } catch (IOException e) {System.out.println(e.getMessage());}
    }

    @Override
    public String description() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла";
    }
}
