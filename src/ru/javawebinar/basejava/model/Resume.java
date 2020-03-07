package ru.javawebinar.basejava.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;

    private String fullName;

    private Map<ContactsType, String> contacts = new EnumMap<>(ContactsType.class);

    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public void addContacts(ContactsType contactsType, String link) {
        contacts.put(contactsType, link);
    }

    public void addProfile(SectionType sectionType, Profile profile) {
        sections.put(sectionType, profile);
    }

    public void addSkills(SectionType sectionType, Skills skill) {
        sections.put(sectionType, skill);
    }

    public void addPositions(SectionType sectionType, Position ... position) {
        sections.put(sectionType, new PositionList(position));
    }

    public String getContacts(ContactsType type) {
        return contacts.get(type);
    }

    public Section getSection(SectionType type) {
        return sections.get(type);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return !fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')' +
                contacts + "\n" +
                sections + "\n";
    }
}
