package ru.job4j.pojo;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class LicenseTest {

    @Test
    public void equalsName() {
        License first = new License();
        first.setOwner("Vladimir");
        first.setModel("audi");
        first.setCode("136RUS");
        first.setCreated(LocalDate.now());
        License second = new License();
        second.setOwner("Vladimir");
        second.setModel("audi");
        second.setCode("136RUS");
        second.setCreated(LocalDate.now());
        assertThat(first, is(second));
    }
}