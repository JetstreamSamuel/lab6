package org.utils;

import org.models.*;
import java.util.Scanner;

public class ContextCreateHelper {
    private Scanner scanner;

    public ContextCreateHelper(Scanner scanner) {this.scanner = scanner;}

    public Movie createMovie(Context context) {
        System.out.println("Создание фильма");
        String name;
        Coordinates coordinates;
        long oscarsCount;
        long usaBoxOffice;
        String tagline;
        MpaaRating rating;
        Person director;

        while (true) {
            System.out.print("Введите название фильма: ");
            name = scanner.nextLine().strip().replaceAll("\\s+", " ");
            if (!name.isEmpty()) break;
            System.out.println("Ошибка записи строки");
        }

        coordinates = createCoords();

        oscarsCount = createOscars();
        usaBoxOffice = createUsaBoxOffice();

        tagline = createTagline();

        rating = createRating();
        director = createDirector(context);


        return new Movie(name, coordinates, oscarsCount, usaBoxOffice, tagline, rating, director);
    }

    private Coordinates createCoords() {
        System.out.println("Создание координат");
        Coordinates res;
        Long x;
        float y;

        while (true) {
            System.out.print("Введите координату X: ");
            try {
                x = Long.parseLong(scanner.nextLine().strip());
                if (x <= 995) break;
            } catch (RuntimeException e) {System.out.println("Ошибка записи координаты X");}
        }

        while (true) {
            System.out.print("Введите координату Y: ");
            try {
                y = Float.parseFloat(scanner.nextLine().strip().replace(',', '.'));
                break;
            } catch (RuntimeException e) {System.out.println("Ошибка записи координаты Y");}
        }

        return new Coordinates(x, y);
    }

    private long createOscars() {
        long res;
        while (true) {
            System.out.print("Введите количество оскаров: ");
            try {
                res = Long.parseLong(scanner.nextLine().strip());
                if (res > 0) return res;
                System.out.println("Оскаров не может быть меньше 0!");
            } catch (RuntimeException e) {System.out.println("Ошибка записи числа");}
        }
    }

    private long createUsaBoxOffice() {
        long res;
        while (true) {
            System.out.print("Введите USA(USSR) box office: ");
            try {
                res = Long.parseLong(scanner.nextLine().strip());
                if (res > 0) return  res;
            } catch (RuntimeException e) {System.out.println("Ошибка записи числа");}
        }
    }

    private String createTagline() {
        String res;
        System.out.print("Введите ключевую фразу tagline: ");
        res = scanner.nextLine().strip().replaceAll("\\s+", " ");
        if (res.isEmpty()) return null;
        return res;
    }

    private MpaaRating createRating() {
        MpaaRating res;
        for (var value : MpaaRating.values()) {System.out.println(value);}
        while (true) {
            System.out.print("Введите рейтинг фильма из списка: ");
            try {
                res = MpaaRating.valueOf(scanner.nextLine().strip());
                return res;
            } catch (RuntimeException e) {System.out.println("Некоректное значение");}
        }
    }

    private Person createDirector(Context context) {
        System.out.print("Создание директора? null/Y: ");
        String otvet = scanner.nextLine().strip();
        if (otvet.isEmpty()) return null;

        String name;
        String passportID;
        Color eyeColor;
        Color hairColor;
        Country nationality;
        Location location;

        while (true) {
            System.out.print("Введте имя: ");
            name = scanner.nextLine().strip();
            if (name.contains(" ")) {System.out.println("Имя должно быть одним словом!"); continue;}
            if (!name.isEmpty()) break;
            System.out.println("Имя не может быть null");
        }

        while (true) {
            System.out.print("Введите уникальный паспорт ID: ");
            passportID = scanner.nextLine().strip();
            if (passportID.contains(" ")) {System.out.println("ID должен быть одним словом!"); continue;}
            if (passportID.length() > 25) {System.out.println("Длинна не может быть больше 25 символов");continue;}
            boolean flag = true;
            for (var key : context.getKeys()) {
                if (context.getElem(key).getDirector().getPassportID().equals(passportID)) {
                    System.out.println("Такой id уже существует");
                    flag = false;
                    break;
                }
            }
            if (!flag) {continue;}
            else if (!passportID.isEmpty()){break;}
            System.out.println("Некоректный ввод");
        }

        for (var elem : Color.values()) {System.out.println(elem);}
        while (true) {
            System.out.print("Введите цвет глаз/null: ");
            String line = scanner.nextLine().strip();
            if (line.isEmpty()) {eyeColor = null; break;}
            try {
                eyeColor = Color.valueOf(line);
                break;
            } catch (RuntimeException e) {System.out.println("Неверный ввод");}
        }

        for (var elem : Color.values()) {System.out.println(elem);}
        while (true) {
            System.out.print("Введите цвет волос: ");
            try {
                hairColor = Color.valueOf(scanner.nextLine().strip());
                break;
            } catch (RuntimeException e) {System.out.println("Неверный ввод!");}
        }

        for (var elem : Country.values()) {System.out.println(elem);}
        while (true) {
            System.out.print("Введите национальность: ");
            try {
                nationality = Country.valueOf(scanner.nextLine());
                break;
            } catch (RuntimeException e) {System.out.println("Неверный ввод!");}
        }

        location = createLocation();

        return new Person(name, passportID, eyeColor, hairColor, nationality, location);
    }

    private Location createLocation() {
        System.out.print("Добавить локацию? null/Y: ");
        String otvet = scanner.nextLine().strip();
        if (otvet.isEmpty()) return null;

        Long x;
        float y;
        Float z;
        String name;

        while (true) {
            System.out.print("Введите целочисленную коорд X: ");
            try {
                x = Long.parseLong(scanner.nextLine().strip());
                break;
            } catch (RuntimeException e) {System.out.println("Некоректный ввод!");}
        }

        while (true) {
            System.out.print("Введите вещественную коорд Y: ");
            try {
                y = Float.parseFloat(scanner.nextLine().strip().replace(',', '.'));
                break;
            } catch (RuntimeException e) {System.out.println("Некоректный ввод!");}
        }
        while (true) {
            System.out.print("Введите вещественную коорд Z: ");
            try {
                z = Float.parseFloat(scanner.nextLine().strip().replace(',', '.'));
                break;
            } catch (RuntimeException e) {System.out.println("Некоректный ввод!");}
        }
        while (true) {
            System.out.print("Введите название локации: ");
            name = scanner.nextLine().strip().replaceAll("\\s+", " ");
            if (!name.isEmpty()) break;
            System.out.println("Название не может быть пустым!");
        }

        return new Location(x, y, z, name);
    }
}
