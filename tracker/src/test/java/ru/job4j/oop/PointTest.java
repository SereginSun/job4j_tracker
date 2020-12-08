package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void when00To20ThenDistance() {
        Point first = new Point(0, 2);
        Point second = new Point(0, 0);
        double expect = 2;
        double result = first.distance3d(second);
        assertEquals(result, expect, 0.01);
    }

    @Test
    public void when00To20To35ThenDistance3d() {
        Point first = new Point(0, 2, 3);
        Point second = new Point(0, 0, 5);
        double expect = 2.82;
        double result = first.distance3d(second);
        assertEquals(result, expect, 0.01);
    }
}