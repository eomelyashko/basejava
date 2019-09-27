package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {
        int idx = find(r.getUuid());
        if (idx < 0) {
            if (size >= storage.length) {
                System.out.println("В хранилище нет места");
            } else {
                storage[size] = r;
                size++;
            }
        } else {
            //дубль
        }
    }

    public void update(Resume r) {
        int idx = find(r.getUuid());
        if (idx < 0) {
            System.out.println("com.urise.webapp.model.Resume не найдено");
        } else {
            storage[idx] = r;
        }
    }

    public Resume get(String uuid) {
        int idx = find(uuid);
        if (idx >= 0) { // если значение меньше 0 то com.urise.webapp.model.Resume нет в списке
            return storage[idx];
        } else {
            System.out.println("com.urise.webapp.model.Resume не найдено");
            return null;
        }
    }

    public void delete(String uuid) {
        int findIdx = find(uuid);
        if (findIdx < 0) {
            System.out.println("com.urise.webapp.model.Resume не найдено");
        } else {
            storage[findIdx] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public int find(String searchKey) {
        int currentIdx = 0;
        for (int i = currentIdx; currentIdx < size; currentIdx++) {
                if (storage[currentIdx].getUuid() == (searchKey.toLowerCase())) {
                    return currentIdx; // Элемент найден
                }
        }
        return -1; //если элемента в списке нет возвращаем -1
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size); //думаю этот метод подойдет лучше стрима с фильтром
    }

    public int size() {
        return size;
    }
}
