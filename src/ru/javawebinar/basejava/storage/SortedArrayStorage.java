package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);
/*
    private static class ResumeComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }
*/

    @Override
    protected void addResume(Resume resume, int index) {
        int insertIdx = Math.abs(index) - 1;
        // сдвиг элементов на 1 ячейку
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx] = resume;
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
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "default");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
