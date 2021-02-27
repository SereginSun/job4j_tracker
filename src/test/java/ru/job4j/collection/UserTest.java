package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> iter = users.iterator();
        assertThat(iter.next(), is(new User("Ivan", 31)));
        assertThat(iter.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePetrVsIvan() {
        int result = new User("Petr", 32).compareTo(new User("Ivan", 31));
        assertThat(result, greaterThan(0));
    }
}