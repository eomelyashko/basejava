package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int idx = find(resume.getUuid());
        if (idx < 0) {
            if (size >= storage.length) {
                System.out.println("В хранилище нет места");
            } else {
                idx = Math.abs(find(resume.getUuid())) - 1;
                for (int i = size; i > idx; i--) { // сдвиг элементов на 1 ячейку
                    storage[i] = storage[i - 1];
                }
                storage[idx] = resume;
                size++;
            }
        } else {
            System.out.println("В хранилище доступно Resume " + resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        int idx = find(uuid);
        if (idx < 0) {
            System.out.println("Resume " + uuid + " не найдено");
        } else {
            for (int i = idx; i < size; i++) { // смещение элементов
                storage[i] = storage[i + 1];
            }
            size--;
        }
    }

    @Override
    protected int find(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
