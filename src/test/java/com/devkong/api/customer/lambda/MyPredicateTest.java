package com.devkong.api.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;

class MyPredicateTest {

    @Test
    void test1() {
        List<String> list = new ArrayList<>();
        list.add("bithumb");
        list.add("");
        list.add("kakaoTalk");
        list.add("");

        Predicate<String> predicate = s -> !s.isEmpty();
        List<String> newList = filterList(list, predicate);
        assertThat(newList, is(equalTo(Arrays.asList("bithumb", "kakaoTalk"))));

        Predicate<Integer> integerFilter = e -> e % 2 == 0;
        List<Integer> intList = Arrays.asList(4,5,6,8);
        List<Integer> result = filterList(intList, integerFilter);
        assertThat(result, is(equalTo(Arrays.asList(4, 6, 8))));



    }

    private <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();

        for(T string : list) {
            if(predicate.test(string)) {
                newList.add(string);
            }
        }
        return newList;
    }
}