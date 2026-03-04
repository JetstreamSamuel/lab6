package org.commands;

import org.utils.Context;

public class ShowCommand extends Command{
    public ShowCommand() {super("show");}

    @Override
    public void execute(Context context, String[] args) {
        if (args.length > 0) throw new ArgumentException("команда не принимает аргументы");
        context.show();
    }


}
