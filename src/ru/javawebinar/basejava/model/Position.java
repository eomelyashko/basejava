package ru.javawebinar.basejava.model;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static ru.javawebinar.basejava.util.DateUtil.*;

public class Position {
    private final Link link;
    private List<Experience> experiences = new ArrayList<>();

    public Position(String value, String link, Experience... experiences) {
        this(new Link(value, link), Arrays.asList(experiences));
    }

    public Position(Link link, List<Experience> experiences) {
        this.link = link;
        this.experiences = experiences;
    }

    public Link getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(link, position.link) &&
                Objects.equals(experiences, position.experiences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, experiences);
    }

    @Override
    public String toString() {
        return "Position(" + link + ", " + experiences +')';
    }

    public static class Experience {
        private final String header;
        private final String description;

        private final LocalDate fromDate;
        private final LocalDate toDate;

        public Experience(String header, String description, int startYear, Month startMonth) {
            this(header, description, of(startYear, startMonth), NOW);
        }

        public Experience(String header, String description, int startYear, Month startMonth, int endYear, Month endMonth) {
            this(header, description, of(startYear, startMonth), of(endYear, endMonth));
        }

        public Experience(String header, String description, LocalDate fromDate, LocalDate toDate) {
            Objects.requireNonNull(fromDate, "fromDate must not be null");
            Objects.requireNonNull(toDate, "toDate must not be null");
            Objects.requireNonNull(description, "header  must not be null");
            this.header = header;
            this.description = description;
            this.fromDate = fromDate;
            this.toDate = toDate;
        }

        public String getHeader() {
            return header;
        }

        public String getDescription() {
            return description;
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
            Experience that = (Experience) o;
            return Objects.equals(header, that.header) &&
                    Objects.equals(description, that.description) &&
                    Objects.equals(fromDate, that.fromDate) &&
                    Objects.equals(toDate, that.toDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(header, description, fromDate, toDate);
        }

        @Override
        public String toString() {
            String today = toDate.equals(NOW) ? "Сейчас" : toDate.toString();
            return "Experience(" + header + ", " + description + ", " + fromDate +", " + today +')';
        }
    }
}
