package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PositionList extends Section {
    private final List<Position> value;

    public PositionList(Position ... value) {
        Objects.requireNonNull(value, "value must not be null");
        this.value = Arrays.asList(value);
    }

    public List<Position> getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionList that = (PositionList) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
