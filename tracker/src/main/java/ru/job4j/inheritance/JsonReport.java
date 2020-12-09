package ru.job4j.inheritance;

public class JsonReport extends TextReport {
    private static final String LN = System.lineSeparator();

    public String generate(String name, String body) {
        return "{" + LN
                + "\"name\"" + " : " + "\"" + name + "\"" + "," + LN
                + "\"body\"" + " : " + "\"" + body + "\"" + LN
                + "}";
    }
}
