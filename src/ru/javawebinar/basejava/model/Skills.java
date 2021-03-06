package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Skills extends Section {
    private final List<String> items;

    public Skills(String... items) {
        this(Arrays.asList(items));
    }

    public Skills(List<String> items) {
        Objects.requireNonNull(items, "value must not be null");
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skills skills = (Skills) o;

        return items.equals(skills.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
