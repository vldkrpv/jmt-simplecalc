package com.company.simplecalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("\nEnter expression: ");
                Expression expression = new Expression(reader.readLine());
                System.out.print("Result: ");
                System.out.println(expression.evaluate());
            }
        }
    }
}
