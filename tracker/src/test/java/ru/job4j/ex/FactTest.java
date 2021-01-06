package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeNumber() {
        new Fact().calc(-5);
    }

    @Test
    public void when3ThenFact6() {
        int result = new Fact().calc(3);
        assertThat(result, is(6));
    }
}