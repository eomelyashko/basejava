package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class Heading {
    private final String name;

    private final LocalDate fromDate;
    private final LocalDate toDate;

    public Heading(String name, LocalDate fromDate, LocalDate toDate) {
        Objects.requireNonNull(fromDate, "fromDate must not be null");
        Objects.requireNonNull(toDate, "toDate must not be null");
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getDescription() {
        return name;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Heading heading = (Heading) o;

        if (name != null ? !name.equals(heading.name) : heading.name != null) return false;
        if (!fromDate.equals(heading.fromDate)) return false;
        return toDate.equals(heading.toDate);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + fromDate.hashCode();
        result = 31 * result + toDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String today = toDate == null ? "Сейчас" : toDate.toString();
        return "Heading {" +
                "name='" + name + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + today +
                '}';
    }
}
