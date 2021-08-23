package com.devkong.api.customer.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MyInterfaceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void myMethod() {
        //Imperative
        int sumOfEvents = 0;

        for(int i=1 ; i<=100 ; i++) {
            if( i % 2 == 0) {
                sumOfEvents += i;
            }
        }

        System.out.println(sumOfEvents);

        sumOfEvents = IntStream.rangeClosed(1,100)
                .filter(i -> i % 2 == 0)
                .reduce( (x, y) -> x + y)
                .getAsInt();

        System.out.println(sumOfEvents);
    }
}