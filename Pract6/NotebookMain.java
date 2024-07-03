package Pract6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NotebookMain {
    public static void main(String[] args) {
        Notebook ntb1 = new Notebook("Acer", "Aspire 3 A315-44P-R7ZT", 1.78, 15.6, "AMD Ryzen 5", 8, 512, "нет",
                "серебряный");
        Notebook ntb2 = new Notebook("Lenovo", "AhinkPad X280", 1.13, 12.5, "AIntel Core i5 8250U", 8, 256, "нет",
                "черный");

        Set<Notebook> ntbks = new HashSet<>(Arrays.asList(ntb1, ntb2));

        for (Notebook ntbk : ntbks) {
            System.out.println(ntbk);
            System.out.println();
        }
    }
}
