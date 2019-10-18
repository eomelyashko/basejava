package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addResume(Resume resume, int index) {
        int idx = Math.abs(index) - 1;
        // сдвиг элементов на 1 ячейку
        System.arraycopy(storage, idx, storage, idx + 1, size - idx);
        storage[idx] = resume;
    }

    @Override
    protected void removeResume(int idx) {
        //https://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
        int numMoved = size - idx - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, idx + 1, storage, idx, numMoved);
        }
    }

    @Override
    protected int find(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
