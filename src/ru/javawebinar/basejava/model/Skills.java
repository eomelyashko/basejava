package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;

public class Skills implements Section {
    private List<String> value;

    public Skills(String ... value) {
        this.value = Arrays.asList(value);
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(String...value) {
        this.value = Arrays.asList(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skills skills = (Skills) o;

        return value.equals(skills.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "Skills{" +
                "value='" + value + '\'' +
                '}';
    }
}
