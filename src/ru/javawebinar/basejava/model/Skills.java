package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;

public class Skills implements Section {
    List<String> value;

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
    public String toString() {
        return "Skills{" +
                "value='" + value + '\'' +
                '}';
    }
}
