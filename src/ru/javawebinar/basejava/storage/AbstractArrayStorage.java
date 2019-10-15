package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public final void update(Resume resume) {
        int idx = find(resume.getUuid());
        if (idx < 0) {
            System.out.println("Resume " + resume.getUuid() + " не найдено");
        } else {
            storage[idx] = resume;
            System.out.println("Resume " + resume.getUuid() + " обновлено");
        }
    }

    public final void save(Resume resume) {
        int idx = find(resume.getUuid());
        if (idx >= 0) {
            System.out.println("В хранилище доступно Resume " + resume.getUuid());
        } else if (size == STORAGE_LIMIT) {
            System.out.println("В хранилище нет места");
        } else {
            addResume(resume, idx);
            size++;
        }
    }

    public final Resume get(String uuid) {
        int idx = find(uuid);
        if (idx < 0) {
            System.out.println("Resume " + uuid + " не найдено");
            return null;
        }
        return storage[idx];
    }

    public final void delete(String uuid) {
        int idx = find(uuid);
        if (idx < 0) {
            System.out.println("Resume " + uuid + " не найдено");
        } else {
            removeResume(idx);
            storage[size - 1] = null;
            size--;
        }
    }

    public int size() {
        return size;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }


    protected abstract void removeResume(int idx);

    protected abstract void addResume(Resume resume, int idx);

    protected abstract int find(String uuid);
}
