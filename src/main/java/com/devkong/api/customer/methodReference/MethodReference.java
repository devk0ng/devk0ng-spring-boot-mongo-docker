package com.devkong.api.customer.methodReference;

import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    static class MethodReferenceClass{
        Supplier<Date> newDate = Date::new;
        Consumer<String> print = System.out::print;
        Function<Object, String> objectToString = String::valueOf;
        Function<String, Integer> stringToInteger = Integer::parseInt;
        BiFunction<Integer, Integer, Integer> integerMax = Math::max;

    }
}
