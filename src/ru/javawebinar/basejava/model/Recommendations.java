package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class Recommendations implements Section {
    String header;
    String description;

    LocalDate fromData;
    LocalDate toData;

    String link;

    public Recommendations(String header, String description, LocalDate fromData, LocalDate toData, String link) {
        this.header = header;
        this.description = description;
        this.fromData = fromData;
        this.toData = toData;
        this.link = link;
    }

    public Recommendations(String header, String description, LocalDate fromData, LocalDate toData) {
        this(header, description, fromData, toData, "");
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFromData() {
        return fromData;
    }

    public void setFromData(LocalDate fromData) {
        this.fromData = fromData;
    }

    public LocalDate getToData() {
        return toData;
    }

    public void setToData(LocalDate toData) {
        this.toData = toData;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Recommendations{" +
                "header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", fromData=" + fromData +
                ", toData=" + toData +
                ", link='" + link + '\'' +
                '}';
    }
}
