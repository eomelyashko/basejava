package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        int idx = find(resume.getUuid());
        if (idx < 0) {
            if (size >= storage.length) {
                System.out.println("В хранилище нет места");
            } else {
                storage[size] = resume;
                size++;
            }
        } else {
            System.out.println("В хранилище доступно Resume " + resume.getUuid());
        }
    }

    public void update(Resume resume) {
        int idx = find(resume.getUuid());
        if (idx < 0) {
            System.out.println("Resume " + resume.getUuid() + " не найдено");
        } else {
            storage[idx] = resume;
        }
    }

    public Resume get(String uuid) {
        int idx = find(uuid);
        if (idx < 0) {
            System.out.println("Resume " + uuid + " не найдено");
            return null;
        }
        return storage[idx];
    }

    public void delete(String uuid) {
        int idx = find(uuid);
        if (idx < 0) {
            System.out.println("Resume " + uuid + " не найдено");
        } else {
            storage[idx] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    private int find(String searchKey) {
        for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(searchKey.toLowerCase())) {
                    return i;
                }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
