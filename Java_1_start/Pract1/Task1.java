package Pract1;
// Вычислить n-ое треугольного число(сумма чисел от 1 до n).
// Внутри класса Answer напишите метод countNTriangle, который принимает число n
// и возвращает его n-ое треугольное число.
// Если число n < 1 (ненатуральное) метод должен вернуть -1.
public class Task1 {
    public static void main(String[] args) {
        int n = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            n = 4;
        } else {
            n = Integer.parseInt(args[0]);
        }

        // Вывод результата на экран
        Answer ans = new Answer();
        int itresume_res = ans.countNTriangle(n);
        System.out.println(itresume_res);

    }

    static class Answer {
        public int countNTriangle(int n) {
            // Введите свое решение ниже
            int sumN = 0;
            while (n > 0) {
                sumN += n;
                n--;
            }
            return sumN;
        }
    }

}
