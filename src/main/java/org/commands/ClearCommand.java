package org.commands;

import org.utils.Context;

public class ClearCommand extends Command{
    public ClearCommand() {super("clear");}

    @Override
    public void execute(Context context, String[] args) {context.clear();}
}
