package org.example.homework4;

public class Square {

    public double squareTriangle(int a, int b, int c) {
        double p = (a + b + c)/2.0;
        double res = Math.sqrt(p * (p - a) * (p-b) * (p - c));
        return res;
    }
}
