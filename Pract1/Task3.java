package Pract1;

public class Task3 {
    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        Calculator calculator = new Calculator();
        double result = calculator.calculate(a, op, b);
        System.out.println(result);
    }

    static class Calculator {
        public double calculate(double a, char op, double b) {
            // Введите свое решение ниже
            
            double res = 0;
            switch (op) {
                case '+': res = a + b; break;
                case '-': res = a - b; break;
                case '*': res = a * b; break;
                case '/': res = a / b; break;
                default: throw new IllegalArgumentException("Неверная операция: " + op);
            }
            return res;
        }
    }

}
