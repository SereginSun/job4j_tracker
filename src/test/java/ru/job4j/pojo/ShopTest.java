package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void whenLastIsNull() {
        Shop billa = new Shop();
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int result = billa.indexOfNull(products);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstIsNull() {
        Shop billa = new Shop();
        Product[] products = new Product[5];
        products[1] = new Product("Milk", 10);
        products[2] = new Product("Bread", 4);
        products[3] = new Product("Egg", 19);
        int result = billa.indexOfNull(products);
        assertThat(result, is(0));
    }

    @Test
    public void whenHasNotNull() {
        Shop billa = new Shop();
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int result = billa.indexOfNull(products);
        assertThat(result, is(-1));
    }
}