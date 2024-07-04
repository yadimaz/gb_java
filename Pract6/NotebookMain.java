package Pract6;

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

        for (Notebook ntbk : ntbks) {
            System.out.println(ntbk);
            System.out.println();
        }

        Set<Double> diag = new HashSet<>();
        for (Notebook ntbk : ntbks) {
            diag.add(ntbk.getScreenDiag());
        }
        System.out.println(diag);
    }

    Map<Integer, String> filters = new HashMap<Integer, String>();
    filters.put(1, "brand");
    filters.put(2,"screenDiag");

}
