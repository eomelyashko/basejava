package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void removeResume(int idx) {
        storage[idx] = storage[size-1];
        storage[size-1] = null;
    }

    @Override
    protected void addAndIncrementResume(Resume resume) {
        storage[size++] = resume;
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
