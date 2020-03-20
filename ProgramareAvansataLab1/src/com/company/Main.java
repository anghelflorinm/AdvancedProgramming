package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        BonusClass o = new BonusClass();
        o.run(args);
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        int result = computeResult(n);
        System.out.printf("Willy-nilly, this semester I will learn %s\n", languages[result]);

    }
    public static int computeResult(int n) {
        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        do {
            n = digitsSum(n);
        }while(nrDigits(n)>1);
        return n;
    }
    public static int digitsSum(int n)
    {
        int sum = 0;
        while(n!=0)
        {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }
    public static int nrDigits(int n)
    {
        int nrDigits = 0;
        while(n != 0)
        {
            n = n / 10;
            nrDigits++;
        }
        return nrDigits;
    }

}
