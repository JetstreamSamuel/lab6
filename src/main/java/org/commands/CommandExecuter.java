package org.commands;

import org.utils.*;

import java.util.Arrays;
import java.util.HashMap;

public class CommandExecuter {

    private HashMap<String, Command> commands;
    private Context context;

    //Класс команды  Help
    private class HelpCommand extends Command {
        private HelpCommand() {super("help");}

        @Override
        public void execute(Context context, String[] args){
            if (args.length > 0) throw new ArgumentException("Команда не принимает аргуенты");
            System.out.println("Список допустимых команд:");
            for (Command com: commands.values()) {
                System.out.println(com.description());
            }
        }

        @Override
        public String description() {return "";}
    }

    public CommandExecuter(Context context){
        this.context = context;
        commands = new HashMap<>();
        HelpCommand helpCommand = new HelpCommand();
        commands.put(helpCommand.getName(), helpCommand);
    }

    public void execute(String line) throws NoCommandException{
        String[] lines = line.split(" ");
        String commandName = lines[0];
        String[] args = Arrays.copyOfRange(lines, 1, lines.length);

        try {
            Command localCommand = commands.get(commandName);
            localCommand.execute(context, args);
        } catch (RuntimeException e) {throw new NoCommandException("Команда не существует, обратитесь к help");}
    }

    public void addCommand(Command command){commands.put(command.getName(), command);}

    public void setCommands(HashMap<String, Command> commands) {this.commands = commands;}

}
