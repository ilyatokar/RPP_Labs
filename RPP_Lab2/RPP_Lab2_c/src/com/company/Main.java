package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        final double a, b, c, x;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите a = ");
            a = Double.parseDouble(String.valueOf(reader.readLine()));
            System.out.print("Введите b = ");
            b = Double.parseDouble(String.valueOf(reader.readLine()));
            System.out.print("Введите c = ");
            c = Double.parseDouble(String.valueOf(reader.readLine()));
            System.out.print("Введите x = ");
            x = Double.parseDouble(String.valueOf(reader.readLine()));
            double result = (Math.sqrt(a/(1+(b*Math.pow(x,2)))))+(b*Math.atan(x))+(Math.exp(c*x));
            System.out.println(result);
        }catch (Exception e){
            System.out.println("Ошибка ввода данных");
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
