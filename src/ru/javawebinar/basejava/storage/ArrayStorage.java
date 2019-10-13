package ru.javawebinar.basejava.storage;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void removeResume(int idx) {
        storage[idx] = storage[size-1];
    }

    @Override
    protected int addResume(int index) {
        return size;
    }

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
