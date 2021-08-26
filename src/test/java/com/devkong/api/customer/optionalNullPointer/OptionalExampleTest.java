package com.devkong.api.customer.optionalNullPointer;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class OptionalExampleTest {
    @Data
    class Address {
        private final String street;
        private final String city;
        private final String zipcode;
    }

    @Data
    class Member {
        private final Long id;
        private final String name;
        private final Address address;
    }

    @Data
    class Order {
        private final Long id;
        private final Date date;
        private final Member member;
    }

    public String getCityOfMemberFromOrder(Order order) {
        return Optional.ofNullable(order)
                .map(Order::getMember)
                .map(Member::getAddress)
                .map(Address::getCity)
                .orElse("Seoul");
    }

    public Optional<Member> getMemberIfOrderWithin(Order order, int min) {
        return Optional.ofNullable(order)
                .filter(o -> o.getDate().getTime() > System.currentTimeMillis() - min * 1000)
                .map(Order::getMember);
    }

    @Test
    void optionalMethodTest() {
        Integer a = 10;
        Optional<Integer> optional = Optional.of(a);

        Integer integerValue = optional.get();
        assertThat(integerValue, is(equalTo(10)));

        Optional<Integer> emptyOptional = Optional.empty();

        Integer val = emptyOptional.isPresent() ? emptyOptional.get() : 0;
        assertThat(val, is(equalTo(0)));

        Integer orElse = emptyOptional.orElse(0);
        assertThat(orElse, is(equalTo(0)));

        Integer orElseGet = emptyOptional.orElseGet(() -> 0);
        assertThat(orElseGet, is(equalTo(0)));

    }


}
