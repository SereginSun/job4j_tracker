package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("The First", "Some Order"));
        Map<String, Order> result = OrderConvert.process(orders);
        assertThat(result.get("The First"), is(new Order("The First", "Some Order")));
    }
}