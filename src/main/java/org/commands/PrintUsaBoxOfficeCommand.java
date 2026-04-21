package org.commands;

import org.utils.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PrintUsaBoxOfficeCommand extends Command{
    public PrintUsaBoxOfficeCommand() {super("print_field_ascending_usa_box_office");}

    @Override
    public void execute(Context context, String[] args, Scanner scanner) {
        ArrayList<Long> list = new ArrayList<>();
        for (var key : context.getKeys()) {
            list.add(Long.valueOf(context.getElem(key).getUsaBoxOffice()));
        }
        Collections.sort(list);
        System.out.print("usaBoxOffice в порядке возрастания: ");
        list.forEach(System.out::print);
        System.out.print("\n");
    }

    @Override
    public String description() {
        return "print_field_ascending_usa_box_office : " +
                "вывести значения поля usaBoxOffice всех элементов в порядке возрастания";
    }
}
