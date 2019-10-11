package ru.javawebinar.basejava.storage;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int find(String searchKey) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(searchKey.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}
