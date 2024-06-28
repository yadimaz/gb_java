package Sem6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CatMain {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Васька", 2011, "Черный", "Иванов Иван");
        Cat cat2 = new Cat("Мурзик", 2020, "Белый", "Петров Петр");
        Cat cat3 = new Cat("Беляш", 2015, "Трехцветный", "Малятин Александр");

        System.out.println(cat1 + System.lineSeparator());
        System.out.println(cat2 + System.lineSeparator());
        System.out.println(cat3 + System.lineSeparator());
        Cat cat4 = new Cat("Beliash", 2015, "Threecolored", "Maliatin Aleksandr");
        Cat cat5 = new Cat("Vaska", 2011, "Black", "Ivanov Ivan");

        Set<Cat> cats = new HashSet<>(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

        for (Cat cat : cats) {
            System.out.println(cat);
            System.out.println();
        }
    }
}
