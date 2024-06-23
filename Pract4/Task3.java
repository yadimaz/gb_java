package Pract4;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * В обычный калькулятор без логирования добавьте возможность отменить последнюю операцию.
Отмена последней операции должна быть реализована следующим образом: 
если передан оператор '<' калькулятор должен вывести результат предпоследней операции.
 */

public class Task3 {

    public static class Calculator {
        double res;
        Deque<Double> resDeque = new ArrayDeque<>(2);

        public double calculate(char op, int a, int b) {
            // Напишите свое решение ниже

            if (op == '+') {
                res = a + b;
            } else if (op == '-') {
                res = a - b;
            } else if (op == '*') {
                res = a * b;
            } else if (op == '<') {
                return resDeque.peekLast();
                //return resDeque.getLast();
            } else {
                System.err.println("Команда не распознана");
                return 0;
            }

            if (resDeque.size() == 2) {
                resDeque.removeLast();
            }
            resDeque.addFirst(res);
            return res;
        }
    }

    public static void main(String[] args) {
        int a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
            c = 4;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        // double result = calculator.calculate(op, a, b);
        // System.out.println(result);
        // double result2 = calculator.calculate(op2, c, d);
        // System.out.println(result2);
        // double prevResult = calculator.calculate(undo, 0, 0);
        // System.out.println(prevResult);

        System.out.println(calculator.calculate('*', 3, 2));
        System.out.println(calculator.calculate('-', 7, 4));
        System.out.println(calculator.calculate('<', 0, 0));
    }
}
