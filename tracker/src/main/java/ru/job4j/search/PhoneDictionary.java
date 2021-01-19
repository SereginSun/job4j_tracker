package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Return a list of all users containing key in any fields.
     * @param key Search key.
     * @return List of found users.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (person.getName().contains(key)
                            || person.getSurname().contains(key)
                            || person.getPhone().contains(key)
                            || person.getAddress().contains(key)
            ) {
                result.add(person);
            }
        }
        return result;
    }
}
