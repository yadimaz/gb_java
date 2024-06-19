package Sem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<ArrayList<String>> catalog = new ArrayList<>();
        ArrayList<String> genre1 = new ArrayList<>(Arrays.asList("genre1", "book1", "book2", "book3"));
        ArrayList<String> genre2 = new ArrayList<>(Arrays.asList("genre2", "book1", "book2", "book3"));
        ArrayList<String> genre3 = new ArrayList<>(Arrays.asList("genre3", "book1", "book2", "book3"));
        ArrayList<String> genre4 = new ArrayList<>(Arrays.asList("genre4", "book1", "book2", "book3"));
        catalog.addAll(Arrays.asList(genre1, genre2, genre3, genre4)); // добавляем или так

        for (ArrayList<String> genre : catalog) {
            System.out.println(genre);
        }
    }
}
