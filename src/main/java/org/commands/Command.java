package org.commands;

import org.utils.Context;
import java.util.Scanner;

public abstract class Command {
    protected final String name;
    protected Command(String name) {this.name = name;}
    abstract void execute(Context ctx, String[] args, Scanner scanner) throws ArgumentException;
    abstract String description();
    public String getName() {return name;}
}
