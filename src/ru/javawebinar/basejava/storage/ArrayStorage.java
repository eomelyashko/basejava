package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void removeResume(int idx) {
        storage[idx] = storage[size - 1];
    }

    @Override
    protected void addResume(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected Integer getSearchKey(String searchKey) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(searchKey.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}
