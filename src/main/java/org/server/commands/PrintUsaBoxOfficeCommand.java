package org.server.commands;

import org.server.service.Context;
import java.util.ArrayList;
import java.util.Collections;

public class PrintUsaBoxOfficeCommand extends Command{
    private Context context = Context.getInstance();
    public PrintUsaBoxOfficeCommand() {super("print_field_ascending_usa_box_office");}

    @Override
    public String execute() {
        ArrayList<Long> list = new ArrayList<>();
        for (var key : context.getKeys()) {
            list.add(Long.valueOf(context.getElem(key).getUsaBoxOffice()));
        }
        Collections.sort(list);
        return list.toString();

    }

    @Override
    public String description() {
        return "print_field_ascending_usa_box_office : " +
                "вывести значения поля usaBoxOffice всех элементов в порядке возрастания";
    }
}
