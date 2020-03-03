package ru.javawebinar.basejava.model;

public enum ContactsType {
    PHONE("Тел."),
    SKYPE("Skype"),
    EMAIL("Почта"),
    OTHER("Профиль");

    private String title;

    ContactsType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

