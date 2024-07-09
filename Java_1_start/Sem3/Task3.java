package Sem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Создать список типа ArrayList<String>.

// Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.

public class Task3 {

    private static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void deleteInt(List<String> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (isInt(lst.get(i))) {
                lst.remove(i);
                i--;
            }
        }
    }

    private static void deleteIntIter(List<String> lst) {
        // Iterator<String> iter = lst.iterator();
          Iterator<String> iter = lst.iterator();
        while (iter.hasNext()) {
            String elem = iter.next();
            if (isInt(elem)) {
                iter.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<String> lst = new ArrayList<>(Arrays.asList("One", "Two", "three", "1", "2", "Привет", "-10", "Кто тут"));
        // deleteInt(lst);
        deleteIntIter(lst);
        System.out.println(lst);
    }
}