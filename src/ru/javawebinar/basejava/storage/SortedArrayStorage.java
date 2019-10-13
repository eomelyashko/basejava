package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addAndIncrementResume(Resume resume) {
        int idx = Math.abs(find(resume.getUuid())) - 1;
        for (int i = size; i > idx; i--) { // сдвиг элементов на 1 ячейку
            storage[i] = storage[i - 1];
        }
        storage[idx] = resume;
        size++;
    }

    @Override
    protected void removeResume(int idx) {
        for (int i = idx; i < size; i++) { // смещение элементов
            storage[i] = storage[i + 1];
        }
    }

    @Override
    protected int find(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
