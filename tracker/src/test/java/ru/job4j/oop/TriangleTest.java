package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void whenTriangleExistThanArea() {
        Point first = new Point(0, 0);
        Point second = new Point(4, 0);
        Point third = new Point(0, 4);
        Triangle triangle = new Triangle(first, second, third);
        double result = triangle.area();
        assertThat(result, closeTo(8, 0.001));
    }
}