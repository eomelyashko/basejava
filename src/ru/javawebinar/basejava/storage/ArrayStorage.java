package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
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

    @Override
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
