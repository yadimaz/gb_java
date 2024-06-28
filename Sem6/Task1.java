package Sem6;

/*
1. Напишите метод, который заполнит массив из 1000 элементов случайными
числами от 0 до 500
2. Создайте метод, в который передайте заполненный выше массив и с
помощью Set вычислите процент уникальных значений в данном массиве и
верните его в виде числа с плавающей запятой.
Для вычисления процента используйте формулу:
процент уникальных чисел = количество уникальных чисел * 100 / общее
количество чисел в массиве.
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task1 {
    private static int[] getIntArray(int count, int start, int end) {
        int[] arr = new int[count];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(start, end + 1);
        }
        return arr;
    }

    private static double getPercentUniqElems(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int el : arr) {
            set.add(el);
        }
        double uniqEls = set.size() * 100.0 / arr.length;
        return uniqEls;
    }

    public static void main(String[] args) {
        int[] arr = getIntArray(1000, 0, 500);
        double uniqEls = getPercentUniqElems(arr);
        System.out.println("Процент уникальных элементов: " + uniqEls);
    }
}
