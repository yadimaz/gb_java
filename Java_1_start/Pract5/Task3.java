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

public class Task3 {

    public static class HeapSort {
        public static ArrayList<Integer> buildTree(int[] tree, int sortLength) {
            // Введите свое решение ниже
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            for (int i = 0; i < tree.length; i++) {
                if (!tMap.containsKey(tree[i])) {
                    tMap.put(tree[i], 1);
                } else {
                    int numCount = tMap.get(tree[i]) + 1;
                    tMap.put(tree[i], numCount);
                }

            }
            int i = 0;
            ArrayList<Integer> initArray = new ArrayList<>(sortLength);

            for (int elem : tMap.keySet()) {
                //System.out.println(elem  +  " " + tMap.get(elem));

                if (tMap.get(elem) == 1) {
                    initArray.add(elem);
                    i++;
                } else {
                    for (int j = 0; j < tMap.get(elem); j++) {
                        initArray.add(elem);
                        i++;              
                    }
                }

            }
            System.out.println(initArray);
            return initArray;
        }

        public static ArrayList<Integer> heapSort(int[] sortArray, int sortLength) {
            // Введите свое решение ниже
            return buildTree(sortArray, sortLength);
            
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
