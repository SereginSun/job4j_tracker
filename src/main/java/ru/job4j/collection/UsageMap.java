package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("sereginsun@yandex.ru", "Vladimir Seregin");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.printf("%s = %s%n", key, value);
        }
    }
}
