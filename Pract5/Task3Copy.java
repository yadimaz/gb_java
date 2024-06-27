package Pract5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/*
 * Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей (Heap Sort). 
 * 
 * Программа должна работать следующим образом:
Принимать на вход массив целых чисел для сортировки. 
Если массив не предоставлен, программа использует массив по умолчанию.

Сначала выводить исходный массив на экран.
Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.
Выводить отсортированный массив на экран.
Ваше решение должно содержать два основных метода: 
buildTree, который строит сортирующее дерево на основе массива, и 
heapSort, который выполняет собственно сортировку кучей.

Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел и имеет дубликаты.

На входе:
    '5 8 12 3 6 9'
На выходе:
    Initial array:
    [5, 8, 12, 3, 6, 9]
    Sorted array:
    [3, 5, 6, 8, 9, 12]
 */

public class Task3Copy {

    public static class HeapSort {
        public static void buildTree(int[] tree, int sortLength, int i) {
            int n = sortLength;
            // Введите свое решение ниже
            int largest = i; // Инициализируем наибольший элемент как корень
            int l = 2 * i + 1; // левый = 2*i + 1
            int r = 2 * i + 2; // правый = 2*i + 2

            // Если левый дочерний элемент больше корня
            if (l < n && tree[l] > tree[largest])
                largest = l;

            // Если правый дочерний элемент больше, чем самый большой элемент на данный
            // момент
            if (r < n && tree[r] > tree[largest])
                largest = r;
            // Если самый большой элемент не корень
            if (largest != i) {
                int swap = tree[i];
                tree[i] = tree[largest];
                tree[largest] = swap;

                // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
                buildTree(tree, n, largest);
            }
        }

        public static void heapSort(int[] sortArray, int sortLength) {
            // Введите свое решение ниже
            int n = sortLength;

            // Построение кучи (перегруппируем массив)
            for (int i = n / 2 - 1; i >= 0; i--)
                buildTree(sortArray, n, i);

            // Один за другим извлекаем элементы из кучи
            for (int i = n - 1; i >= 0; i--) {
                // Перемещаем текущий корень в конец
                int temp = sortArray[0];
                sortArray[0] = sortArray[i];
                sortArray[i] = temp;

                // Вызываем процедуру heapify на уменьшенной куче
                buildTree(sortArray, i, 0);
            }

        }
    }

    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[] { 17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1 };
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
