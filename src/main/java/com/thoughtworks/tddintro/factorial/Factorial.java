package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        if(i < 0)
            throw new IllegalArgumentException("Attempted " + i + "!, but cannot take the factorial of a negative number");
        if(i <= 1)
            return 1;
        else
            return i * compute(i - 1);
    }
}
