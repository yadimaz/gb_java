package Pract6;

import java.util.Objects;

/*
 Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …

Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
условиям.
 */

public class Notebook {
    private String brand;
    private String model;
    private double weight;
    private double screenDiag;
    private String cpu;
    private int memory;
    private int hdd;
    private String os;
    private String color;

    public Notebook(String brand, String model, double weight, double screenDiag, String cpu, int memory, int hdd, String os,
            String color) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.screenDiag = screenDiag;
        this.cpu = cpu;
        this.memory = memory;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }

    public double getScreenDiag() {
        return screenDiag;
    }

    public String getCpu() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }

    public int gethdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setScreenDiag(double screenDiag) {
        this.screenDiag = screenDiag;
    }

    public void setScreenDiag(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void sethdd(int hdd) {
        this.hdd = hdd;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, os);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Notebook ntbook = (Notebook) obj;
        return brand.equals(ntbook.brand) && model.equals(ntbook.model) &&  os.equals(ntbook.os);
    }

    @Override
    public String toString() {
        String res = brand + " " + model + System.lineSeparator() 
        + "Диагональ: " + screenDiag + " дюймов" + System.lineSeparator()
        + "Процессор: " + cpu + System.lineSeparator()
        + "Память: " + memory + " Гб" + System.lineSeparator()
        + "Жесткий диск: " + hdd + " Гб" + System.lineSeparator()
        + "Операционная система: " + os + System.lineSeparator()
        + "Цвет: " + color + System.lineSeparator()
        + "Вес " + weight + " кг.";
        return res;
    }
}
