package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addResume(Resume resume, Object index) {
        int idx = Math.abs((Integer) index) - 1;
        // сдвиг элементов на 1 ячейку
        System.arraycopy(storage, idx, storage, idx + 1, size - idx);
        storage[idx] = resume;
    }

    @Override
    protected void removeResume(Object idx) {
        //https://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
        int index = (Integer) idx;
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    @Override
    protected Object find(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
