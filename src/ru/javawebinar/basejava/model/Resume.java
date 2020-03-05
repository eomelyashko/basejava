package ru.javawebinar.basejava.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;

    private String fullName;

    private Map<ContactsType, Contacts> contactsMap;

    private Map<SectionType, Section> sectionMap;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
        this.contactsMap = new HashMap<>();
        this.sectionMap = new HashMap<>();
    }

    public void addContacts(ContactsType contactsType, Contacts contact) {
        contactsMap.put(contactsType, contact);
    }

    public void addProfile(SectionType sectionType, Profile profile) {
        sectionMap.put(sectionType, profile);
    }

    public void addSkills(SectionType sectionType, Skills skill) {
        sectionMap.put(sectionType, skill);
    }

    public void addPositions(SectionType sectionType, Position ... position) {
        sectionMap.put(sectionType, new PositionList(position));
    }

    public Contacts getContacts(ContactsType contactsType) {
        return contactsMap.get(contactsType);
    }

    public Section getSection(SectionType sectionType) {
        return sectionMap.get(sectionType);
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
        if (!fullName.equals(resume.fullName)) return false;
        if (!contactsMap.equals(resume.contactsMap)) return false;
        return sectionMap.equals(resume.sectionMap);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + contactsMap.hashCode();
        result = 31 * result + sectionMap.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Resume{" + "\n" +
                "uuid='" + uuid + '\'' + "\n" +
                ", fullName='" + fullName + '\'' + "\n" +
                ", contactsMap=" + contactsMap + "\n" +
                ", sectionMap=" + sectionMap + "\n" +
                '}';
    }
}
