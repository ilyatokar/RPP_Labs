package com.company;

public class Main {
    public static final String A = "Значение глобальной константы метода";

    public static void main(String[] args) {
        final String B = "Значение локально константы метода";
        String C = "Значение локальной переменной метода";

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }
}
