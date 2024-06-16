package Pract2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/*
Реализуйте алгоритм сортировки пузырьком числового массива, результат 
после каждой итерации запишите в лог-файл.

Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:
int[] arr - числовой массив
После каждого прохода по массиву ваш код должен делать запись в лог-файл 'log.txt' 
в формате год-месяц-день час:минуты {массив на данной итерации}. 
Для логирования использовать логгер logger класса BubbleSort.
arr = new int[]{9, 4, 8, 3, 1};
sort(arr)
// При чтении лог-файла получим:
2023-05-19 07:53 [4, 8, 3, 1, 9]
2023-05-19 07:53 [4, 3, 1, 8, 9]
2023-05-19 07:53 [3, 1, 4, 8, 9]
2023-05-19 07:53 [1, 3, 4, 8, 9]
2023-05-19 07:53 [1, 3, 4, 8, 9]
*/

public class Task2 {

    public static void main(String[] args) {
        int[] arr = {};
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        if (args.length == 0) {
            arr = new int[] { 9, 4, 8, 3, 1 };
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class BubbleSort {
        private static File log;
        private static FileWriter fileWriter;

        public static void clearLogFile(String fileName) {
            try (FileWriter fr = new FileWriter(fileName)) {
                fr.write("");
                fr.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        public static void writeLogToFile(int[] mas, String fileName) {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm ").format(Calendar.getInstance().getTime());
            StringBuilder sb = new StringBuilder();
            sb.append(timeStamp);
            for (int i = 0; i < mas.length; i++) {
                if (i == 0) {
                    sb.append("[").append(Integer.toString(mas[i])).append(", ");
                } else if (i != mas.length - 1) {
                    sb.append(Integer.toString(mas[i])).append(", ");
                } else {
                    sb.append(Integer.toString(mas[i])).append("]");
                }
            }

            try (FileWriter fr = new FileWriter(fileName, true)) {
                fr.write(sb.toString());
                fr.write(System.lineSeparator());

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

        public static void sort(int[] mas) {
            int temp = 0;
            int countChange = 1;
            String fileName = "log.txt";
            clearLogFile(fileName);
            while (countChange > 0) {
                countChange = 0;
                temp = 0;
                for (int i = 1; i < mas.length; i++) {
                    if (mas[i - 1] > mas[i]) {
                        temp = mas[i];
                        mas[i] = mas[i - 1];
                        mas[i - 1] = temp;
                        countChange++;
                        
                    }
                }
                writeLogToFile(mas, fileName);
            }
        }
    }
}
