package Pract3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/*
 * Реализуйте метод, который принимает на вход целочисленный массив arr:
- Создаёт список ArrayList, заполненный числами из исходого массива arr.
- Сортирует список по возрастанию и выводит на экран.
- Находит минимальное значение в списке и выводит на экран - Minimum is {число} 
- Находит максимальное значение в списке и выводит на экран - Maximum is {число}
- Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает на вход один параметр:

Integer[] arr - массив целых чисел.
 */
public class Task3 {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            //arr = new Integer[] { 4, 2, 7, 5, 1, 3, 8, 6, 9 };
            arr = new Integer[] {-2, -1, 0, 1, 2, 3, 4, 5};
        } else {
            arr = Arrays.stream(args[0].split(", ")).map(Integer::parseInt).toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.analyzeNumbers(arr);

    }

    public static class Answer {
        public static void analyzeNumbers(Integer[] arr) {
            // Введите свое решение ниже
            ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(arr));
            Collections.sort(lst);
            Iterator<Integer> iter = lst.iterator();
            double sumNum = 0;
            while (iter.hasNext()) {
                sumNum += iter.next();
            }
            double res = (sumNum / lst.size());
            System.out.println(lst);
            System.out.printf("Minimum is %d\n", lst.get(0));
            System.out.printf("Maximum is %d\n", lst.get(lst.size() - 1));
            System.out.printf("Average is = %.1f", res);
        }
    }
}
