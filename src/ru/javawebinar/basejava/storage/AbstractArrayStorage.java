package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int idx = find(uuid);
        if (idx < 0) {
            System.out.println("Resume " + uuid + " не найдено");
            return null;
        }
        return storage[idx];
    }

    protected abstract int find(String uuid);
}
