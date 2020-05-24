package com.company;

public class Main {

    public static void main(String[] args) {
        if(args.length > 0){
            try {
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[1]);
                double c = Double.parseDouble(args[2]);
                double x = Double.parseDouble(args[3]);
                double result = (Math.sqrt(a/(1+(b*Math.pow(x,2)))))+(b*Math.atan(x))+(Math.exp(c*x));
                System.out.println(result);
            }catch (Exception e){
                System.out.println("Ошибка перевода чисел из аргументов");
                System.out.println(e);
            }
        }else{
            System.out.println("No args defined.");
        }

    }
}
