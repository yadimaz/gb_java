/*Задание №3
Дан массив nums = [3,2,2,3] и число val = 3.
Если в массиве есть числа, равные заданному, нужно перенести
эти элементы в конец массива.
Таким образом, первые несколько (или все) элементов массива
должны быть отличны от заданного, а остальные - равны ему. */

import java.util.Arrays;

public class ArrayNum {
    public static void main(String[] args) {
        int val = 8;
        int[] nums = { 3, 2, 2, 3, 2, 8, 1, 3, 3, 8, 65, 7, 0, -2, 33, 9, 331, 789 };
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (nums[right] == val && left < right) {
                right--;
            }

            if (nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = val;
            }
            left++;
        }

        System.out.println(Arrays.toString(nums));
    }
}