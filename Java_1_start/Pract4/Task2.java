package Pract4;

import java.util.LinkedList;

/*
 * В классе MyQueueInt реализуйте очередь для типа данных Integer 
 * с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди
dequeue() - возвращает первый элемент из очереди и удаляет его
first() - возвращает первый элемент из очереди, не удаляя
getElements() - возвращает все элементы в очереди
 */

public class Task2 {

    public static class MyQueue<T> {
        private LinkedList<T> myQueue = new LinkedList<>();

        public void enqueue(T element) {
            myQueue.addLast(element);
        }

        public T dequeue() {
            if (!myQueue.isEmpty()) {
                return myQueue.removeFirst();
            }
            return null; // или выбросить исключение, если очередь пуста
        }

        public T first() {
            if (!myQueue.isEmpty()) {
                return myQueue.getFirst();
            }
            return null; // или выбросить исключение, если очередь пуста
        }

        public LinkedList<T> getElements() {
            // return new LinkedList<>(myQueue);
            return myQueue;
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        if (args.length == 0) {
            queue.enqueue(1);
            queue.enqueue(10);
            queue.enqueue(15);
            queue.enqueue(5);
        } else {
            queue.enqueue(Integer.parseInt(args[0]));
            queue.enqueue(Integer.parseInt(args[1]));
            queue.enqueue(Integer.parseInt(args[2]));
            queue.enqueue(Integer.parseInt(args[3]));
        }

        System.out.println(queue.getElements());

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());

        System.out.println(queue.first());
    }
}