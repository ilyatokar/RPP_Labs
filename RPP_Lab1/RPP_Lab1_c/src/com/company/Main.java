package com.company;

public class Main {

    public static void main(String[] args) {
        if(args.length > 0){
            try {
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);
                System.out.println(sum(a, b));
            }catch (Exception e){
                System.out.println("Ошибка перевода чисел из аргументов");
                System.out.println(e);
            }
        }else{
            System.out.println("No args defined.");
        }
    }

    public static int sum(int a, int b){
        return a+b;
    }
}
