package Pract6;

import javax.swing.*;
import java.util.*;

public class NotebookMain {
    public static void main(String[] args) {
        Notebook ntb1 = new Notebook("Acer", "Aspire 3 A315-44P-R7ZT", 1.78, 15.6, "AMD Ryzen 5", 8, 512, "без ОС",
                "серебряный");
        Notebook ntb2 = new Notebook("Lenovo", "ThinkPad X280", 1.13, 12.5, "AIntel Core i5 8250U", 8, 256, "Windows 10 Pro",
                "черный");
        Notebook ntb3 = new Notebook("Xiaomi", "Book Pro 16", 1.8, 16, "Intel Core i5 1240p", 16, 512, "Windows 11 Home",
                "черный");
        Notebook ntb4 = new Notebook("ASUS", "Vivobook Go E1504FA-BQ585", 1.63, 15.6, "AMD Ryzen 3 7320U", 8, 256, "без ОС",
                "черный");

        Set<Notebook> ntbks = new HashSet<>(Arrays.asList(ntb1, ntb2, ntb3, ntb4));

        Map<Integer, String> fltrs = getFilters();
        Set<Notebook> ntbksFiltered = search(ntbks,fltrs);

        if (ntbksFiltered.isEmpty()) System.out.println("По данным параметрам >" + fltrs +"< ничего не найдено");
        else {
            //System.out.println(ntbksFiltered);
            Iterator note = ntbksFiltered.iterator();
            while (note.hasNext()) {
                System.out.println(note.next() + "\n");
            }

        }

    }

    public static Set<Notebook> search (Set<Notebook> ntbks, Map<Integer, String> fltrs) {
        Set<Notebook> ntbksFiltered = new HashSet<>();

        Double fltrsWeigth  = Double.parseDouble(fltrs.get(1));
        Double fltrsScreen  = Double.parseDouble(fltrs.get(2));
        Integer fltrsMem  = Integer.parseInt(fltrs.get(3));
        Integer fltrsHdd  = Integer.parseInt(fltrs.get(4));

        System.out.println("\nВот что нашлось: \n");
        for(Notebook notebook : ntbks) {
            if (notebook.getWeight() >= fltrsWeigth && notebook.getScreenDiag() >= fltrsScreen &&
                    notebook.getMemory() >= fltrsMem && notebook.gethdd() >= fltrsHdd) {
                if(fltrs.containsKey(5)) {
                    if (notebook.getColor().equals(fltrs.get(5).toUpperCase())) ntbksFiltered.add(notebook);
                }
                else ntbksFiltered.add(notebook);
            }
        }

        return ntbksFiltered;
    }

    public static Map<Integer, String> getFilters () {
        Map<Integer, String> filters = new HashMap<>();

        Map<Integer, String> menu = new HashMap<>();
        menu.put(1, "Вес ноутбука, в кг.");
        menu.put(2, "Диагональ матрицы, в дюймах");
        menu.put(3, "Объём оперативной памяти, в Гб");
        menu.put(4, "Объём жесткого диска, в Гб");
        menu.put(5, "Цвет корпуса");

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("1 - Вес\n2 - Диагональ матрицы\n" +
                    "3 - Объём памяти\n4 - Размер жесткого диска\n5 - Цвет\nВведите цифру, соответствующую необходимому критерию: \n");
            int filterKey = scanner.nextInt();

            // Запрос
            System.out.println("filterkey: " + filterKey);
            if (menu.containsKey(filterKey)) {
                System.out.println("Введите значение " + menu.get(filterKey));
                String filterValue = scanner.next();
                filters.put(filterKey,filterValue);
            }
            else System.out.println("Неверное значение категории!!!");

            // Вывод текущих значений фильтра
            System.out.println("Текущие значения фильтра: " + filters);

            // Запрос на окончание цикла
            System.out.println("Задать следующий критерий поиска? 1 - да, 2 - нет");
            int oneTwo = scanner.nextInt();
            if (oneTwo == 2) flag = false;
        }

        // Заполнение отсутствующих парамеров 0
        for (int i = 1; i < menu.size(); i++) {
            if (!filters.containsKey(i)) {
                filters.put(i, "0");
            } else {
                try {
                    Double.parseDouble(filters.get(i));
            }
                catch (Exception e) {
                    filters.put(i, "0");
                }
            }
        }

        System.out.println("Финальные значения фильтра: " + filters);

        scanner.close();
        return filters;

    }

}
