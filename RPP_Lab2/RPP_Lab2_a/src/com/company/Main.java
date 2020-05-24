package com.company;


public class Main {

    public static void main(String[] args) {
        final double a=4.5, b=2.2, c=-1.5, x = 0.85;
        double result = (Math.sqrt(a/(1+(b*Math.pow(x,2)))))+(b*Math.atan(x))+(Math.exp(c*x));
        System.out.println(result);
    }
}
