package Sem4;

/*
 * Реализовать консольное приложение, которое:
1. Принимает от пользователя и “запоминает” строки.
2. Если введено print, выводит строки так, чтобы последняя введенная
была первой в списке, а первая - последней.
3. Если введено revert, удаляет предыдущую введенную строку из памяти.
 */
public class AppMemory {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        List<String> list = new LinkedList<>();

        while (true) {

            System.out.println("Введите текст для сохранения в памяти ");
            System.out.println("Введите \"print\" для вывода списка в обратном порядке ");
            System.out.println("Введите \"revert\" для удаления предыдущего текста ");
            System.out.println("Введите \"q\" для завершения работы ");

            String input = scann.nextLine();

            if (input.equals("q")) {
                System.out.println("До встречи!");
                break;
            }
            if (input.equals("print")) {
                if (list.isEmpty()) {
                    System.err.println("В память не добавлено ни одного слова");
                } else {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        System.out.print(list.get(i) + " ");
                    }
                    System.out.println();
                }
            } else if (input.equals("revert")) {
                list.removeLast();
                System.out.println(list);
            } else {

                list.add(input);
                System.out.println(list);
            }

        }
        scann.close();

    }

}
