package com.devkong.api.customer.lambda;

@FunctionalInterface
public interface MyUnaryOp {
    int operator(int a);
}
