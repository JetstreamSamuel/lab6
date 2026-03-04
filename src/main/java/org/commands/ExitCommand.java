package org.commands;

import org.utils.Context;

public class ExitCommand extends Command{
    public ExitCommand() {super("exit");}

    @Override
    public void execute(Context context, String[] args) {
        System.exit(0);
    }

}
