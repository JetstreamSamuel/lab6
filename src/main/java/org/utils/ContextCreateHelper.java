package org.utils;

import org.models.*;
import java.util.Scanner;

public class ContextCreateHelper {
    private static final Scanner scanner = new Scanner(System.in);
    public static Movie createMovie() {
        System.out.print("Введите название фильма: ");
        String name;
        while (( name = scanner.nextLine()) == "") {
            System.out.println("Имя не должно быть пустой строкой");
            System.out.print("Введите название фильма: ");
        }
        Coordinates coordinates = createCoords();
        long oscarsCount;
        while (true) {
            System.out.print("Введите количество оскаров > 0: ");
            try {
                oscarsCount = Long.parseLong(scanner.nextLine());
                if (oscarsCount > 0) break;
            } catch (RuntimeException e) {System.out.println("Ошибка записи числа");}

        }

        return null;
    }

    private static Coordinates createCoords() {
        return null;
    }

    private static MpaaRating createRating() {
        return null;
    }

    private static Person createDirector() {
        return null;
    }
}
