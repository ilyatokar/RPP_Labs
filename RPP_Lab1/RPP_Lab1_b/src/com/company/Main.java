package com.company;

public class Main {

    public static void main(String[] args) {
        if(args.length > 0){
            for( String text : args){
                System.out.print(text);
            }
            System.out.println();
        }else{
            System.out.println("No args defined.");
        }
    }
}
