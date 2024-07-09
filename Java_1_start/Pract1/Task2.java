package Pract1;
/*
Напишите функцию  printPrimeNums, которая выведет на экран все простые числа 
в промежутке от 1 до 1000, каждое на новой строке.  
*/

public class Task2 {
    public static void main(String[] args) {
        Answer ans = new Answer();
        ans.printPrimeNums();
    }

    static class Answer {
        public void printPrimeNums() {
            for (int i = 2; i < 1000; i++) {
                boolean flag = true;
                for (int j = 2; j < Math.sqrt(i); j++) {
                    if (i % j == 0) {
                         flag = false;
                    }    
                }
                if (flag) {
                     System.out.printf("%d\n", i);
                }
            }
        }
    }
}
