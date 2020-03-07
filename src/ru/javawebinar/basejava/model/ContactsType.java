package ru.javawebinar.basejava.model;

public enum ContactsType {
    PHONE("Тел."),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний тел."),
    SKYPE("Skype"),
    MAIL("Почта"),
    LINKEDIN("LinkedIn"),
    GITHUB("GitHub"),
    STACKOVERFLOW("StackOverflov"),
    HOME_PAGE("Домашняя страница");

    private final String title;

    ContactsType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

