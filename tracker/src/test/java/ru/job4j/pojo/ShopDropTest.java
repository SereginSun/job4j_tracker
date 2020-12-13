package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShopDropTest {

    @Test
    public void whenDropFirst() {
        ShopDrop billa = new ShopDrop();
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] result = billa.leftShift(products, 0);
        assertThat(result[0].getName(), is("Bread"));
        assertThat(result[1], is(nullValue()));
    }

    @Test
    public void whenDropLast() {
        ShopDrop billa = new ShopDrop();
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] result = billa.leftShift(products, 1);
        assertThat(result[0].getName(), is("Milk"));
        assertThat(result[1], is(nullValue()));
    }

    @Test
    public void whenDropMiddle() {
        ShopDrop billa = new ShopDrop();
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        Product[] result = billa.leftShift(products, 1);
        assertThat(result[0].getName(), is("Milk"));
        assertThat(result[1].getName(), is("Egg"));
        assertThat(result[2], is(nullValue()));
    }
}