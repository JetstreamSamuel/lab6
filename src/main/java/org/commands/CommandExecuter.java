package org.commands;

import org.utils.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CommandExecuter {

    private HashMap<String, Command> commands;
    private Context context;

    private class HelpCommand extends Command {
        private HelpCommand() {super("help");}

        @Override
        public void execute(Context context, String[] args, Scanner scanner){

            if (args.length > 0) throw new ArgumentException("Команда не принимает аргуенты");

            System.out.println("Список допустимых команд:");
            for (Command com: commands.values()) {System.out.println(com.description());}
        }

        @Override
        public String description() {return "help : вывести справку по доступным командам";}
    }

    public CommandExecuter(Context context){
        this.context = context;
        commands = new LinkedHashMap<>();
        HelpCommand helpCommand = new HelpCommand();
        commands.put(helpCommand.getName(), helpCommand);
    }

    public void execute(String line, Scanner scanner) throws NoCommandException{
        String stroka = line.strip().replaceAll("\\s+", " ");
        if (!stroka.isEmpty()) {
            String[] lines = stroka.split(" ");
            String commandName = lines[0];
            String[] args = Arrays.copyOfRange(lines, 1, lines.length);
            try {
                Command localCommand = commands.get(commandName);
                localCommand.execute(context, args, scanner);
            } catch (RuntimeException e) {
                throw new NoCommandException("Команда " + line + " не существует, обратитесь к help");
            }
        }
    }

    public void executeScript(Scanner scanner) {
        while (scanner.hasNextLine()) {
            try {
                String line = scanner.nextLine();
                System.out.println(line);
                execute(line, scanner);
            } catch (Exception e) {System.out.println("Что-то пошло не так..."); break;}
        }
    }

    public void addCommand(Command command){commands.put(command.getName(), command);}

    public void setCommands(HashMap<String, Command> commands) {this.commands = commands;}

}
