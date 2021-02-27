package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCompareTest {

    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Ivanov", "Ivanov");
        assertThat(result, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Ivanov", "Ivanova");
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenSecondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Petrov", "Patrov");
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Petrov", "Ivanova");
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Patrov", "Petrov");
        assertThat(result, lessThan(0));
    }
}