package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.SortedArrayStorage;
import ru.javawebinar.basejava.storage.Storage;

/**
 * Test for your ru.javawebinar.basejava.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r7 = new Resume("uuid7", "fullname7");
        Resume r1 = new Resume("uuid1", "fullname1");
        Resume r5 = new Resume("uuid5", "fullname5");
        Resume r3 = new Resume("uuid3", "fullname3");
        Resume r9 = new Resume("uuid9", "fullname9");

        ARRAY_STORAGE.save(r7);
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        ARRAY_STORAGE.update(new Resume("uuid1", "fullname1"));
//        ARRAY_STORAGE.update(r9);

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
