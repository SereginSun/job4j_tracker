package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student firstStudent = new Student();
        firstStudent.setFullName("Seregin Vladimir");
        firstStudent.setGroup("job4j-20");
        firstStudent.setEntranceDate(LocalDate.of(2020, 11, 6));

        System.out.printf(
                "Student: %s%nGroup: %10s%nFrom: %13s",
                firstStudent.getFullName(),
                firstStudent.getGroup(),
                firstStudent.getEntranceDate()
        );
    }
}
